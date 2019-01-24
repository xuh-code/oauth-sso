package com.oauth.sso.repository;


import com.oauth.sso.entity.UserDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDoRepository extends JpaRepository<UserDo, Long> {
    UserDo findByUsername(String username);
}
