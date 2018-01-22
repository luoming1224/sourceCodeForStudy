package socketstudy;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressExample {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("www.baidu.com");
//            InetAddress address = InetAddress.getByName("115.239.210.27");

            System.out.println("host address:" + address.getHostAddress());
            System.out.println("host name:" + address.getHostName());


            InetAddress localAddress = InetAddress.getLocalHost();

            System.out.println("host address:" + localAddress.getHostAddress());
            System.out.println("host name:" + localAddress.getHostName());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
