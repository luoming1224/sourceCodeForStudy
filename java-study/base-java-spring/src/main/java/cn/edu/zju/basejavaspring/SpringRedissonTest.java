package cn.edu.zju.basejavaspring;

import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringRedissonTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-redisson.xml");
//        RedissonClient redisson = (RedissonClient) applicationContext.getBean("standalone");
        RedissonClient redisson = (RedissonClient) applicationContext.getBean("cluster");
        // 首先获取redis中的key-value对象，key不存在没关系
        RBucket<String> keyObject = redisson.getBucket("key");
        if (keyObject != null && keyObject.get()!=null) {
            System.out.println(keyObject.get());
        }
        // 如果key存在，就设置key的值为新值value
        // 如果key不存在，就设置key的值为value
        keyObject.set("value77");
    }

}
