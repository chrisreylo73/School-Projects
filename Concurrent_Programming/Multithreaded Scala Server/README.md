# CS39ACSpring2022Assignment03

# Header:
<<<<<<< HEAD

- Title: Concurrent Project 3
- Date: 04/13/2022 - 04/24/2022
- Author: Christian Lopez
- Collaborators: Sean Keuse, Christian Mudd and Alexander Sanford
- Resources:  
   https://scalatra.org/guides/2.5/http/actions.html
  https://www.baeldung.com/scala/check-file-path-exists
  http://bestmadar135.ir/wp-content/uploads/2019/07/20190107-0122721-Scalatra-in-Action.pdf
  Canvas Discusiion Board
  Slides from the 18th scala 07
  Textbook: Learning-Concurrent-Programming-in-Scala

# Timeline:

- 4/13/2022 - Sean Showed me how to get my enviorment set up in vscode for the project
- 4/15/2022 - Started scala review with Sean Kruse. We made a seperate github where we wrote scala review type files to better understand scala and its differences from java
- 4/18/2022 - Implemented buildfile method using the back to the future slide that Dr. Beaty provided on Scala 07 "Tansactional Memory"
  (Sourced from Learning Concurrent Programming in Scala: @author Aleksandar Prokopec)
- 4/18/2022 - 4/22/2022 - Trial and error with several implementations to read in files inside futures
- 4/22/2022 - Started reading Scalatra in Action: @authors Dave Hrycyszyn, Stefan Olligenger , Ross Baker and implementing file serving methods
- 4/22/2022 - Started collaborating with Chrition Mudd on ideas and shared resources
- 4/23/2022 - Sean Kruse and I got the file to be served up by Jetty, using the Dr beaty code given in Canvas Discussion board (Christian Mudd sugested this)
  and got the future to be served up to localhost
- 4/24/2022 - Implemented some case switching (Using the practice scala files Sean and I made and other resources provided in comments I was able to create a fileChecker to see if the file is in project directory) (Sean made another implementation using halt method)
- 4/24/2022 - Some finishing touches were added. Handled the 404 better, added a test, updated the readme file, added instructions to Github.

# Project Description:

This program serves files (hello.html and hi.html) or anyfile in the project directory to a webpage in the format http://localhost:8080/filname so for example if I want to serve the file hello.html I would go to http://localhost:8080/hello.html. If the file I am looking for does not exist in the project directory the program will give a 404 code and say on the webpage "404 file not found".

# Reflection:

=======
* Title: Concurrent Project 3
* Date: 04/13/2022 - 04/24/2022
* Author: Christian Lopez
* Collaborators: Sean Keuse, Christian Mudd and Alexander Sanford
* Resources:  
 https://scalatra.org/guides/2.5/http/actions.html
https://www.baeldung.com/scala/check-file-path-exists
http://bestmadar135.ir/wp-content/uploads/2019/07/20190107-0122721-Scalatra-in-Action.pdf
Canvas Discusiion Board
Slides from the 18th scala 07
Textbook: Learning-Concurrent-Programming-in-Scala

# Timeline:
* 4/13/2022 - Sean Showed me how to get my enviorment set up in vscode for the project
* 4/15/2022 - Started scala review with Sean Kruse. We made a seperate github where we wrote scala review type files to better understand scala and its differences from java
* 4/18/2022 - Implemented buildfile method using the back to the future slide that Dr. Beaty provided on Scala 07 "Tansactional Memory"
(Sourced from Learning Concurrent Programming in Scala: @author Aleksandar Prokopec)
* 4/18/2022 - 4/22/2022 - Trial and error with several implementations to read in files inside futures  
* 4/22/2022 - Started reading Scalatra in Action: @authors Dave Hrycyszyn, Stefan Olligenger , Ross Baker and implementing file serving methods
* 4/22/2022 - Started collaborating with Chrition Mudd on ideas and shared resources
* 4/23/2022 - Sean Kruse and I got the file to be served up by Jetty, using the Dr beaty code given in Canvas Discussion board (Christian Mudd sugested this)
and got the future to be served up to localhost
* 4/24/2022 - Implemented some case switching (Using the practice scala files Sean and I made and other resources provided in comments I was able to create a fileChecker to see if the file is in project directory) (Sean made another implementation using halt method)
* 4/24/2022 - Some finishing touches were added. Handled the 404 better, added a test, updated the readme file, added instructions to Github.

# Project Description:
This program serves files (hello.html and hi.html) or anyfile in the project directory to a webpage in the format http://localhost:8080/filname so for example if I want to serve the file hello.html I would go to http://localhost:8080/hello.html. If the file I am looking for does not exist in the project directory the program will give a 404 code and say on the webpage "404 file not found".

# Reflection:
>>>>>>> 6c8ef98ba87ff72ebe211c852bbc8a2752141daf
I went through sever iterations of this project due to my stuggle futures and scalatra and twirl.
The majority of the project revolved around researching and practicing scala mechanics and uderstanding the functionality of futures.
Both Sean Kruse and I spent several nights jumping off ideas on how to approach reading in files, weather we should use twirl, and how to get a result to be produced from a future. Unfortionaly on my part I did not commit those faild iterations. With the several resousces gathered and use of the code from Monday the 18ths calss and the Canvas dicussion board we were able to better grasp how to handle the future problems we were having. We also consulted with Chritian Mudd and Alexander Sandford on their ideas aswell. I think eventully we were able to peice together all that we had learned and produced to get the final result you see.

