package example.constructor

import org.scalatest.FunSuite

/**
  * Created by Tao Zhang on 1/29/18
  */
class SocketTest extends FunSuite {

  test("test default to 1000") {
    println(new Socket().timeout)
  }

  test("test 500") {
    println(new Socket(500).timeout)
  }

  test("test named parameters") {
    println(new Socket(timeout = 200).timeout)
  }

}
