package com.xhq.coronavirus.service;/*
Created by shkstart on 2020/3/16.
*/

import com.xhq.coronavirus.entity.Authentication;

import java.util.List;

public interface AuthenticationService {
    public List<Authentication> findByUserId(int userId);
}
