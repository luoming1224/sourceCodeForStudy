package redisson;

import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class StandaloneTest {
    public static void main(String[] args) {
        Config config = new Config();
        config.setCodec(new org.redisson.client.codec.StringCodec());
        config.useSingleServer().setAddress("redis://172.25.45.240:6333");

        //config.setPassword("password")//设置密码
//        config.setConnectionPoolSize(500);//设置对于master节点的连接池中连接数最大为500
//        config.setIdleConnectionTimeout(10000);//如果当前连接池里的连接数量超过了最小空闲连接数，而同时有连接空闲时间超过了该数值，那么这些连接将会自动被关闭，并从连接池里去掉。时间单位是毫秒。
//        config.setConnectTimeout(30000);//同任何节点建立连接时的等待超时。时间单位是毫秒。
//        config.setTimeout(3000);//等待节点回复命令的时间。该时间从命令发送成功时开始计时。
//        config.setPingTimeout(30000);
//        config.setReconnectionTimeout(3000);//当与某个节点的连接断开时，等待与其重新建立连接的时间间隔。时间单位是毫秒。

        RedissonClient redisson = Redisson.create(config);
        RBucket<String> keyObject = redisson.getBucket("key");
        keyObject.set("value6666");
        redisson.shutdown();
    }
}
