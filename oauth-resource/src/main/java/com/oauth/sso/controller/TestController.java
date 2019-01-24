package com.oauth.sso.controller;

import com.oauth.sso.entity.UserDo;
import com.oauth.sso.repository.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Created by xuh
 * DATE 2019/1/23 1:45.
 * version 1.0
 */
@RestController
public class TestController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/{user_id}")
    public String getUser(@PathVariable String user_id) throws IOException {

        return "user_id : " + user_id;
    }



    @RequestMapping(value = "/registry", method = RequestMethod.POST)
    public UserDo createUser(@RequestParam("username") String username, @RequestParam("password") String password) {
        if (StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(password)) {
            return userService.create(username, password);
        }
        return null;
    }
}
