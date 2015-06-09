package com.example.app

/**
 * Created by a13902 on 6/9/15.
 */


import java.sql.DriverManager
import java.sql.Connection
import scalikejdbc._

object ScalaJdbcConnectionSelect {
  def main(args: Array[String]) {

    /**
     * initial setup mysql database
     */
    val driver = "com.mysql.jdbc.Driver"
    val url = "jdbc:mysql://localhost/dev_mywebapp"
    val username = "root"
    val password = "root"

    var connection:Connection = null

    Class.forName(driver)
    ConnectionPool.singleton(url, username, password)
    implicit val session = AutoSession



    /**
     * create table statements
     */
//    sql"""
//          CREATE TABLE account (
//            id serial NOT NULL PRIMARY KEY,
//            name VARCHAR(64),
//            email VARCHAR(64),
//            created_at TIMESTAMP NOT NULL
//          )
//      """.execute.apply()

    /**
     * select statement
     */
//    import org.joda.time._
//    case class Customer(id: Long, name: Option[String])
//    object Customer_obj extends SQLSyntaxSupport[Customer] {
//      override val tableName = "name"
//
//      def apply(rs: WrappedResultSet) = new Customer(
//        rs.long("id"), name = rs.stringOpt("name")
//      )
//    }
//
//    val customers: List[Customer] = sql"select * from account".map(rs => Customer_obj(rs)).list.apply()
//    customers.foreach(c => println(c.name))

  }
}
