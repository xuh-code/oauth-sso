package oauthservice.oauthservice.server.oauth2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by xuh
 * DATE 2019/1/22 22:07.
 * version 1.0
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/sign-in.html")
                .loginProcessingUrl("/authentication/form")
                .and()
                .authorizeRequests()
                .antMatchers("/sign-in.html").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable()
        ;
    }
}
