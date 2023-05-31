package edu.msudenver.cs.cs39ac

import org.scalatra.test.scalatest._

class MyScalatraServletTests extends ScalatraFunSuite {

  addServlet(classOf[MyScalatraServlet], "/*")

  test("GET / on MyScalatraServlet should return status 200") {
    get("/") {
      status should equal (200)
    }
  }

  test("GET /:URL on MyScalatraServlet should return status 500") {
    get("/:URL") {
      status should equal (500)
    }
  }

  test("GET /hello.html on MyScalatraServlet should return status 200") {
    get("/hello.html") {
      status should equal (200)
    }
  }

  test("GET /hello.html on MyScalatraServlet should not return status 404") {
    get("/hello.html") {
      status should not equal (404)
    }
  }

  test("GET /:URL/:URL on MyScalatraServlet should return status 404") {
    get("/:URL/:URL") {
      status should equal (404)
    }
  }

  test("GET /hello/hello.html on MyScalatraServlet should return status 404") {
    get("/hello/hello.html") {
      status should equal (404)
    }
  }

}
