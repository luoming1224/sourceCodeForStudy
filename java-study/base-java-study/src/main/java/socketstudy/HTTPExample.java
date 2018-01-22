package socketstudy;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HTTPExample {
    public static void main(String[] args) {
        URLConnection urlConnection = null;
        try {
//            URL url = new URL("http://www.baidu.com");
            URL url = new URL("file:/home/a1/IdeaProjects/exercise/java-study/bufferedinputstream.txt");
            urlConnection = url.openConnection();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (urlConnection == null) {
            return;
        }

        try (InputStream input = urlConnection.getInputStream()) {
            int data = input.read();
            while (data != -1) {
                System.out.print((char)data);
                data = input.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
