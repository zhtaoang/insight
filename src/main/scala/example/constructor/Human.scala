package example.constructor

/**
  * Created by Tao Zhang on 1/29/18
  */
case class Human(var name: String, var age: Int) {
  override def canEqual(that: Any): Boolean = that.isInstanceOf[Human]

  override def equals(that: Any): Boolean = {
    canEqual(that) && this.hashCode() == that.hashCode()
  }

  override def hashCode(): Int = {
    val prime = 31
    var result = 1
    result = prime * result + age
    result = prime * result + (if (name == null) 0 else name.hashCode)
    result
  }
}

// the companion object
object Human {

  def apply() = new Human("<no name>", 0)
  def apply(name: String) = new Human(name, 0)

}