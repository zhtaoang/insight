package example.constructor

import org.scalatest._

/**
  * Created by Tao Zhang on 1/29/18
  */

class PizzaTest extends FlatSpec {

  val defaultPizza = new Pizza()

  "defaultPizza" should "be 12 inch" in {
    assert(defaultPizza.crustSize==12)
  }

  it should "also be thin" in {
    assert(defaultPizza.crustType=="THIN")
  }

  println(defaultPizza)

}