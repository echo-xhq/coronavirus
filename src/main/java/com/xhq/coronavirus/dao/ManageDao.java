package com.xhq.coronavirus.dao;/*
Created by shkstart on 2020/2/24.
*/

import com.xhq.coronavirus.entity.Manage;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface ManageDao {
    @Select("select id,name,phone,unit,permission from manage")
    List<Manage> findAll();

    @Insert("insert into manage( id,name,phone,unit,permission) values(#{id},#{name},#{phone},#{unit},#{permission})")
    void add(Manage manage);

    @Delete("delete from manage where id=#{id}")
    void delete(String id);

    @Update("update manage set password=#{password},name=#{name},phone=#{phone},unit=#{unit},permission=#{permission}" +
            "where id=#{id}")
    void update(Manage manage);

    @Select("select name from manage where id=#{id},password=#{password}")
    Manage find(String id,String password);
}
