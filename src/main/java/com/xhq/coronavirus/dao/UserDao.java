package com.xhq.coronavirus.dao;

import com.xhq.coronavirus.entity.Authentication;
import com.xhq.coronavirus.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {
    //通过username查找User
    @Select("select id,username,name,password,phone,unit from user where username=#{username}")
    User findByUsername(String username);
    //添加用户
    @Insert("insert into user(username,password,phone,unit,name)values(#{username},#{password},#{phone},#{unit},#{name})")
    void addUser(User user);

    //查找所有用户
    @Select("select * from user")
    @Results({ @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "name", column = "name"),
            @Result(property = "password", column = "password"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "unit", column = "unit"),
            @Result(property = "authenticationList",column = "id",javaType = List.class,many = @Many(select = "com.xhq.coronavirus.dao.AuthenticationDao.findByUserId"))})
    List<User> findAll();

    //删除用户
    @Delete("delete from user where id=#{id}")
    void deleteUser(int id);

    //为账号添加用户权限
    @Insert("insert into user_authorities (authentication_id,user_id) values (2,#{id})")
    void addUserRole(int id);

    //为账号添加超级管理者权限
    @Update("UPDATE user_authorities set authentication_id = 1 WHERE user_id = #{id}")
    void addAdminRole(int id);

    /**
     * 查询用户权限
     * @return
     */
    @Select("SELECT a.id,a.description,a.name " +
            "FROM authentication a,user_authorities ua " +
            "WHERE a.id=ua.authentication_id AND ua.user_id=#{id} ")
    List<Authentication> findAuthenticationByUserId(int id);

}
