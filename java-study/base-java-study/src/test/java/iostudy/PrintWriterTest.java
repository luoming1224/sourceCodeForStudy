package iostudy;

import org.junit.Test;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class PrintWriterTest {
    @Test
    public void getStackTrace() {
        PrintWriterExample example = new PrintWriterExample();
        String s = example.getStackTrace(new Exception());
        System.out.println(s);
        /*Exception e = new Exception();
        final Writer w = new StringWriter();
        final PrintWriter pw = new PrintWriter(w);
        e.printStackTrace(pw);
        System.out.println(w.toString());*/
    }
}
