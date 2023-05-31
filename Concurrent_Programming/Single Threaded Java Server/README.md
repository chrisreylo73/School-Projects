## A single-threaded web server in Java.

### Command-line arguments

- `--port <#>`: port number to listen on (e.g.: 8080)
- `--directory <dir>`: where to serve files from (e.g.: /tmp)
- `--responses <#>`: how many responses to make (0 = no limit)

N.B.: one must use System.exit(0) instead of HttpServer.stop for JDKs > 8
because of bug https://bugs.openjdk.java.net/browse/JDK-8233185

Change things from here down to reflect your development environment.

Author: Christian Lopez

Github repo: msu-denver-cs/assignment-01-chrisreylo73

Java version: 11.0.4

JUnit version: 4.13.1

### Building

The overall form of the directories are from Intellij, but you don't need
to keep them. If you do want to keep the directory structure but not use
IntelliJ, here are the commands to compile the app and tests.

    javac -d out/production/Concurrent01 src/Main.java
    javac -d out/production/Concurrent01 -cp out/production/Concurrent01:lib/junit-4.13.1.jar:lib/hamcrest-core-1.3.jar src/ArgumentsTest.java
    javac -d out/production/Concurrent01 -cp out/production/Concurrent01:lib/junit-4.13.1.jar:lib/hamcrest-core-1.3.jar src/MainTest.java
    javac -d out/production/Concurrent01 -cp out/production/Concurrent01:lib/junit-4.13.1.jar:lib/hamcrest-core-1.3.jar src/MyHttpHandler.java

### Running

User enters the following command in terminal:

    java -cp out/production/Concurrent01 Main --port 8080 --responses 1 --directory /tmp

The program checks if the directory given ("/tmp") exisits in working direcotry. If not it will create the directory.
Then inside that directory it will create a file named hello.html that looks like:

    <html>
    <head>
        <title>Hello world!</title>
    <body>
        Hello world!
    </body>
    </html>

The program then asks User if they would like to launch the webpage associated with the server.
The User must enter "Yes" or "No" (caps does not matter).
If user enters "Yes" the webpage http://localhost:8080/hello.html will appear in the user's browser.
The user will then be prompted "Please enter "end" when you want to quit the server: ".
if the user writes anything other than end, they will recieve a responce of "Invalid Input: Please try again".
If the user wrties "end" (caps does not matter) the sever will end and the program will finish.

### Testing

    java -ea -cp out/production/Concurrent01:lib/junit-4.13.1.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MainTest
    java -ea -cp out/production/Concurrent01:lib/junit-4.13.1.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MyHttpHandlerTest
    java -ea -cp out/production/Concurrent01:lib/junit-4.13.1.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore ArgumentsTest
