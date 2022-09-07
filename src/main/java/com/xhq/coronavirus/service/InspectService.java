package com.xhq.coronavirus.service;/*
Created by shkstart on 2020/2/23.
*/

import com.xhq.coronavirus.entity.Inspect;

import java.util.List;

public interface InspectService {
    public List<Inspect> find(int baseId);
    public void add(Inspect inspect);
}
