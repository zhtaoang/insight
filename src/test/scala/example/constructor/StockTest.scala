package example.constructor

import org.scalatest.FunSuite

/**
  * Created by Tao Zhang on 1/29/18
  */
class StockTest extends FunSuite {

  test("test private field is accessible from another instance") {
    val stock1 = new Stock
    stock1.setPrice(1)
    val stock2 = new Stock
    stock2.setPrice(2)

    println(stock1.isHigherThan(stock2))
  }

}
