package com.yu.ssm.service.impl;

import com.yu.ssm.dao.IUserDao;
import com.yu.ssm.domain.Role;
import com.yu.ssm.domain.UserInfo;
import com.yu.ssm.service.IUserService;
import com.yu.ssm.utils.PasswordEncodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInfo userInfo = null;
        try {
            userInfo = userDao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //处理自己的用户对象的信息封装到user中
        //authorities权限
        User user = new User(userInfo.getUsername(), userInfo.getPassword(), userInfo.getStatus() == 0 ? false : true, true, true, true, getAuthority(userInfo.getRoles()));

        return user;
    }

    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {

        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {

            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));

        }
        return list;
    }

    //查询所有用户
    @Override
    public List<UserInfo> findAll() throws Exception {
        return userDao.findAll();
    }

    //添加用户
    @Override
    public void save(UserInfo userInfo) throws Exception {
        //对用户密码加密
        String encodePassword = PasswordEncodeUtils.encodePassword(userInfo.getPassword());
        userInfo.setPassword(encodePassword);
        userDao.save(userInfo);
    }

    //根据id查询用户详情信息
    @Override
    public UserInfo findById(String id) throws Exception {
        return userDao.findById(id);
    }

    @Override
    public List<Role> findOtherRole(String userId) throws Exception {
        return userDao.findOtherRole(userId);
    }

    //给用户添加角色
    @Override
    public void addRoleToUser(String userId, String[] roleIds) throws Exception {

        for (String roleId : roleIds) {
            userDao.addRoleToUser(userId,roleId);
        }
    }
}
