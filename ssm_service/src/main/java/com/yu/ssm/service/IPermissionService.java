package com.yu.ssm.service;

import com.yu.ssm.domain.Permission;

import java.util.List;

public interface IPermissionService {

    //查询所有资源权限
    List<Permission> findAll() throws Exception;


    //添加权限
    void save(Permission permission) throws Exception;
}
