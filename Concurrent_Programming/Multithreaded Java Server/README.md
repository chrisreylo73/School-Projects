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

### Apache Bench: 1 thread

    This is ApacheBench, Version 2.3 <$Revision: 1879490 $>
    Copyright 1996 Adam Twiss, Zeus Technology Ltd, http://www.zeustech.net/
    Licensed to The Apache Software Foundation, http://www.apache.org/

    Benchmarking localhost (be patient)
    Completed 100 requests
    Completed 200 requests
    Completed 300 requests
    Completed 400 requests
    Completed 500 requests
    Completed 600 requests
    Completed 700 requests
    Completed 800 requests
    Completed 900 requests
    Completed 1000 requests
    Finished 1000 requests

    Server Software:  
    Server Hostname: localhost
    Server Port: 8080

    Document Path: /hello.html
    Document Length: 78 bytes

    Concurrency Level: 1
    Time taken for tests: 1.031 seconds
    Complete requests: 1000
    Failed requests: 0
    Total transferred: 173000 bytes
    HTML transferred: 78000 bytes
    Requests per second: 969.62 [#/sec] (mean)
    Time per request: 1.031 [ms] (mean)
    Time per request: 1.031 [ms] (mean, across all concurrent requests)
    Transfer rate: 163.81 [Kbytes/sec] received

    Connection Times (ms)
    min mean[+/-sd] median max  
    Connect: 0 0 0.4 0 1  
    Processing: 0 1 1.0 1 21  
    Waiting: 0 1 0.9 0 21  
    Total: 0 1 1.0 1 22  
    WARNING: The median and mean for the waiting time are not within a normal deviation
    These results are probably not that reliable.

    Percentage of the requests served within a certain time (ms)
    50% 1
    66% 1
    75% 1
    80% 1
    90% 1
    95% 2
    98% 2
    99% 3
    100% 22 (longest request)

### Apache Bench: 17 threads

    Copyright 1996 Adam Twiss, Zeus Technology Ltd, http://www.zeustech.net/
    Licensed to The Apache Software Foundation, http://www.apache.org/

    Benchmarking localhost (be patient)
    Completed 100 requests
    Completed 200 requests
    Completed 300 requests
    Completed 400 requests
    Completed 500 requests
    Completed 600 requests
    Completed 700 requests
    Completed 800 requests
    Completed 900 requests
    Completed 1000 requests
    Finished 1000 requests

    Server Software:
    Server Hostname: localhost
    Server Port: 8080

    Document Path: /hello.html
    Document Length: 78 bytes

    Concurrency Level: 17
    Time taken for tests: 0.603 seconds
    Complete requests: 1000
    Failed requests: 0
    Total transferred: 173000 bytes
    HTML transferred: 78000 bytes
    Requests per second: 1657.22 [#/sec] (mean)  
    Time per request: 10.258 [ms] (mean)  
    Time per request: 0.603 [ms] (mean, across all concurrent requests)
    Transfer rate: 279.98 [Kbytes/sec] received

    Connection Times (ms)
    min mean[+/-sd] median max  
    Connect: 0 0 0.5 0 2  
    Processing: 2 10 5.1 9 38  
    Waiting: 1 10 5.1 9 38  
    Total: 2 10 5.1 9 38

    Percentage of the requests served within a certain time (ms)
    50% 9
    66% 11
    75% 12
    80% 13
    90% 16
    95% 20
    98% 25
    99% 28
    100% 38 (longest request)

### Apache Bench: 18 Threads

    Copyright 1996 Adam Twiss, Zeus Technology Ltd, http://www.zeustech.net/
    Licensed to The Apache Software Foundation, http://www.apache.org/

    Benchmarking localhost (be patient)
    Completed 100 requests
    Completed 200 requests
    Completed 300 requests
    Completed 400 requests
    Completed 500 requests
    Completed 600 requests
    Completed 700 requests
    Completed 800 requests
    Completed 900 requests
    Completed 1000 requests
    Finished 1000 requests

    Server Software:
    Server Hostname: localhost
    Server Port: 8080

    Document Path: /hello.html
    Document Length: 78 bytes

    Concurrency Level: 18
    Time taken for tests: 0.611 seconds
    Complete requests: 1000
    Failed requests: 0
    Total transferred: 173000 bytes
    HTML transferred: 78000 bytes
    Requests per second: 1637.00 [#/sec] (mean)  
    Time per request: 10.996 [ms] (mean)  
    Time per request: 0.611 [ms] (mean, across all concurrent requests)
    Transfer rate: 276.56 [Kbytes/sec] received

    Connection Times (ms)
    min mean[+/-sd] median max  
    Connect: 0 0 0.4 0 1  
    Processing: 2 10 6.6 9 61  
    Waiting: 1 10 6.6 9 61  
    Total: 2 11 6.6 10 61

    Percentage of the requests served within a certain time (ms)
    50% 10
    66% 11
    75% 12
    80% 13
    90% 16
    95% 19
    98% 28
    99% 48
    100% 61 (longest request)

### Apache Bench: Performance Analysis

    I noticed peak performance happened using 17 concurrent threads and a drop off at 18 threads.
    If you take a look at the provided data from my Apache Bench runs for 17 threads and 18 threads you will notice a decrease in the Time per request metric from 0.603 to 0.611.
    You can also notice a decrease in performance regarding transfer with 17 threads having a transfer rate of 279.98 while 18 threads has a transfer rate of 276.56.
    Request per second are also affected going from 1657.22 to 1637.00.


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

    java -cp out/production/Concurrent01 Main --port 8080 --responses 1 --directory /tmp --threads 10

The program checks if the directory given ("/tmp") exisits in working direcotry. If not it will create the directory.
Then inside that directory it will look for a file named Hello.html that looks like:

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
