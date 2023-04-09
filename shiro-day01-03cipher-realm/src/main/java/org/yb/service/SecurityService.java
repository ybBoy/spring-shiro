package org.yb.service;

import java.util.Map;

/**
 * @Auther: yb
 * @Date: 2023/4/5 17:46
 * @Description:
 * @Version 1.0.0
 */
public interface SecurityService {
    Map<String, String> getPasswordByLoginName(Object userName);
}
