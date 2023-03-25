package com.store.storeadmin.mapperTests;

import com.store.storeadmin.mapper.AdminMapper;
import com.store.storeadmin.vo.UserInfoVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
// @RunWith:表示启动这个单元测试类（单元测试类是不能够运行的），需要传递一个参数，必须是SpringRunner的实例类型
@RunWith(SpringRunner.class)
public class AdminMapperTests {

    @Autowired
    private AdminMapper adminMapper;

    @Test
    public void findUserInfo(){
        List<UserInfoVO> userInfo = adminMapper.findUserInfo();
        System.err.println(userInfo);
    }




}
