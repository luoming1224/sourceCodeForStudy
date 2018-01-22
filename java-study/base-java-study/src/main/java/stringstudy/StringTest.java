package stringstudy;

import java.util.concurrent.locks.ReentrantLock;

public class StringTest {
    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer();
        String user = "test";
        String pwd = "123";
        sb.append("select * from userInfo where username=")
                .append(user)
                .append(" and pwd=")
                .append(pwd);
    }
}
