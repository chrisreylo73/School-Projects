import org.junit.Test;
import static org.junit.Assert.assertEquals;

//Sean Kruse and I discussed ideas on what to implement for tests.
public class MainTest {
    @Test(expected = AssertionError.class)
    public void testNoDirectory() {
        String[] a = { "--port", "8080", "--threads", "10" };
        Main.parseArgs(a);
    }

    @Test(expected = AssertionError.class)
    public void testNoPort() {
        String[] a = { "--directory", "/tmp", "--threads", "10" };
        Main.parseArgs(a);
    }

    @Test(expected = AssertionError.class)
    public void testNoThreads() {
        String[] a = { "--port", "8080", "--directory", "/tmp" };
        Main.parseArgs(a);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUnknownArgument() {
        String[] a = { "--foo", "/bar" };
        Main.parseArgs(a);
    }

    @Test
    public void testGoodArguments() {
        String[] a = { "--port", "8080", "--directory", "/tmp", "--threads", "10" };
        Arguments arguments = Main.parseArgs(a);
        assertEquals(arguments.getPort(), 8080);
        assertEquals(arguments.getDirectory(), "/tmp");
        assertEquals(arguments.getThreads(), 10);

        String[] b = { "--directory", "/tmp", "--port", "8080", "--threads", "10" };
        arguments = Main.parseArgs(b);
        assertEquals(arguments.getPort(), 8080);
        assertEquals(arguments.getDirectory(), "/tmp");
        assertEquals(arguments.getThreads(), 10);

        String[] c = { "--threads", "10", "--directory", "/tmp", "--port", "8080", };
        arguments = Main.parseArgs(c);
        assertEquals(arguments.getPort(), 8080);
        assertEquals(arguments.getDirectory(), "/tmp");
        assertEquals(arguments.getThreads(), 10);

        String[] d = { "--threads", "10", "--port", "8080", "--directory", "/tmp", };
        arguments = Main.parseArgs(d);
        assertEquals(arguments.getPort(), 8080);
        assertEquals(arguments.getDirectory(), "/tmp");
        assertEquals(arguments.getThreads(), 10);

        String[] e = { "--directory", "/tmp", "--threads", "10", "--port", "8080", };
        arguments = Main.parseArgs(e);
        assertEquals(arguments.getPort(), 8080);
        assertEquals(arguments.getDirectory(), "/tmp");
        assertEquals(arguments.getThreads(), 10);

        String[] f = { "--port", "8080", "--threads", "10", "--directory", "/tmp", };
        arguments = Main.parseArgs(f);
        assertEquals(arguments.getPort(), 8080);
        assertEquals(arguments.getDirectory(), "/tmp");
        assertEquals(arguments.getThreads(), 10);

    }
}