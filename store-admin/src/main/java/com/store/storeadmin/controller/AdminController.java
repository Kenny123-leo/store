package com.store.storeadmin.controller;


import com.store.storeadmin.model.params.PageParam;
import com.store.storeadmin.pojo.Permission;
import com.store.storeadmin.service.AdminService;
import com.store.storeadmin.service.PermissionService;
import com.store.storeadmin.service.SecurityUserService;
import com.store.storeadmin.vo.Result;
import com.store.storeadmin.vo.UserInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private PermissionService permissionService;
    @Autowired
    private SecurityUserService securityUserService;
    @Autowired
    private AdminService adminService;

    @PostMapping("permission/permissionList")
    public Result listPermission(@RequestBody PageParam pageParam){

        return permissionService.listPermission(pageParam);
    }

    @PostMapping("permission/add")
    public Result add(@RequestBody Permission permission){
        return permissionService.add(permission);
    }

    @PostMapping("permission/update")
    public Result update(@RequestBody Permission permission){
        return permissionService.update(permission);
    }

    @GetMapping("permission/delete/{id}")
    public Result delete(@PathVariable("id") Long id){
        return permissionService.delete(id);
    }

    @PostMapping ("user/userInfo")
    @ResponseBody
    public Result getUsername(){
        log.info(SecurityContextHolder.getContext().getAuthentication().toString());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        log.info(name);
        return Result.success(name);
    }

    @GetMapping("user/user_detail")
    public Result findUserInfo(){
        List<UserInfoVO> data = adminService.findUserInfo();
        return Result.success(data);
    }

    @GetMapping("user/delete/{uid}")
    public Result deleteUserByUid(@PathVariable("uid")Integer uid){
        return adminService.deleteUserByUid(uid);
    }



}
