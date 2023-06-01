
/*
/Names of team members: Christian Lopez and Reynaldo Lopez
*/
import java.io.*;
import java.net.*;

public class TCPClient {
   public static void main(String[] args) throws IOException {
      Socket tcpSocket = null;
      PrintWriter socketOut = null;
      BufferedReader socketIn = null;
      BufferedReader sysIn = new BufferedReader(new InputStreamReader(System.in));
      boolean ipErrorCheck = true;
      long startTime = 0;
      String userIpInput = "";
      // THe following while loop checks for ip or host errors.
      while (ipErrorCheck) {
         try {
            System.out.println("Enter the IP address or the DNS: ");
            userIpInput = sysIn.readLine();
            startTime = System.currentTimeMillis(); // Documents start time of the connection attempt.
            tcpSocket = new Socket(userIpInput, 4324);
            socketOut = new PrintWriter(tcpSocket.getOutputStream(), true);
            socketIn = new BufferedReader(new InputStreamReader(tcpSocket.getInputStream()));
            ipErrorCheck = false;
         } catch (UnknownHostException e) {
            System.err.println("Can't recognise IP address or the DNS " + userIpInput + ", please try again.");
            System.exit(1);
            ipErrorCheck = true;
         } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: " + userIpInput);
            System.exit(1);
            ipErrorCheck = true;
         }
      }

      long connectConfTime = System.currentTimeMillis(); // Documents the time of established connection.
      long difference = connectConfTime - startTime; // Documents the difference in connectConfTime minus startTime.
      System.out.println("RTT of establishing TCP connection = " + difference + " ms"); // Prints the difference out.

      String fromServer;
      startTime = System.currentTimeMillis();
      String continueAnswer = "Y";
      while (continueAnswer.equals("Y")) {
         // Prompts the user for information regarding http request.
         System.out.println("Enter the HTTP Method type: ");
         String methodType = sysIn.readLine().toUpperCase();
         System.out.println("Enter the Name of the htm file requested: ");
         String fileName = "/" + sysIn.readLine();
         System.out.println("Enter the HTTP Version: ");
         String httpVersion = sysIn.readLine();
         System.out.println("enter the User-Agent: ");
         String userAgent = sysIn.readLine();
         String requestLine = methodType + " " + fileName + " HTTP/" + httpVersion;
         String fromUser = requestLine + "\r\nHost: " + userIpInput + "\r\nUser -Agent: " + userAgent + " \r\n \r\n";
         startTime = System.currentTimeMillis();
         System.out.print(fromUser);
         socketOut.println(fromUser);
         String[] statusLineArray = new String[4];
         String statusLine = socketIn.readLine();
         statusLineArray = statusLine.split(" ");
         int lineCounter = 0;
         if (statusLineArray[1].equals("200")) {
            FileWriter outputFileName = new FileWriter(fileName.substring(1, fileName.length()));
            PrintWriter outputFile = new PrintWriter(outputFileName);
            System.out.println(statusLine);
            while ((fromServer = socketIn.readLine()).length() != 0) {
               if (lineCounter < 3)
                  System.out.println(fromServer);
               else {
                  outputFile.print(fromServer + " \r\n");
               }
               lineCounter++;
            }
            outputFile.close();
         } else {
            System.out.println(statusLine);
            while ((fromServer = socketIn.readLine()).length() != 0) {
               if (lineCounter < 3)
                  System.out.println(fromServer);
               lineCounter++;
            }
         }
         long endTime = System.currentTimeMillis();
         difference = endTime - startTime;
         System.out.print("RTT of query HTTP = " + difference + " ms \r\n \r\n");
         System.out.println("Would you like to continue? yes or no :");
         continueAnswer = sysIn.readLine().toUpperCase().substring(0, 1);
         if (!(continueAnswer.equals("Y"))) {
            socketOut.println("Bye.");
            socketOut.close();
            socketIn.close();
            sysIn.close();
            tcpSocket.close();
            break;
         }
      }

   }
}
