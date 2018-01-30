package example.constructor

import org.scalatest.{BeforeAndAfterEach, FunSuite}

/**
  * Created by Tao Zhang on 1/29/18
  */
class UserTest extends FunSuite with BeforeAndAfterEach {

  val u = new User("alvinalexander", "secret")

  override def beforeEach() {
    u.address = Some(Address("Los Angeles", "CA", 90034.toString))
  }

  override def afterEach() {
    println(u)
  }

}
