package com.xhq.coronavirus.dao;/*
Created by shkstart on 2020/2/23.
*/

import com.xhq.coronavirus.entity.Base;
import com.xhq.coronavirus.entity.Dead;
import com.xhq.coronavirus.entity.Patient;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeadDao {

    @Select("select baseId,deadTime from dead ")
    @Results({
            @Result(id = true, property = "baseId", column = "baseId"),
            @Result(property = "deadTime", column = "deadTime"),
            @Result(property = "patient",column = "baseId",javaType = Patient.class,one = @One(select = "com.xhq.coronavirus.dao.PatientDao.findById")),
            @Result(property = "base",column = "baseId",javaType = Base.class,one = @One(select = "com.xhq.coronavirus.dao.BaseDao.findById"))
})
    List<Dead> findAll();

    @Insert("insert into dead(baseId,deadTime)values(#{baseId},#{deadTime})")
    void add(Dead dead);

    @Select("select baseId,deadTime from dead where baseId = #{baseId}")
    @Results({
            @Result(id = true, property = "baseId", column = "baseId"),
            @Result(property = "deadTime", column = "deadTime"),
            @Result(property = "patient",column = "baseId",javaType = Patient.class,one = @One(select = "com.xhq.coronavirus.dao.PatientDao.findById")),
            @Result(property = "base",column = "baseId",javaType = Base.class,one = @One(select = "com.xhq.coronavirus.dao.BaseDao.findById"))
    })
    Dead findById(int baseId);

    @Select("select count(*) from dead")
    int number();

}
