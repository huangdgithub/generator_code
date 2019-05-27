package com.jwt.sso.service;

import com.jwt.sso.dao.OAuthDao;
import com.jwt.sso.pojo.CustomUser;
import com.jwt.sso.pojo.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Author: MuFeng
 * @CreateDate: 2019/5/6 13:53
 */
@Service
public class CustomDetailsService implements UserDetailsService {

    @Autowired
    OAuthDao oauthDao;

    @Override
    public CustomUser loadUserByUsername(final String username) throws UsernameNotFoundException {
        UserEntity userEntity = null;
        try {
            userEntity = oauthDao.getUserDetails(username);
            CustomUser customUser = new CustomUser(userEntity);
            return customUser;
        } catch (Exception e) {
            e.printStackTrace();
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
    }

}
