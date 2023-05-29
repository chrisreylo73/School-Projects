/*
/Names of team members: Christian Lopez and Reynaldo Lopez
*/

import java.net.*;
import java.io.*;

public class TCPMultiServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverTCPSocket = null;
        boolean listening = true;

        try {
            serverTCPSocket = new ServerSocket(4324);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 4324.");
            System.exit(-1);
        }

        while (listening){
               new TCPMultiServerThread(serverTCPSocket.accept()).start();
        }

        serverTCPSocket.close();
    }
}
