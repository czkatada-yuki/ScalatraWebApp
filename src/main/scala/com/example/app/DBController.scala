package com.example.app
import com.example.app.controller._

/**
 * Created by a13902 on 6/10/15.
 */
object DBController {

  def main(args: Array[String]) {
    val userController = new UserController
//    userController.insertUser("ponyo2", "ponyo2@gmail.com")
    val users: List[Option[String]] = userController.selectAllUserName

  }
}
