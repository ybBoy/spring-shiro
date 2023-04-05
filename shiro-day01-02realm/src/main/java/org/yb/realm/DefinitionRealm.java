package org.yb.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.yb.service.SecurityService;
import org.yb.service.impl.SecurityServiceImpl;

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
        String password = securityService.getPasswordByLoginName(principal);
//        return new SimpleAccount(principal, password, getName());
        return new SimpleAuthenticationInfo(principal, password, getName());
    }
}
