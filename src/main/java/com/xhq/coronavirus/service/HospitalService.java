package com.xhq.coronavirus.service;/*
Created by shkstart on 2020/2/23.
*/

import com.xhq.coronavirus.entity.Hospital;

import java.util.List;

public interface HospitalService {
    public List<Hospital> findAll();


    public boolean add(Hospital hospital);


    public List<Hospital> findByName(String name);
    public boolean update(Hospital hospital);
}
