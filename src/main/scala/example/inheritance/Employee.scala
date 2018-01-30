package example.inheritance

import example.constructor.Address

/**
  * Created by Tao Zhang on 1/30/18
  */
class Employee (name: String, address: Address, var age: Int) extends Person (name, address) {
  override def toString: String = super.toString + s"\n$age years old"
}
