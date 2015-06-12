package com.example.app.controller

import com.example.app.MyScalatraWebAppStack
import org.joda.time.DateTime
import org.joda.time.format.{DateTimeFormat, DateTimeFormatter}
import org.json4s.ext.{DateTimeSerializer, DateParser, JodaTimeSerializers}
import org.scalatra._
import scalate.ScalateSupport
import org.json4s.{DefaultFormats, Formats, ext}
import org.scalatra.json._
import com.example.app.controller._
import com.example.app.model._
/**
 * Created by a13902 on 6/11/15.
 */
class MyScalatraWebAppRoute extends ScalatraServlet with ScalateSupport with JacksonJsonSupport {

  protected implicit val jsonFormats: Formats = DefaultFormats
  val userController: UserController = new UserController

  before() {
    userController.establishConnectionPool()
    contentType = formats("json")
  }

  /**
   * show HTML website content
   */
  get("/") {
    contentType = "text/html"
    ssp("index.ssp", "layout" -> "")
  }

  /**
   * show JSON format dataset
   */
  get("/users") {
    userController.selectAllUsers
  }

  /**
   * show single user data in JSON format
   */
  get("/users/:id") {
    userController.selectUserById(params("id").toInt)
  }

  /**
   * create new user
   */
  post("/users") {
    userController.insertUser(params("name"), params("email"))
    redirect("/users")
  }

  /**
   * update a preexisting user by id
   */
  put("/users/:id") {

  }

  /**
   * delete a preexisting user by id
   */
  delete("users/:id") {

  }

  /**
   * show custom HTML content when 404
   */
  notFound {
    contentType = "text/html"
    <h1>WEB PAGE NOT FOUND!!</h1>
  }
}
