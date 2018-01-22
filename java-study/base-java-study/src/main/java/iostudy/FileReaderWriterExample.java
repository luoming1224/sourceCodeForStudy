package iostudy;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriterExample {
    private static final String fileName = "file.txt";
    private static final String charsetName = "UTF-8";

    public static void main(String[] args) {

        testFileWriter();
        testFileReader();

    }

    private static void testFileWriter() {

        File file = new File(fileName);
        try (FileWriter fileWriter = new FileWriter(file)) {

            fileWriter.write("字节流转为字符流示例");
            fileWriter.write("0123456789\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testFileReader() {

        File file = new File(fileName);
        try (FileReader fileReader = new FileReader(file)) {

            char c1 = (char)fileReader.read();
            System.out.println("c1:" + c1);

            fileReader.skip(6);
            char[] buf = new char[10];
            fileReader.read(buf);
            System.out.println("buf:" + (new String(buf)));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
