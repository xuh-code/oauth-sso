package oauthservice.oauthservice.server.oauth2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by xuh
 * DATE 2019/1/22 22:07.
 * version 1.0
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/sign-in.html")//自定义标准登录界面
                .loginProcessingUrl("/authentication/form") //自定义表单请求路径
                .and()
                .authorizeRequests()
                .antMatchers("/sign-in.html", "/authentication/form").permitAll()//此路径放行 否则会陷入死循环
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable()//跨域关闭
        ;


//        http
//                .formLogin()
//                .loginPage("/tiger-login.html")//自定义标准登录界面
//                .loginProcessingUrl("/authentication/form")//自定义表单请求路径
//                .and()
//                .authorizeRequests()
//                .antMatchers("/tiger-login.html","/authentication/form")//此路径放行 否则会陷入死循环
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .csrf().disable()//跨域关闭
//        ;

    }
}
