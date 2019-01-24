package com.oauth.sso.repository;

import com.oauth.sso.entity.UserDo;

public interface UserService {

    UserDo create(String username, String password);
}
