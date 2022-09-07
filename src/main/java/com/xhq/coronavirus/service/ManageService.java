package com.xhq.coronavirus.service;/*
Created by shkstart on 2020/2/24.
*/

import com.xhq.coronavirus.entity.Manage;

import java.util.List;

public interface ManageService {
     List<Manage> findAll();


    public void add(Manage manage);

    public void delete(String id);

    public void update(Manage manage);

    public Manage find(String id,String password);
}
