package com.yu.ssm.dao;

import com.yu.ssm.domain.Role;
import com.yu.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserDao {

    //查询所有用户
    @Select("select * from users")
    List<UserInfo> findAll() throws Exception;


    @Select("select * from users where username = #{username}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many=@Many(select = "com.yu.ssm.dao.IRoleDao.findRoleByUserId"))

    })
    UserInfo findByUsername(String username) throws Exception;

    //添加用户
    @Insert("insert into users(username,password,email,phoneNum,status) values(#{username},#{password},#{email},#{phoneNum},#{status})")
    void save(UserInfo userInfo) throws Exception;

    //根据id查询用户


    //根据id查询用户详情信息
    @Select("select * from users where id = #{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select="com.yu.ssm.dao.IRoleDao.findRoleByUserId")),
    })
    UserInfo findById(String id) throws Exception;

    //查询用户没有的角色
    @Select("select * from role where id not in (select roleId from users_role where userId = #{userId})")
    List<Role> findOtherRole(String userId);

    //给用户添加角色
    @Insert("insert into users_role(userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId,@Param("roleId") String roleId) throws Exception;

    @Select("select * from users where id in (select userId from users_role where roleId = #{id})")
    List<UserInfo> findShowById(String id) throws Exception;
}
