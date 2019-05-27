package com.jwt.sso.pojo;

import org.springframework.security.core.userdetails.User;

/**
 * @Author: MuFeng
 * @CreateDate: 2019/5/6 11:57
 */
public class CustomUser extends User {

    private static final long serialVersionUID = 1L;

    public CustomUser(UserEntity user) {
        super(user.getUsername(), user.getPassword(), user.getGrantedAuthoritiesList());
    }

}
