package org.yb.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.yb.service.SecurityService;
import org.yb.service.impl.SecurityServiceImpl;
import org.yb.util.DigestsUtil;

import java.util.Map;

/**
 * @Auther: yb
 * @Date: 2023/4/5 17:55
 * @Description: 自定义realm
 * @Version 1.0.0
 */
public class DefinitionRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    public DefinitionRealm(){
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher(DigestsUtil.SHA1);
        hashedCredentialsMatcher.setHashIterations(DigestsUtil.ITERATIONS);
        setCredentialsMatcher(hashedCredentialsMatcher);
    }

    /**
     *  身份认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        Object principal = authenticationToken.getPrincipal();
        SecurityService securityService = new SecurityServiceImpl();
        Map<String, String> map = securityService.getPasswordByLoginName(principal);
        if(map.isEmpty()){
            throw  new UnknownAccountException("账户不存在");
        }
        String salt = map.get("salt");
        String password = map.get("password");
//        return new SimpleAccount(principal, password, getName());
        return new SimpleAuthenticationInfo(principal, password, ByteSource.Util.bytes(salt), getName());
    }
}
