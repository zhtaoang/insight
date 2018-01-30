package example.inheritance

import example.constructor.Address
import org.scalatest.FunSuite

/**
  * Created by Tao Zhang on 1/30/18
  */
class EmployeeTest extends FunSuite {

  var sharedEmployee: Option[Employee] = None

  test("create an employee") {
    val teresa = new Employee("Teresa", Address("Louisville", "KY", "12345"), 25)
    println(teresa)
    sharedEmployee = Some(teresa)
  }

  test("the inherited mutator and accessor") {
    println(sharedEmployee.getOrElse(new Employee("", Address("", "", ""), 0)).name)
  }

}
