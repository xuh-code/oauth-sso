package com.oauth.sso.controller;

import com.oauth.sso.entity.UserDo;
import com.oauth.sso.repository.UserService;
import io.swagger.annotations.OAuth2Definition;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.Principal;

/**
 * Created by xuh
 * DATE 2019/1/23 1:45.
 * version 1.0
 */
@Slf4j
@RestController
public class TestController {

    @Autowired
    private UserService userService;


    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable String id) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "product id : " + id;
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/user/{user_id}")
    public String getUser(@PathVariable String user_id) throws IOException {

        return "user_id : " + user_id;
    }

    @GetMapping("/order/{user_id}")
    public String getOrer(@PathVariable String user_id)  {

        return "order_id : " + user_id;
    }

    @GetMapping("/getPrinciple")
    public OAuth2Authentication getPrinciple(OAuth2Authentication oAuth2Authentication, Principal principal, Authentication authentication) {
        log.info(oAuth2Authentication.getUserAuthentication().getAuthorities().toString());
        log.info(oAuth2Authentication.toString());
        log.info("principal.toString() " + principal.toString());
        log.info("principal.getName() " + principal.getName());
        log.info("authentication: " + authentication.getAuthorities().toString());

        return oAuth2Authentication;
    }

    @RequestMapping(value = "/registry", method = RequestMethod.POST)
    public UserDo createUser(@RequestParam("username") String username, @RequestParam("password") String password) {
        if (StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(password)) {
            return userService.create(username, password);
        }
        return null;
    }
}
