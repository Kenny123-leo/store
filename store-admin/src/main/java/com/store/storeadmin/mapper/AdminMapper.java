package com.store.storeadmin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.store.storeadmin.pojo.Admin;
import com.store.storeadmin.pojo.Permission;
import com.store.storeadmin.vo.UserInfoVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AdminMapper extends BaseMapper<Admin> {

    @Select("select * from ms_permission where id in (select permission_id from ms_admin_permission where admin_id=#{adminId})")
    List<Permission> findPermissionByAdminId(Long adminId);

    List<UserInfoVO> findUserInfo();

    Integer deleteByUid(Integer uid);


}
