package com.xhq.coronavirus.service.iml;/*
Created by shkstart on 2020/2/23.
*/

import com.github.pagehelper.PageHelper;
import com.xhq.coronavirus.dao.DeadDao;
import com.xhq.coronavirus.entity.Dead;
import com.xhq.coronavirus.service.DeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeadServiceImp implements DeadService {
    @Autowired
    DeadDao dao;
    @Override
    public void add(Dead dead) {
        dao.add(dead);
    }

    @Override
    public List<Dead> findAll(int page,int size) {
        PageHelper.startPage(page,size);
        return dao.findAll();
    }

    @Override
    public Dead get(int id) {
       return dao.findById(id);
    }

    @Override
    public int number() {
        return dao.number();
    }


}
