package com.example.app

import org.scalatra._
import scalikejdbc._
import scalate.ScalateSupport

class MyScalatraServlet extends MyScalatraWebAppStack with ScalateSupport {


  get("/") {
    contentType = "text/html"
    ssp("index.ssp", "layout" -> "")
  }


  post("/json") {
    val name = params.get("name")
    println("name: " + name)

  }

}
