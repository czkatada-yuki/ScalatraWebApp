package com.example.app

import org.scalatra._
import scalikejdbc._
import scalate.ScalateSupport

class MyScalatraServlet extends MyScalatraWebAppStack with ScalateSupport{

  get("/") {
    contentType = "text/html"
    ssp("index.ssp")
//    <html>
//      <body>
//        <h1>Hello, Some World!</h1>
//        Say <a href="hello-scalate">hello to Scalate</a>.
//
//      </body>
//    </html>
  }


  post("/json") {

  }

  get("/hello/:name") {
    contentType = "text/html"
    ssp("param.ssp", "param" -> params("name"))
//    <html>
//      <body>
//        <h1>Hello, {params("name")}</h1>
//      </body>
//    </html>
  }

}
