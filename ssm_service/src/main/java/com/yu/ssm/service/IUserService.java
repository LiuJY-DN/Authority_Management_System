package com.yu.ssm.service;

import com.yu.ssm.domain.Role;
import com.yu.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    //查询所有用户
    List<UserInfo> findAll() throws Exception;

    //添加用户
    void save(UserInfo userInfo) throws Exception;

    //根据id查看用户详情信息
    UserInfo findById(String id) throws Exception;

    //查询没有的角色
    List<Role> findOtherRole(String userId) throws Exception;

    //给用户添加角色
    void addRoleToUser(String userId, String[] roleIds) throws Exception;
}
