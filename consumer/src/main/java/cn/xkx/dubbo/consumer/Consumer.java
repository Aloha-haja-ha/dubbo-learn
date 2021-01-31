package cn.xkx.dubbo.consumer;

import cn.xkx.pojo.User;
import cn.xkx.service.IUserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Consumer implements CommandLineRunner {
    @Reference(version = "1.0",parameters = {"unicast","false"})//一台机器上同时跑生产者和消费者，必须开启广播形式，不然报错  zookeeper不需要 单播也是可以的
    private IUserService userService;
    @Override
    public void run(String... args) throws Exception {
       //实现CommandLineRunner，自动执行run方法
        User user=userService.selectUserById(2);
        System.out.println("consumer"+user);

    }
}
