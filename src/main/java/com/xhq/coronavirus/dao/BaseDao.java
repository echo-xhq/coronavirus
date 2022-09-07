package com.xhq.coronavirus.dao;

import com.xhq.coronavirus.entity.Base;
import org.apache.ibatis.annotations.*;

@Mapper
public interface BaseDao {


    @Select("select id,idCard,name,age,gender,address,phone from base where id =#{id}")
    Base findById(int id);

    @Delete("delete from base where id=#{id}")
    void  delete(int id);

    @Insert("insert into base(idCard,name,age,gender,address,phone ) values(#{idCard},#{name},#{age},#{gender},#{address},#{phone})")
    void add(Base base);

    @Select("select id,idCard,name,age,gender,address,phone from base where idCard = #{idCard}")
    Base findByIdCard(String idCard);

    @Update("update base set address=#{address},phone=#{phone} where id=#{id}")
    void update(Base base);

}
