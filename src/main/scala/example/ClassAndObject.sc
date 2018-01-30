class Person(var firstName: String, var lastName: String) {

  println("the constructor begins")

  // some class fields
  private val HOME = System.getProperty("user.home")
  var age = 0

  // some methods
  override def toString = s"$firstName $lastName is $age years old"
  def printHome { println(s"HOME = $HOME") }
  def printPersonInfo { println(this) }  // uses toString

  printHome
  printPersonInfo
  println("still in the constructor")

}

val p = new Person("Tao", "Zhang")
p.age = 20
p.firstName = "Apple"
p.lastName = "Pie"

println(p)

class Man(var name: String)

val m = new Man("Alvin Alexander")

println(m.name)
m.name = "Tao Zhang"
println(m.name)

class Woman(val name: String)

val w = new Woman("Serenity Green")
println(w.name)

class PrivatePerson(private var name: String) {
  def getName: String = {
    name
  }
}

val pp = new PrivatePerson("Private Me")
//pp.name is illegal
println(pp.getName)

case class Human(name: String) // case default field to val
val h = Human("A Human") // no New keyword
println(h.name)