package example.constructor

/**
  * Created by Tao Zhang on 1/29/18
  */
class Stock {
  // a private field can be seen by any Stock instance!!!!!!!!!
  private var price: Double = _
  def setPrice(p: Double) { price = p }
  def isHigherThan(that: Stock): Boolean = this.price > that.price
}
