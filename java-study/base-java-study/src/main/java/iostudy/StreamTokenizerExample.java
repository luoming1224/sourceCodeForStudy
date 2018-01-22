package iostudy;

import java.io.*;

public class StreamTokenizerExample {
    public static void main(String[] args) {

        testStreamTokenizer();

        testStringReader();

        testStringWriter();


    }

    private static void testStreamTokenizer() {
        try {
            StreamTokenizer tokenizer = new StreamTokenizer(new StringReader("Mary had 1 little lamb..."));
            while (tokenizer.nextToken() != StreamTokenizer.TT_EOF) {
                if (tokenizer.ttype == StreamTokenizer.TT_WORD) {
                    System.out.println(tokenizer.sval);
                } else if (tokenizer.ttype == StreamTokenizer.TT_NUMBER) {
                    System.out.println(tokenizer.nval);
                } else if (tokenizer.ttype == StreamTokenizer.TT_EOL) {
                    System.out.println();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testStringReader() {
        try (Reader reader = new StringReader("input string...")) {

            int data = reader.read();
            while (data != -1) {
                System.out.print((char)data);
                data = reader.read();
            }
            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testStringWriter() {
        try (StringWriter writer = new StringWriter()) {

            writer.write('a');
            writer.write('b');
            writer.write('c');
            String data = writer.toString();

            System.out.println(data);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
