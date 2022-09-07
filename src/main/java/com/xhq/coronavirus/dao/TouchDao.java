package com.xhq.coronavirus.dao;

import com.xhq.coronavirus.entity.Base;
import com.xhq.coronavirus.entity.Touch;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TouchDao {
    @Select("select baseId,comeFrom,isoAddress,startDate,finished from touch where finished ='否' ")
    @Results({
            @Result(id = true, property = "baseId", column = "baseId"),
            @Result(property = "comeFrom", column = "comeFrom"),
            @Result(property = "isoAddress", column = "isoAddress"),
            @Result(property = "startDate", column = "startDate"),
            @Result(property = "finished", column = "finished"),
            @Result(property = "base",column = "baseId",javaType = Base.class,one = @One(select = "com.xhq.coronavirus.dao.BaseDao.findById"))
    })
    //查看所有接触案例
    List<Touch> findAll();

    //添加接触信息
    @Insert("insert into touch(baseId,comeFrom,isoAddress,startDate,finished)values(#{baseId},#{comeFrom},#{isoAddress},#{startDate},#{finished})")
    void add(Touch touch);

    @Select("select baseId,comeFrom,isoAddress,startDate,finished from touch where baseId =#{baseId} ")
    @Results({
            @Result(id = true, property = "baseId", column = "baseId"),
            @Result(property = "comeFrom", column = "comeFrom"),
            @Result(property = "isoAddress", column = "isoAddress"),
            @Result(property = "startDate", column = "startDate"),
            @Result(property = "finished", column = "finished"),
            @Result(property = "base",column = "baseId",javaType = Base.class,one = @One(select = "com.xhq.coronavirus.dao.BaseDao.findById"))
    })
    //通过id查找密切接触者
    Touch findById(int baseId);

    //将此接触者隔离状态完成
    @Update("update touch set finished='是' where baseId=#{baseId}")
    void toSafe(int baseId);
    //现存隔离人数
    @Select("select count(*) from touch where finished ='否' ")
    Integer currentNumber();
    //累计隔离人数
    @Select("select count(*) from touch  ")
    Integer number();
}
