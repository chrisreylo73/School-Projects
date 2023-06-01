import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.awt.Desktop;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;
import java.util.concurrent.Executors;

class Arguments {
    private final int port;
    private final String directory;
    private final int responses;

    Arguments(int port, String directory, int responses) {
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
        }
        this.port = port;
        this.directory = directory;
        this.responses = responses;
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
}

class MyHttpHandler implements HttpHandler {
    private final Arguments arguments;

    MyHttpHandler(Arguments arguments) {
        this.arguments = arguments;

    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
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
         */
        String userWorkingDir = System.getProperty("user.dir");
        String tmpDir = userWorkingDir + arguments.getDirectory();
        File tmpDirectory = new File(tmpDir);
        if (!tmpDirectory.exists()) {
            tmpDirectory.mkdirs();
        }
        /* Creates the file hello.html and writes into it */
        File file = new File(tmpDir, "hello.html");
        String createHtmlFile = "<html>\n<head>\n <title>Helloworld!</title>\n<body>\n Hello world!\n</body>\n</html>";
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write(createHtmlFile);
        bw.close();

        FileInputStream in = new FileInputStream(file);
        /*
         * Checks if the file exists and runs the fileFOund method or the fileNotFound
         * method
         */
        // Set file.exists == false to check fileNotFound method
        if (file.exists() == true) {
            this.fileFound(httpExchange, file.length(), in);
        } else {
            this.fileNotFound(httpExchange);
        }
    }

    private void fileNotFound(HttpExchange httpExchange) throws IOException {
        OutputStream out = httpExchange.getResponseBody();
        if (arguments.getResponses() == 0) {
            for (int i = 0; i < 2147483647; i++) {
                // Sends responce headers with responce code 404
                httpExchange.sendResponseHeaders(404, 0);
                out.write("404: File not found".getBytes());
                out.close();
            }
        } else {
            for (int i = 0; i < arguments.getResponses(); i++) {
                // Sends responce headers with responce code 404
                httpExchange.sendResponseHeaders(404, 0);
                out.write("404: File not found".getBytes());
                out.close();
            }
        }
    }

    private void fileFound(HttpExchange httpExchange, long length, FileInputStream in) throws IOException {
        /* This methed reads in the file and sends the data up to */
        if (arguments.getResponses() == 0) {
            for (int i = 0; i < 2147483647; i++) {
                httpExchange.sendResponseHeaders(200, length); // Sends responce headers to tell the server that the
                                                               // fileexists
                httpExchange.getResponseBody().write(in.readAllBytes()); // Serves hello.html file
            }
        } else {
            for (int i = 0; i < arguments.getResponses(); i++) {
                httpExchange.sendResponseHeaders(200, length); // Sends responce headers to tell the server that the
                                                               // fileexists
                httpExchange.getResponseBody().write(in.readAllBytes()); // Serves hello.html file
            }
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
        // checks if each command is present inside the arguments
        boolean hasPortNum = false;
        boolean hasDirectory = false;
        boolean hasResponseCount = false;
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
        } else if (hasResponseCount == false) {
            respo = 0;
        }
        // returns portnumber, directory, and number of responces as a Arguments object
        return new Arguments(portNumber, direc, respo);
    }

    private void serverEnd(Scanner keyboard) {
        /*
         * Asks user if they want to kill the server connection. If the user wants to
         * stop the server they are prompted to write "end"
         */
        String endServer = "";
        while (!(endServer.equals("end".toLowerCase()))) {
            System.out.println("Please enter \"end\" when you want to quit the server: ");
            endServer = keyboard.nextLine();
            if (!(endServer.equals("end".toLowerCase()))) {
                System.out.println("Invalid Input: Please try again");
            }
        }
        System.exit(0);
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
        // creates https server with the user given port.
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(arguments.getPort()), 0);
        // A context is a path which represents the location of service on this server.
        httpServer.createContext("/hello.html", new MyHttpHandler(arguments));
        httpServer.setExecutor(Executors.newSingleThreadExecutor());
        httpServer.start();
        // Creates instance of class Main.
        Main driver = new Main();
        Scanner keyboard = new Scanner(System.in);
        // Asks to launch webpage.
        driver.launchWebpage(arguments.getPort(), keyboard);
        // Asks to end server.
        driver.serverEnd(keyboard);
        keyboard.close();
    }
}
