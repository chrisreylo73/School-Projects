import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.awt.Desktop;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

class Arguments {
    private final int port;
    private final String directory;
    private final int responses;
    private final int threadNum;

    Arguments(int port, String directory, int responses, int threadNum) {
        if (port < 0) {
            System.out.println("Port number is negative");
            throw new AssertionError();
        } else if (port > 65535) {
            System.out.println("Port number is too large");
            throw new AssertionError();
        } else if (directory == null) {
            System.out.println("Directory is null");
            throw new AssertionError();
        } else if (directory.length() == 0) {
            System.out.println("Direcotry came out with a length of 0");
            throw new AssertionError();
        } else if (threadNum == 0) {
            System.out.println("Thread Num is 0");
            throw new AssertionError();
        }
        this.port = port;
        this.directory = directory;
        this.responses = responses;
        this.threadNum = threadNum;
    }

    int getPort() {
        return port;
    }

    String getDirectory() {
        return directory;
    }

    int getResponses() {
        return responses;
    }

    int getThreads() {
        return threadNum;
    }

}

class MyHttpHandler implements HttpHandler {
    private final Arguments arguments;
    private final AtomicInteger count = new AtomicInteger(0);

    MyHttpHandler(Arguments arguments) {
        System.out.println("Thread in Constructor: " + Thread.currentThread().getName());
        this.arguments = arguments;
    }

    public void increment() {
        count.incrementAndGet();
    }

    public int getCount() {
        return count.intValue();
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        System.out.println("Thread in handler: " + Thread.currentThread().getName());
        /*
         * HttpExchange has methods to access Http request informatuon and to prepare
         * and send the responces
         */
        /*
         * HttpHandler is an interface which needs to be implemented by the application
         * to handle http requests. It should only have one method.
         */
        /*
         * Responce headers hold additional information about the response, like its
         * location or about the server providing it.
         */

        /*
         * Creates a directory with the name specified by user into their current
         * working directory
         * 
         */
        synchronized (this) {
            String tmpDir = System.getProperty("user.dir") + arguments.getDirectory();
            File tmpDirectory = new File(tmpDir);
            if (!tmpDirectory.exists()) {
                tmpDirectory.mkdirs();
            }
            // This is used to check if the file name "Hello.html" is in tmp directory
            // Wanted to change it so that the program doesnt always create the file inside
            // the directory specified
            File file = new File(tmpDir, "Hello.html");

            try {
                FileInputStream in = new FileInputStream(file);
                this.fileFound(httpExchange, file.length(), in);
            } catch (FileNotFoundException e) {
                this.fileNotFound(httpExchange);
            }
        }

    }

    private void fileNotFound(HttpExchange httpExchange) throws IOException {
        // Alexander Sanford and Sean Kruse helped me with getting the 404 mesage as a
        // byte
        // array.

        synchronized (this) {
            if (arguments.getResponses() == 0) {
                while (true) {
                    byte[] response = "404: File not found".getBytes();
                    httpExchange.sendResponseHeaders(404, response.length);
                    OutputStream out = httpExchange.getResponseBody();
                    out.write(response);
                    System.out.println("Task Finished for Thread : " +
                            Thread.currentThread().getName());
                    increment();
                }
            }
            while (getCount() != arguments.getResponses()) {
                byte[] response = "404: File not found".getBytes();
                httpExchange.sendResponseHeaders(404, response.length);
                OutputStream out = httpExchange.getResponseBody();
                out.write(response);
                System.out.println("Task Finished for Thread : " +
                        Thread.currentThread().getName());
                increment();
            }
            System.exit(0);

        }

    }

    private void fileFound(HttpExchange httpExchange, long length, FileInputStream in) throws IOException {
        // Had help from Sean Kruse to make httpExchange.getResponseBody() a
        // OutputStream.
        synchronized (this) {
            if (arguments.getResponses() == 0) {
                while (true) {
                    httpExchange.sendResponseHeaders(200, length);
                    OutputStream out = httpExchange.getResponseBody();
                    out.write(in.readAllBytes());
                    out.close();
                    System.out.println(getCount());
                    increment();
                }
            }
            while (getCount() != arguments.getResponses()) {
                httpExchange.sendResponseHeaders(200, length);
                OutputStream out = httpExchange.getResponseBody();
                out.write(in.readAllBytes());
                out.close();
                System.out.println(getCount());
                increment();
            }
            System.exit(0);
        }
    }
}

public class Main {

    static Arguments parseArgs(String[] args) {
        /*
         * Splits the argus array into 2 seperate arrays. One for the command and
         * the other for the vaule associated with the command
         */
        String[] commands = new String[(args.length) / 2];
        String[] feilds = new String[(args.length) / 2];
        int counter1 = 0;
        int counter2 = 0;
        for (int i = 0; i < args.length; i++) {
            if (i % 2 == 0) {
                commands[counter1] = args[i];
                counter1++;
            } else {
                feilds[counter2] = args[i];
                counter2++;
            }
        }
        int portNumber = -1;
        String direc = null;
        int respo = 1;
        int numThreads = 0;
        // checks if each command is present inside the arguments
        boolean hasPortNum = false;
        boolean hasDirectory = false;
        boolean hasResponseCount = false;
        boolean hasThreadNum = false;
        String isIllegal = "";
        // Gets the proper vaules associated with each command
        for (int i = 0; i < commands.length; i++) {
            switch (commands[i]) {
                case "--port":
                    portNumber = Integer.parseInt(feilds[i]);
                    hasPortNum = true;
                    break;
                case "--directory":
                    direc = feilds[i];
                    hasDirectory = true;
                    break;
                case "--responses":
                    respo = Integer.parseInt(feilds[i]);
                    hasResponseCount = true;
                    break;
                case "--threads":
                    numThreads = Integer.parseInt(feilds[i]);
                    hasThreadNum = true;
                    break;
                default:
                    isIllegal = commands[i];
                    break;
            }
        }
        // Throws errors if one of the arguments isnt present or invalid
        if (isIllegal != "") {
            throw new IllegalArgumentException();
        } else if (hasPortNum == false) {
            throw new AssertionError();
        } else if (hasDirectory == false) {
            throw new AssertionError();
        } else if (hasThreadNum == false) {
            throw new AssertionError();
        } else if (hasResponseCount == false) {
            respo = 0;
        }
        // returns portnumber, directory, and number of responces as a Arguments object
        return new Arguments(portNumber, direc, respo, numThreads);
    }

    private void launchWebpage(int port, Scanner keyboard) throws IOException {
        Desktop desk = Desktop.getDesktop();
        System.out.println("Would you like to launch the webpage?");
        System.out.println("Please enter \"Yes\" or \"No\" : ");
        String launch = keyboard.nextLine().toUpperCase();
        if (launch.equals("Yes".toUpperCase())) {
            try {
                desk.browse(new URI("http://localhost:" + String.valueOf(port) + "/hello.html"));
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Arguments arguments = parseArgs(args);
        // creates https server with socket listening with the user given port.
        HttpServer httpServer = HttpServer.create((new InetSocketAddress(arguments.getPort())), 0);
        // A context is a path which represents the location of service on this server.
        httpServer.createContext("/hello.html", new MyHttpHandler(arguments));
        httpServer.setExecutor(Executors.newFixedThreadPool(arguments.getThreads()));
        httpServer.start();
        Scanner keyboard = new Scanner(System.in);
        // Creates instance of class Main.
        Main driver = new Main();
        // Asks to launch webpage.
        driver.launchWebpage(arguments.getPort(), keyboard);
        keyboard.close();
    }
}
