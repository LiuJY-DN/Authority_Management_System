package com.yu.ssm.controller;


import com.yu.ssm.domain.Permission;
import com.yu.ssm.domain.Role;
import com.yu.ssm.service.IRoleService;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Role> roleList = roleService.findAll();
        mv.addObject("roleList",roleList);
        mv.setViewName("role-list");
        return mv;
    }

    //详情信息
    @RequestMapping("/findRoleShowById.do")
    public ModelAndView findById(@RequestParam(name = "id") String roleId) throws Exception {
        ModelAndView mv = new ModelAndView();
        Role role = roleService.findRoleShowById(roleId);
        mv.addObject("role",role);
        mv.setViewName("role-show");
        return mv;
    }

    //添加角色
    @RequestMapping("/save.do")
    public String save(Role role) throws Exception {
        roleService.save(role);
        return "redirect:findAll.do";
    }

    //查询权限
    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id") String roleId) throws Exception {
        ModelAndView mv = new ModelAndView();
        Role role = roleService.findByRoleId(roleId);
        List<Permission> permissionList = roleService.findOtherPermission(roleId);
        mv.addObject("role",role);
        mv.addObject("permissionList",permissionList);
        mv.setViewName("role-permission-add");
        return mv;
    }

    //添加权限
    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToURole(@RequestParam(name = "role") String roleId,@RequestParam(name = "ids") String[] permissionIds){
        for (String permissionId : permissionIds) {
            roleService.addPermissionToRole(roleId,permissionId);
        }
        return "redirect:findAll.do";
    }
}
