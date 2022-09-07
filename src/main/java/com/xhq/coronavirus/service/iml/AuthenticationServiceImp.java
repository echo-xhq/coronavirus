package com.xhq.coronavirus.service.iml;/*
Created by shkstart on 2020/3/16.
*/

import com.xhq.coronavirus.dao.AuthenticationDao;
import com.xhq.coronavirus.entity.Authentication;
import com.xhq.coronavirus.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthenticationServiceImp implements AuthenticationService {
    @Autowired
    AuthenticationDao dao;
    @Override
    public List<Authentication> findByUserId(int userId) {
        return dao.findByUserId(userId);
    }
}
