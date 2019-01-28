package com.oauth.sso.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * Created by xuh
 * DATE 2019/1/23 1:27.
 * version 1.0
 */
@Configuration
@EnableResourceServer
//  开启spring security注解
@EnableGlobalMethodSecurity(prePostEnabled = true)
//  加载 放行路径
//@EnableConfigurationProperties(PermitUrlProperties.class)
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Autowired
    private TokenStore tokenStore;

    @Override
    public void configure(HttpSecurity http) throws Exception {

//        http.formLogin()
//                .loginPage("/login.html")//自定义标准登录界面
//                .loginProcessingUrl("/user/login") //自定义表单请求路径
//                .and()
//                .authorizeRequests()
//                .antMatchers("/login.html", "/user/login").permitAll()//此路径放行 否则会陷入死循环
//                .anyRequest()
//                .authenticated()
//                .and()
//                .csrf().disable()//跨域关闭
//        ;

        http.authorizeRequests()
                .antMatchers("/user/login/**").permitAll()
                .antMatchers("/order/**").authenticated(); // 配置order访问控制，必须认证后才可以访问
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(tokenStore);
    }
}
