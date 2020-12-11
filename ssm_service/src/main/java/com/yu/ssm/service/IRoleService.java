package com.yu.ssm.service;

import com.yu.ssm.domain.Permission;
import com.yu.ssm.domain.Role;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IRoleService {

    //查询所有角色
    List<Role> findAll() throws Exception;

    //添加角色
    void save(Role role) throws Exception;

    //根据id查角色
    Role findByRoleId(String roleId) throws Exception;

    List<Permission> findOtherPermission(String roleId) throws Exception;

    void addPermissionToRole(String roleId,String permissionId);

    //详情信息
    Role findRoleShowById(String roleId);
}
