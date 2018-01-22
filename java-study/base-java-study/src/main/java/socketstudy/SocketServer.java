package socketstudy;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * http://www.runoob.com/java/net-serversocket-socket.html
 * http://blog.csdn.net/defonds/article/details/7971259
 */
public class SocketServer {
    public static final int PORT = 9000;
    public static void main(String[] args) {
        SocketServer server = new SocketServer();
        server.init();
    }

    public void init() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);

            Executor service = Executors.newCachedThreadPool();
            boolean isStopped = false;
            while (!isStopped) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("received connected client: " + clientSocket.getRemoteSocketAddress());
                /*Thread thread = new Thread(new HandlerThread(clientSocket));
                thread.start();*/
                service.execute(new HandlerThread(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class HandlerThread implements Runnable {
        private Socket socket;
        public HandlerThread(Socket socket) {
            this.socket = socket;
        }
        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
                boolean flag = true;
                while (flag) {
                    String message = reader.readLine();
                    if (null == message || "".equals(message)) {
                        System.out.println("client is closed!");
                        flag = false;
                    } else {
                        if ("bye".equals(message)) {
                            flag = false;
                        } else {
                            System.out.println("read from client:" + message);

                            writer.write(message + "\n");
                            writer.flush();
                        }
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (socket != null) {
                    try {
                        System.out.println("close local client " + socket.getLocalSocketAddress()
                                + " remote socket:" + socket.getRemoteSocketAddress());
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
