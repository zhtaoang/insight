package example.constructor

import org.scalatest.FunSuite

/**
  * Created by Tao Zhang on 1/29/18
  */
class SingletonAppleTest extends FunSuite {

  test("testSingleton") {
    val apple = SingletonApple.getInstance
    println(apple)
  }

}
