package com.xhq.coronavirus.service.iml;/*
Created by shkstart on 2020/2/23.
*/

import com.xhq.coronavirus.dao.InspectDao;
import com.xhq.coronavirus.entity.Inspect;
import com.xhq.coronavirus.service.InspectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InspectServiceImp implements InspectService {
    @Autowired
    InspectDao dao;
    @Override
    public List<Inspect> find(int baseId) {
        return dao.findById( baseId);
    }

    @Override
    public void add(Inspect inspect) {
        dao.add(inspect);
    }
}
