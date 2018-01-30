package example.constructor

import org.scalatest.FunSuite

/**
  * Created by Tao Zhang on 1/29/18
  */
class HumanTest extends FunSuite {

  test("testApply") {
    val person = Human()
    println(person)
    person.age = 10
    person.name = "Tao"
    println(person)
  }

  test("testDefault") {
    val another = Human("Apple", 5)
    println(another)
    another.name = "Pear"
    another.age = 2
    println(another)
  }

  val nimoy1 = new Human("Leonard Nimoy", 82)
  val nimoy2 = new Human("Leonard Nimoy", 82)

  test("nimoy1 == nimoy2") {
    assert(nimoy1 == nimoy2)
  }

}
