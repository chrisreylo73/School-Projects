/*
/Names of team members: Christian Lopez and Reynaldo Lopez
*/
import java.net.*;
import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.*;
import java.util.Scanner;

public class TCPMultiServerThread extends Thread {
    private Socket clientTCPSocket = null;

    public TCPMultiServerThread(Socket socket) {
        super("TCPMultiServerThread");
        clientTCPSocket = socket;
    }

    public void run() {

        try {
            PrintWriter cSocketOut = new PrintWriter(
               clientTCPSocket.getOutputStream(), true);
            BufferedReader cSocketIn = new BufferedReader(
               new InputStreamReader(clientTCPSocket.getInputStream()));

            String fromClient = "";
            String toClient;
            int counter = 0;
            String [] requestLine = new String[3];
            String status = "";
            String current = new java.io.File( "." ).getCanonicalPath();
            String readLine = "";
            String body = " ";
            while(!(fromClient.equals("Bye."))){
               while (counter != 5) {
                     fromClient = cSocketIn.readLine();
                     if (fromClient.equals("Bye.")){
                        System.out.println("Leaving");
                        break;
                     }

                     if(counter == 0){
                        requestLine = fromClient.split(" ");
                     }
                     counter ++;
               }
               
               try{

                  File file = new File(current + requestLine[1]);
                  BufferedReader inFile = new BufferedReader (new FileReader(file));
                  boolean fileCon = false;
                  if(file.exists()){
                     fileCon = true;
                  }
                  if (!(requestLine[0].equals("GET"))){
                     status = " 400 Bad Request";
                  }
                  else{
                     status = " 200 OK";
                     while((readLine = inFile.readLine()) != null){
                         body = body + " \r\n" + readLine ;
                     }
                     body = body + "\r\n \r\n \r\n \r\n \r\n";
                  }

               }
               catch (Exception e){
                  status = " 404 Not Found";
               }
               
                String  date = DateTimeFormatter.RFC_1123_DATE_TIME.format(ZonedDateTime.now());   
               
               if(counter == 5) {
                  cSocketOut.println(requestLine[2] + status + "\r\nDate: " + date + "\r\nServer: " + "Rey/ChrisServer\r\n" + body);
                  counter = 0;
                  body = "";                          
               }
          }   
       
          
           System.out.println("The End of Connection.");             
           cSocketOut.close();
           cSocketIn.close();
           clientTCPSocket.close();

       } 
       catch (IOException e) {
           e.printStackTrace();
       }
}
}