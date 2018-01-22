package iostudy;

import java.io.*;

public class InputStreamExample {
    public static void main(String[] args) {
        byte[] data = new byte[1024];

        try (InputStream inputStream = new FileInputStream("bufferedinputstream.txt")) {

            int bytesRead = inputStream.read(data);

            while (bytesRead != -1) {
                String t = new String(data);
                System.out.println(t);

                bytesRead = inputStream.read(data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (OutputStream outputStream = new FileOutputStream("bufferedoutputstream.txt", true)) {
            outputStream.write(data);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
