package iostudy;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipeExample {
    public static void main(String[] args) throws IOException {

        /**
         * try-with-resources结构
         * PipedOutputStream 类型变量就在try关键字后面的括号中声明
         * 在块中使用多个资源而且这些资源都能被自动的关闭，这些资源按照他们被创建的顺序的逆序来关闭
         * 首先PipedInputStream会被关闭，然后PipedOutputStream会被关闭
         * 参见　http://ifeve.com/java-7中的try-with-resources/
         */

        //以下四种使用方式都可以
        //try(final PipedOutputStream output = new PipedOutputStream();
        //    final PipedInputStream input = new PipedInputStream(output))

        //try(final PipedInputStream input = new PipedInputStream();
        //    final PipedOutputStream output = new PipedOutputStream(input))

        try(final PipedOutputStream output = new PipedOutputStream();
            final PipedInputStream input = new PipedInputStream()) {
//            output.connect(input);
            input.connect(output);
           Thread thread1 = new Thread(() -> {
                try {
                    output.write("Hello world, pipe!".getBytes());
                } catch (IOException e) {

                }
            });

            Thread thread2 = new Thread(() -> {
                try {
                    int data = input.read();
                    while (data != -1) {
                        System.out.print((char) data);
                        data = input.read();
                    }
                } catch (IOException e) {

                }
            });

            thread1.start();
            thread2.start();

            try {
                thread1.join();
                thread2.join();
            } catch (InterruptedException e) {

            }
        }
    }
}
