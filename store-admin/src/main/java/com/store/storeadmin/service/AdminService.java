package com.store.storeadmin.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.store.storeadmin.mapper.AdminMapper;
import com.store.storeadmin.pojo.Admin;
import com.store.storeadmin.pojo.Permission;
import com.store.storeadmin.vo.Result;
import com.store.storeadmin.vo.UserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminMapper adminMapper;

    public Admin findAdminByUsername(String username){
        LambdaQueryWrapper<Admin> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Admin::getUsername,username);
        queryWrapper.last("limit 1");
        Admin admin = adminMapper.selectOne(queryWrapper);
        return admin;
    }

    public List<Permission> findPermissionByAdminId(Long adminId){
        return adminMapper.findPermissionByAdminId(adminId);
    }

    public List<UserInfoVO> findUserInfo(){
        List<UserInfoVO> userInfo = adminMapper.findUserInfo();
        return userInfo;
    }

    public Result deleteUserByUid(Integer uid){
        Integer integer = this.adminMapper.deleteByUid(uid);
        if (integer < 0){
            Result.fail(4004,"删除出错");
        }
        return Result.success(null);
    }


}
