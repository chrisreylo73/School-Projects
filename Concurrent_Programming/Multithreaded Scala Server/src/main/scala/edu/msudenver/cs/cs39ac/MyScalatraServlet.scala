package edu.msudenver.cs.cs39ac

import org.scalatra._
import scala.io.Source
import scala.concurrent.{ExecutionContext, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration
import org.scalatra.ActionResult._
import java.nio.file.{Files, Paths}

  // Collaborated with Sean Kruse, Christian Mudd and Alexander Sanford 
class MyScalatraServlet extends ScalatraServlet { 
  // Found this on canvas discussion board from Dr.Beaty
  // It was Sean Kruse idea to put it into a method I believe
  def getFileContents(filename: String): Future[String] = Future {
      val f = Source.fromFile(params("URL"))
      try f.getLines.mkString("\n")
      finally f.close()
  }
    // I got some of the concept in the website https://www.baeldung.com/scala/check-file-path-exists and on https://scalatra.org/guides/2.5/http/actions.html
    //And combined the 2 to get the code seen below
    //Also the val s = Await.ready(getFileContents(params("URL")), Duration.Inf) and  s.value.get.get was provided by Dr.Beaty
    //The halt(404, <h1>404 File not Found </h1>) was found in the book http://bestmadar135.ir/wp-content/uploads/2019/07/20190107-0122721-Scalatra-in-Action.pdf
  get("/:URL") { 
    contentType = "text/html"
    Files.exists(Paths.get(params("URL"))) match {
      case true => {println("Serving file: 200"); val s = Await.ready(getFileContents(params("URL")), Duration.Inf); s.value.get.get }
      case false => {println("File not Found: 404"); halt(404, <h1>404 File not Found </h1>)}
    }
  }
}

