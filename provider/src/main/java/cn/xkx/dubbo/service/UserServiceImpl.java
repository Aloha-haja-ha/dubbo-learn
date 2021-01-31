package cn.xkx.dubbo.service;

import cn.xkx.pojo.User;
import cn.xkx.service.IUserService;
import org.apache.dubbo.config.annotation.Service;


@Service(version = "1.0")//这个service是dubbo的service  注意导包
public class UserServiceImpl implements IUserService {
    @Override
    public User selectUserById(Integer id) {
        User user=new User();
        user.setId(id);
        user.setName("张三");
        System.out.println("调用接口返回张三");
        return user;
    }
}
