package org.yb.service.impl;

import org.apache.shiro.authc.UnknownAccountException;
import org.yb.service.SecurityService;
import org.yb.util.DigestsUtil;

import java.util.Map;

/**
 * @Auther: yb
 * @Date: 2023/4/5 17:47
 * @Description:
 * @Version 1.0.0
 */
public class SecurityServiceImpl implements SecurityService {
    @Override
    public Map<String, String> getPasswordByLoginName(Object userName) {
        if (userName == null || userName.toString().trim().equals("")){
            throw new UnknownAccountException("账号错误");
        }
        return DigestsUtil.entryptPassword("123");
    }
}
