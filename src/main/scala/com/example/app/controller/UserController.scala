package com.example.app.controller

import java.sql.Connection

import com.example.app.model.User
import org.joda.time.DateTime
import scalikejdbc._

/**
 * Created by a13902 on 6/10/15.
 */
class UserController {

  val url = "jdbc:mysql://localhost/dev_mywebapp"
  val username = "root"
  val password = "root"

  implicit val session = AutoSession
  var connection: Connection = null

  /**
   * establish ConnectionPool
   * default driver is MySQL
   * @param driver String
   */
  private def establishConnectionPool(driver: String = "com.mysql.jdbc.Driver"): Unit = {
    Class.forName(driver)
    ConnectionPool.singleton(url, username, password)
  }


  /**
   * insert new user into DB
   *
   * @param name String
   * @param email String
   * @return
   */
  def insertUser(name: String, email: String) = {

    establishConnectionPool()

    val c = User.column
    withSQL {
      insert.into(User).namedValues(c.name -> name, c.email -> email, c.created_at -> DateTime.now)
    }.updateAndReturnGeneratedKey.apply()
  }


  /**
   * get all usernames on DB
   *
   * @return users List[Option[String]]
   */
  def selectAllUserName: List[Option[String]] = {
    establishConnectionPool()

    val u = User.syntax("u")
    val users = withSQL { select.from(User as u) }.map(rs => rs.stringOpt(u.resultName.name)).list.apply()

    return users
  }


}
