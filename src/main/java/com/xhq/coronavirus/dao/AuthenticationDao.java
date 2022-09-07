package com.xhq.coronavirus.dao;/*
Created by shkstart on 2020/3/16.
*/

import com.xhq.coronavirus.entity.Authentication;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AuthenticationDao {
    //通过用户名找到其下的所有授权
    @Select("select * from authentication where authentication.id in(select authentication_id from user_authorities where user_id=#{userId})")
    List<Authentication> findByUserId(int userId);
}
