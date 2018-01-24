def square(x: Int) = x * x

square(2)

val greeting = "Hello, World!"

greeting

greeting.getClass.getTypeName

greeting.length

greeting.foreach(println)

for (x <- "apple") println(x)

"abc".getBytes().foreach(println)

val filtered = "hello world".filter(_ != 'l')

val cap = "scala".slice(2, 4).capitalize

cap == "Al"

val foo =
  """
    |This is
    |a "multiline"
    |String
  """.stripMargin/*.replaceAll("\n", " ")*/

"hello world".split(" ").foreach(println)//"\\s+"

val s = "eggs, milk, butter , Coco Puffs "
s.split(",").map(_.trim)

val name = "Fred"
val age = 33
val weight = 200.00
println(s"$name is $age years old, and weighs $weight pounds.")
val out = f"$name is $age years old, and weighs $weight%.0f pounds."


greeting.map(c => c.toUpper)

greeting.map(_.toUpper)

greeting.filter(_ != '!').map(_.toUpper)
for {
  c <- greeting
  if c != '!'
} yield c.toUpper

"hello".map(c => (c.toByte - 32).toChar)
"hello".map{c => (c.toByte - 32).toChar}

def myToUpperMethod(c: Char): Char = (c.toByte - 32).toChar
for (c <- "world") yield myToUpperMethod(c)
"world".map(myToUpperMethod)
"world".map{myToUpperMethod}
"world".map{c => myToUpperMethod(c)}

val myToUpperFunction = (c: Char) => (c.toByte - 32).toChar
"apple".map(myToUpperFunction)




val address = "123 Main Street Suite 101"
val numPattern = "[0-9]+".r
val match1 = numPattern.findFirstIn(address)
numPattern.findAllMatchIn(address).foreach(println)

val anotherAddress = "nothing in this will match"
val match2 = numPattern.findFirstIn(anotherAddress)
val orElse = match2.getOrElse("no match")

match1.foreach { e => println(s"Found a match: $e") }

match2 match {
  case Some(s) => println(s"Found $s")
  case None => println("Found nothing")
}

val pattern = "([0-9]+) ([A-Za-z]+)".r
val pattern(count, fruit) = "100 Bananas"

"hello".charAt(0)
"hello".apply(0)
"hello"(0)

implicit class StringImprovements(val s: String) {
  def increment: String = s.map(c => (c + 1).toChar)
  def hideAll: String = s.replaceAll(".", "*")
  def visible: Boolean = "[a-zA-Z]+".r.findAllIn(s).nonEmpty
}

"HAL".increment
"HAL".hideAll

"HAL".increment.visible
"HAL".hideAll.visible
