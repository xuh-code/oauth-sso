package oauthservice.oauthservice.config;

import oauthservice.oauthservice.service.UserServiceDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by xuh
 * DATE 2019/1/22 22:07.
 * version 1.0
 */
@Order(101)
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    private static final String[] AUTH_WHITELIST = {
            // -- swagger ui
            "/swagger-resources/**",
            "/swagger-ui.html",
            "/v2/api-docs",
            "/webjars/**",
            "/oauth/**",
            "/sign-in.html",
            "/authentication/form"
    };

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Autowired
    private UserServiceDetail userServiceDetail;

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        http.formLogin()
////                .loginPage("/sign-in.html")//自定义标准登录界面
////                .loginProcessingUrl("/authentication/form") //自定义表单请求路径
////                .and()
////                .authorizeRequests()
////                .antMatchers(AUTH_WHITELIST).permitAll()//此路径放行 否则会陷入死循环
////                .anyRequest()
////                .authenticated()
////                .and()
////                .csrf().disable()//跨域关闭
////        ;
//
//        http.formLogin()
//                .loginPage("/sign-in.html")
//                .loginProcessingUrl("/user/login")
//                .and()
//                .authorizeRequests()
//                .antMatchers(AUTH_WHITELIST).permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .csrf().disable()
//        ;
//
////        http.requestMatchers().anyRequest()
////                .and()
////                .authorizeRequests()
////                .antMatchers(AUTH_WHITELIST).permitAll();
//
//    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userServiceDetail).passwordEncoder(passwordEncoder());
    }
}
