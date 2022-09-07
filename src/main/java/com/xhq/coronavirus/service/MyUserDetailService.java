package com.xhq.coronavirus.service;/*
Created by shkstart on 2020/3/15.
*/

import com.xhq.coronavirus.dao.UserDao;
import com.xhq.coronavirus.entity.Authentication;
import com.xhq.coronavirus.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class  MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserDao userDao;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDao.findByUsername(s);
        if (user == null){
            throw new UsernameNotFoundException("根据用户名找不到用户！");
        }
        List<Authentication> atList = userDao.findAuthenticationByUserId(user.getId());
        user.setAuthenticationList(atList);

        return user;
    }
}
