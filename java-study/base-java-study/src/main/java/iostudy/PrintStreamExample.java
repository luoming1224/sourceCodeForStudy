package iostudy;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class PrintStreamExample {

    public static void main(String[] args) {
        try {
            OutputStream output = new FileOutputStream("out.txt");
            PrintStream printStream = new PrintStream(output);
            System.setOut(printStream);

            System.out.println("This is a test!");
            System.out.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
