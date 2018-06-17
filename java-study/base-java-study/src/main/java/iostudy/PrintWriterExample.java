package iostudy;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class PrintWriterExample {

    public String getStackTrace(final Exception e) {
        // Need the exception in string form to prevent the retention of
        // references to classes in the stack trace that could trigger a memory
        // leak in a container environment.
        final Writer w = new StringWriter();
        final PrintWriter pw = new PrintWriter(w);
        e.printStackTrace(pw);
        return w.toString();
    }
}
