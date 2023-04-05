package org.yb;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;


/**
 * @Auther: yb
 * @Date: 2023/4/5 16:47
 * @Description:  shiro 初入门，读取配置文件的用户信息与登录用户进行校验
 * @Version 1.0.0
 */
public class HelloShiro {

    @Test
    public void shiroLogin() {
        //导入权限ini文件构建权限工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        //工厂构建安全管理器
        SecurityManager securityManager = factory.getInstance();
        //使用SecurityUtils工具生效安全管理器
        SecurityUtils.setSecurityManager(securityManager);
        //使用SecurityUtils工具获得主体
        Subject subject = SecurityUtils.getSubject();
        //构建账号token
        Object principal = subject.getPrincipal();
        //登录操作
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("yb", "123");
        subject.login(usernamePasswordToken);
        System.out.println("登录结果： " + subject.isAuthenticated());
    }
}
