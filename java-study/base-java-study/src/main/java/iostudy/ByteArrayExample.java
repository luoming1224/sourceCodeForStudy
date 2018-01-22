package iostudy;

import java.io.*;

public class ByteArrayExample {
    private static final int LEN = 5;
    // 对应英文字母“abcdefghijklmnopqrstuvwxyz”
    private static final char[] ArrayLetters = new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    public static void main(String[] args) {

//        testByteArrayInputStream();
//
//        testCharArrayReader();

        tesCharArrayWriter();
    }

    private static void testByteArrayInputStream() {
        try(ByteArrayOutputStream output = new ByteArrayOutputStream()) {

            output.write("This text is converted to bytes".getBytes("UTF-8"));

            byte[] bytes = output.toByteArray();

            try (InputStream input = new ByteArrayInputStream(bytes)) {
                int data = input.read();
                while (data != -1) {
                    System.out.print((char) data);
                    data = input.read();
                }
                System.out.println();
            }

        } catch (IOException e) {

        }
    }

    /**
     * http://www.cnblogs.com/skywang12345/p/io_18.html
     */
    private static void testCharArrayReader() {
        try {
            // 创建CharArrayReader字符流，内容是ArrayLetters数组
            CharArrayReader reader = new CharArrayReader(ArrayLetters);
            for (int i = 0; i < LEN; i++) {
                if (reader.ready()) {
                    System.out.printf("%d : %c\n", i, (char)reader.read());
                }
            }

            // 若“该字符流”不支持标记功能，则直接退出
            if (!reader.markSupported()) {
                System.out.println("make not supported!");
                return;
            }

            // 标记“字符流中下一个被读取的位置”。即--标记“f”，因为因为前面已经读取了5个字符，所以下一个被读取的位置是第6个字符”
            // (01), CharArrayReader类的mark(0)函数中的“参数0”是没有实际意义的。
            // (02), mark()与reset()是配套的，reset()会将“字符流中下一个被读取的位置”重置为“mark()中所保存的位置”
            reader.mark(0);

            // 跳过5个字符。跳过5个字符后，字符流中下一个被读取的值应该是“k”。
            reader.skip(5);

            // 从字符流中读取5个数据。即读取“klmno”
            char[] buf = new char[LEN];
            reader.read(buf, 0, LEN);
            System.out.printf("buf=%s\n", String.valueOf(buf));

            // 重置“字符流”：即，将“字符流中下一个被读取的位置”重置到“mark()所标记的位置”，即f。
            reader.reset();
            // 从“重置后的字符流”中读取5个字符到buf中。即读取“fghij”
            reader.read(buf, 0, LEN);
            System.out.printf("buf=%s\n", String.valueOf(buf));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * CharArrayWriter的API测试函数
     * http://www.cnblogs.com/skywang12345/p/io_19.html
     */
    private static void tesCharArrayWriter() {
        try {

            // 创建CharArrayWriter字符流
            CharArrayWriter writer = new CharArrayWriter();

            // 写入“A”个字符
            writer.write('A');
            // 写入字符串“BC”个字符
            writer.write("BC");
            //System.out.printf("writer=%s\n", writer);
            // 将ArrayLetters数组中从“3”开始的后5个字符(defgh)写入到writer中。
            writer.write(ArrayLetters, 3, 5);
            //System.out.printf("writer=%s\n", writer);

            // (01) 写入字符0
            // (02) 然后接着写入“123456789”
            // (03) 再接着写入ArrayLetters中第8-12个字符(ijkl)
            writer.append('0').append("123456789").append(String.valueOf(ArrayLetters), 8, 12);

            System.out.printf("writer=%s\n", writer);

            // 计算长度
            int size = writer.size();
            System.out.printf("size=%s\n", size);

            // 转换成byte[]数组
            char[] buf = writer.toCharArray();
            System.out.printf("buf=%s\n", String.valueOf(buf));

            // 将writer写入到另一个输出流中
            CharArrayWriter writer2 = new CharArrayWriter();
            writer.writeTo(writer2);
            System.out.printf("writer2=%s\n", writer2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
