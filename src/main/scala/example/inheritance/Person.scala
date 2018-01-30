package example.inheritance

import example.constructor.Address

/**
  * Created by Tao Zhang on 1/30/18
  */
class Person (var name: String, var address: Address) {
  override def toString = if (address == null) name else s"$name\n$address"
}
