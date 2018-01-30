package example.constructor

/**
  * Created by Tao Zhang on 1/29/18
  */
class SingletonApple private {
  override def toString = "This is the Apple."
}

object SingletonApple {
  val apple = new SingletonApple
  def getInstance = apple
}
