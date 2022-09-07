package com.xhq.coronavirus.service;/*
Created by shkstart on 2020/2/23.
*/

import com.xhq.coronavirus.entity.Dead;

import java.util.List;

public interface DeadService {
    public void add(Dead dead);
    public List<Dead> findAll(int page,int size);
    public Dead get(int id);
    public int number();

}
