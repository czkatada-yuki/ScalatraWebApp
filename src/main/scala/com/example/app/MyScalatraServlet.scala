package com.example.app

import org.scalatra._
import scalate.ScalateSupport

class MyScalatraServlet extends MyScalatraWebAppStack with ScalateSupport {


  get("/") {
    contentType = "text/html"
    ssp("index.ssp", "layout" -> "")
  }


  post("/demo") {
    val name = params.get("name")
    val email = params.get("email")


  }

}
