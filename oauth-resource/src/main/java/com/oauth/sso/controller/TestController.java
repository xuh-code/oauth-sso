package com.oauth.sso.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by xuh
 * DATE 2019/1/23 1:45.
 * version 1.0
 */
@RestController
public class TestController {

    @RequestMapping("/user/{user_id}")
    public String getUser(@PathVariable String user_id) throws IOException {

        return "user_id : " + user_id;
    }

}
