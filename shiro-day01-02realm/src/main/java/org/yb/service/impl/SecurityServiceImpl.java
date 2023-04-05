package org.yb.service.impl;

import org.apache.shiro.authc.UnknownAccountException;
import org.yb.service.SecurityService;

/**
 * @Auther: yb
 * @Date: 2023/4/5 17:47
 * @Description:
 * @Version 1.0.0
 */
public class SecurityServiceImpl implements SecurityService {
    @Override
    public String getPasswordByLoginName(Object userName) {
        if (userName == null || userName.toString().trim().equals("")){
            throw new UnknownAccountException("账号错误");
        }
        return "123";
    }
}
