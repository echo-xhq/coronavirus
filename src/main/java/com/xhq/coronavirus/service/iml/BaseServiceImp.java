package com.xhq.coronavirus.service.iml;/*
Created by shkstart on 2020/2/23.
*/

import com.xhq.coronavirus.dao.BaseDao;
import com.xhq.coronavirus.entity.Base;
import com.xhq.coronavirus.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BaseServiceImp implements BaseService {
    @Autowired
    BaseDao dao;

    @Override
    public List<com.xhq.coronavirus.entity.Base> findAll() {
        return null;
    }

    @Override
    public com.xhq.coronavirus.entity.Base findById(int id) {
        return dao.findById(id);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public void add(Base base) {
        dao.add(base);
    }

    @Override
    public Base findByIdCard(String idCard) {
        return dao.findByIdCard(idCard);
    }

    @Override
    public void update(Base base) {
        dao.update(base);
    }
}
