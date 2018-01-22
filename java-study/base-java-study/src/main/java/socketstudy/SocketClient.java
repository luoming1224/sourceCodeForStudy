package socketstudy;

import java.io.*;
import java.net.Socket;

import static socketstudy.SocketServer.PORT;

public class SocketClient {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", PORT);
            System.out.println("local socket: " + socket.getLocalSocketAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (socket == null) {
            return;
        }
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            writer.write("测试客户端和服务器通信，服务器接收到消息返回到客户端\n");
            writer.flush();

            String message = reader.readLine();
            System.out.println("read from server:" + message);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
