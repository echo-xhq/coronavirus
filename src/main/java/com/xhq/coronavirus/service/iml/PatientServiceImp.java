package com.xhq.coronavirus.service.iml;/*
Created by shkstart on 2020/2/23.
*/

import com.github.pagehelper.PageHelper;
import com.xhq.coronavirus.dao.PatientDao;
import com.xhq.coronavirus.entity.Patient;
import com.xhq.coronavirus.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class PatientServiceImp implements PatientService {
    @Autowired
    PatientDao dao;
    @Override
    public List<Patient> findAll(int page,int size) {
        PageHelper.startPage(page,size);
        return dao.findAll();
    }

    @Override
    public void add(Patient patient) {
        dao.add(patient);
    }

    @Override
    public void update(Patient patient) {
        dao.update(patient);
    }

    @Override
    public List<Patient> findByName(String name) {
        return dao.findByName("%"+name+"%");
    }

    @Override
    public Patient findById(int id) {
        return dao.findById(id);
    }

    @Override
    public int number() {

        return dao.number();
    }

    @Override
    public int currentNumber() {
        return dao.currentNumber();
    }


    @Override
    public int beforeDay(Date date) {
        return dao.beforeDay(date);
    }


}