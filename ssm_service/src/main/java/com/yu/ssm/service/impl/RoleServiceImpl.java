package com.yu.ssm.service.impl;

import com.yu.ssm.dao.IRoleDao;
import com.yu.ssm.domain.Permission;
import com.yu.ssm.domain.Role;
import com.yu.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;


    //查询所有角色
    @Override
    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }

    //添加角色
    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }

    @Override
    public Role findByRoleId(String roleId) throws Exception {
        return roleDao.findByRoleId(roleId);
    }

    @Override
    public List<Permission> findOtherPermission(String roleId) throws Exception {
        return roleDao.findOtherPermission(roleId);
    }

    @Override
    public void addPermissionToRole(String roleId, String permissionId) {
        roleDao.addPermissionToRole(roleId,permissionId);
    }

    //详情信息
    @Override
    public Role findRoleShowById(String roleId) {
        return roleDao.findRoleShowById(roleId);
    }
}
