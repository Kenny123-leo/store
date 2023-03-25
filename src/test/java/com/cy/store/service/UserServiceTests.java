package com.cy.store.service;

import com.cy.store.entity.User;
import com.cy.store.mapper.UserMapper;
import com.cy.store.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// @SpringBootTest:表示标注当前的类是一个测试类，不会随同项目一块打包
@SpringBootTest
// @RunWith:表示启动这个单元测试类（单元测试类是不能够运行的），需要传递一个参数，必须是SpringRunner的实例类型
@RunWith(SpringRunner.class)
public class UserServiceTests {
    /**
     * Could not autowire. No beans of 'UserMapper' type found.
     * 原因：idea有检测的功能，接口是不能够直接创建Bean的（动态代理技术来解决）
     */
    @Autowired
    private IUserService iUserService;
    /**
     * 单元测试方法：就可以单独独立运行，不用启动整个项目，可以做单元测试，提升了代码的测试效率
     * 1.必须被Test注解修饰
     * 2.返回值类型必须是void
     * 3.方法的参数列表不指定任何类型
     * 4.方法的访问修饰符必须是public
     */
    @Test
    public void reg(){
        try {
            User user = new User();
            user.setUsername("yuanxin02");
            user.setPassword("123");
            iUserService.reg(user);
            System.out.println("OK");
        } catch (ServiceException e) {
            // 获取类的对象，在获取类的名称
            System.out.println(e.getClass().getSimpleName());
            // 获取异常的具体描述信息
            throw new RuntimeException(e.getMessage());
        }
    }

    @Test
    public void login(){
        User user = iUserService.login("test01", "123");
        System.out.println(user);
    }

    @Test
    public void changePassword(){
        iUserService.changePassword(8,"test002","123","321");
    }

    @Test
    public void getByUid(){
        System.out.println(iUserService.getByUid(8));
    }

    @Test
    public void changeInfo(){
        User user = new User();
        user.setPhone("17832734");
        user.setEmail("yuan@qq.com");
        user.setGender(0);
        iUserService.changeInfo(8,"test003",user);
    }

    @Test
    public void changeAvatar(){
        iUserService.changeAvatar(8,"/img/test.png","test");
    }

}