You'll need to install SBT on your machine. Here are some instructions.

- https://www.scala-sbt.org/1.x/docs/Installing-sbt-on-Windows.html
- https://www.scala-sbt.org/1.x/docs/Installing-sbt-on-Mac.html
- https://www.scala-sbt.org/1.x/docs/Installing-sbt-on-Linux.html

This project was built with Scalatra (https://scalatra.org/) Here is how
this specific repo was built.

    MS200667 CS39ACSpring2022Assignment03  sbt new scalatra/scalatra.g8
    [info] welcome to sbt 1.6.2 (Homebrew Java 18)
    [info] loading settings for project global-plugins from idea.sbt ...
    [info] loading global plugins from /Users/stevebeaty/.sbt/1.0/plugins
    [info] set current project to new (in build file:/private/var/folders/jr/6dhz8k8j6cnddyzy9xkggjc80000gp/T/sbt_318efc9/new/)
    organization [com.example]: edu.msudenver.cs
    name [My Scalatra Web App]:
    version [0.1.0-SNAPSHOT]:
    servlet_name [MyScalatraServlet]:
    package [com.example.app]: edu.msudenver.cs.cs39ac
    scala_version [2.13.4]:
    sbt_version [1.4.5]:
    scalatra_version [2.8.2]:
    twirl_version [1.4.2]:
    xsbt_web_plugin_version [4.2.1]:
    jetty_version [9.4.35.v20201120]:

You'll need to set your JAVA_HOME environment variable to refer to a Java
1.8 install. You'll be able to start a web servlet via sbt:

    MS200667 CS39ACSpring2022Assignment03  sbt
    [info] welcome to sbt 1.4.5 (Oracle Corporation Java 1.8.0_212)
    [info] loading settings for project global-plugins from idea.sbt ...
    [info] loading global plugins from /Users/stevebeaty/.sbt/1.0/plugins
    [info] loading settings for project cs39acspring2022assignment03-build from plugins.sbt ...
    [info] loading project definition from /Users/stevebeaty/src/CS39ACSpring2022Assignment03/project
    [info] loading settings for project hello from build.sbt ...
    [info] set current project to My Scalatra Web App (in build file:/Users/stevebeaty/src/CS39ACSpring2022Assignment03/)
    [info] sbt server started at local:///Users/stevebeaty/.sbt/1.0/server/37802fd9d145a1a76db5/sock
    [info] started sbt server
    sbt:My Scalatra Web App> ~jetty:start
    [info] starting server ...
    [success] Total time: 1 s, completed Apr 10, 2022 3:59:55 PM
    [info] 1. Monitoring source files for hello/jetty:start...
    [info]    Press <enter> to interrupt or '?' for more options.
    2022-04-10 15:59:55.568:INFO::main: Logging initialized @252ms to org.eclipse.jetty.util.log.StdErrLog
    WARNING: jetty-runner is deprecated.
             See Jetty Documentation for startup options
             https://www.eclipse.org/jetty/documentation/
    2022-04-10 15:59:55.578:INFO:oejr.Runner:main: Runner
    2022-04-10 15:59:55.731:INFO:oejs.Server:main: jetty-9.4.29.v20200521; built: 2020-05-21T17:20:40.598Z; git: 77c232aed8a45c818fd27232278d9f95a021095e; jvm 1.8.0_212-b10
    2022-04-10 15:59:55.994:WARN:oeja.AnnotationParser:main: Unrecognized ASM version, assuming ASM7
    2022-04-10 15:59:56.744:INFO:oeja.AnnotationConfiguration:main: Scanning elapsed time=749ms
    2022-04-10 15:59:57.124:INFO:oejs.session:main: DefaultSessionIdManager workerName=node0
    2022-04-10 15:59:57.124:INFO:oejs.session:main: No SessionScavenger set, using defaults
    2022-04-10 15:59:57.127:INFO:oejs.session:main: node0 Scavenging every 600000ms
    15:59:57.185 [main] INFO  o.scalatra.servlet.ScalatraListener - The cycle class name from the config: ScalatraBootstrap
    15:59:57.446 [main] INFO  o.scalatra.servlet.ScalatraListener - Initializing life cycle class: ScalatraBootstrap
    2022-04-10 15:59:57.599:INFO:oejsh.ContextHandler:main: Started o.e.j.w.WebAppContext@29444d75{/,file:///Users/stevebeaty/src/CS39ACSpring2022Assignment03/target/webapp/,AVAILABLE}{file:///Users/stevebeaty/src/CS39ACSpring2022Assignment03/target/webapp/}
    2022-04-10 15:59:57.622:INFO:oejs.AbstractConnector:main: Started ServerConnector@2a33fae0{HTTP/1.1, (http/1.1)}{0.0.0.0:8080}
    2022-04-10 15:59:57.626:INFO:oejs.Server:main: Started @2311ms

You should now be able to browse to http://localhost:8080/hello.html and
see:

    Request URL: hello.html

You need to modify
src/main/scala/edu/msudenver/cs/cs39ac/MyScalatraServlet.scala to return
the contents of a file using a Scala Future, similar to assignments 1 and 2.
For this assignment, there is no need to read the command line for port
number, directory, etc.

For more information on HTTP requests and responses see:
https://javadoc.io/doc/org.scalatra/scalatra-unidoc_2.13/2.8.0/org/scalatra/ScalatraServlet.html
