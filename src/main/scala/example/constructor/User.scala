package example.constructor

/**
  * Created by Tao Zhang on 1/29/18
  */
class User (var username: String, var password: String){

  var age = 0
  var firstName = ""
  var lastName = ""
  var address: Option[Address] = None

  override def toString: String = s"$username, $password, $address"

}



