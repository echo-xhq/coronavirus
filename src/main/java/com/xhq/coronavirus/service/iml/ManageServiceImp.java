package com.xhq.coronavirus.service.iml;/*
Created by shkstart on 2020/2/24.
*/

import com.xhq.coronavirus.dao.ManageDao;
import com.xhq.coronavirus.entity.Manage;
import com.xhq.coronavirus.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageServiceImp implements ManageService {
    @Autowired
    ManageDao dao;
    @Override
    public List<Manage> findAll() {
        return dao.findAll();
    }

    @Override
    public void add(Manage manage) {
        dao.add(manage);
    }

    @Override
    public void delete(String id) {
        dao.delete(id);
    }

    @Override
    public void update(Manage manage) {
        dao.update(manage);
    }

    @Override
    public Manage find(String id, String password) {
        return dao.find(id,password);
    }
}
