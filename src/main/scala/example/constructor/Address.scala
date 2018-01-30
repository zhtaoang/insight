package example.constructor

/**
  * Created by Tao Zhang on 1/30/18
  */
case class Address(city: String, state: String, zip: String) {
  override def toString: String = s"$city, $state $zip"
}
