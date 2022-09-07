package com.xhq.coronavirus;

import com.xhq.coronavirus.dao.BaseDao;
import com.xhq.coronavirus.dao.PatientDao;
import com.xhq.coronavirus.entity.Base;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CoronavirusApplicationTests {
    BaseDao dao;
    PatientDao da;
    @Test
    void contextLoads() {
        System.out.println("330321199809267326");
        System.out.println(da.findAll());
        Base byIdCard = dao.findByIdCard("330321199809267326");
        System.out.println(byIdCard);
    }

}
