
val nieces = List("emily", "hannah", "mercedes", "porche")
val capNieces = for (n <- nieces) yield n.capitalize // for comprehension will yield a new collection

val fruits = Array("apple", "banana", "orange")

for (f <- fruits) print(s"$f is a fruit ")

for (f <- fruits) {
  println(s"$f is indeed a fruit")
}

//build a new collection -- of the same type
val upArray = for (e <- fruits) yield e.toUpperCase
val wordArray = for (e <- fruits) yield e.capitalize

for (i <- 0 until fruits.length) {
  printf("%s is %s\n", i, fruits(i))
}

for (i <- fruits.indices) {
  printf("%s is %s\n", i, fruits(i))
}

for ((e, count) <- fruits.zipWithIndex) {
  println(s"$count is $e")
}

for (i <- 1 to 3) println(i)

val names = Map("fname" -> "Robert", "lname" -> "Goren")
for ((k, v) <- names) println(s"key: $k, value: $v")


fruits.foreach(println)
fruits.foreach(f => println(f.capitalize))

fruits.foreach {
  e =>
    val s = e.toUpperCase()
    println(s)
}

for {
  i <- 1 until 10
  if i % 2 == 0
} println(i)

1.until(10).withFilter(x => x % 2 == 0).foreach(println)

for ( i <- 1 to 10 ) yield i
1.to(10).map((a) => a).toVector

for (i <- 1 to 2; j <- 1 to 2) println(s"i=$i; j=$j")

for {
  i <- 1 to 2
  j <- 1 to 2
} println(s"i=$i; j=$j")

val twoD = Array.ofDim[Int](2, 2)
twoD(0)(0) = 0
twoD(0)(1) = 1
twoD(1)(0) = 2
twoD(1)(1) = 3

for {
  i <- 0 until 2
  j <- 0 until 2
} println(s"2D array($i)($j) = ${twoD(i)(j)}")


for {
  i <- 0 to 10
  if i % 2 == 0
} println(i)

for (i <- 0 to 10 if i % 2 == 0) println(i)

for {
  i <- 0 to 10
  if 3 < i && i< 9
  if i % 2 == 0
} println(i)

// version 1 (tuples)
names foreach (x => println (x._1 + "-->" + x._2))

// version 2 (foreach and case)
names foreach {case (key, value) => println (key + "-->" + value)}

val nameValues = names.values.toArray
val capNames = for (n <- nameValues) yield n.toUpperCase

val initials = for (n <- capNames) yield {
  if (n.nonEmpty) {
    val s = n.charAt(0).toLower
    s.toString.toUpperCase()
  }
}

var f = scala.collection.mutable.ArrayBuffer[String]()
fruits.foreach(x => f += x)
f.appendAll("pear" :: "cherry" :: Nil)

val out = for (e <- f) yield e.capitalize
val outL = out.toList

val up = for (o <- outL) yield o.toUpperCase
val anotherUp = outL.map(_.toUpperCase)

val count = "peter piper picked a peck of pickled peppers".count(_ == 'p')

def sumToMax(arr: Array[Int], limit: Int): Int = {
  var sum = 0
  for (i <- arr) {
    sum += i
    if (sum > limit) return limit
  }
  sum
}
val a = Array.range(0,10)
println(sumToMax(a, 20))

def factorial(n: Int): Int = {
  if (n == 1) 1
  else n * factorial(n - 1)
}
println(factorial(4))

import scala.annotation.tailrec

def fac(n: Int): Int = {
  @tailrec def facAcc(acc: Int, n: Int): Int = {
    if (n <= 1) acc
    else facAcc(n * acc, n - 1)
  }
  facAcc(1, n)
}
println(fac(4))

def abs(n: Int) : Int = {
  if (n < 0) -n else n
}
println(abs(-1))

def max(a: Int, b: Int) : Int = if (a > b) a else b
println(max(-1, 5))

val monthNumberToName = Map(
  1  -> "January",
  2  -> "February",
  3  -> "March",
  4  -> "April",
  5  -> "May",
  6  -> "June",
  7  -> "July",
  8  -> "August",
  9  -> "September",
  10 -> "October",
  11 -> "November",
  12 -> "December"
)

val monthName = monthNumberToName(4)

def getClassType(x: Any): String = x match {
  case s: String => "String"
  case i: Int => "Int"
  case f: Float => "Float"
  case f: Float => "Float"
  case l: List[_] => "List"
  case lo: Long => "Long"
  case default => "UnknownType: " + default.getClass.getSimpleName// default is not a keyword, it can be any string at the end of switch
}

getClassType(12.toByte)

val i = 5
i match {
  case 1 | 3 | 5 | 7 | 9 => println("odd")
  case 2 | 4 | 6 | 8 | 10 => println("even")
}

val evenOrOdd = i match {
  case 1 | 3 | 5 | 7 | 9 => "odd"
  case 2 | 4 | 6 | 8 | 10 => "even"
}
println(evenOrOdd)

val cmd = "stop"
cmd match {
  case "start" | "go" => println("starting")
  case "stop" | "quit" | "exit" => println("stopping")
  case _ => println("doing nothing")
}

case class Person(firstName: String, lastName: String)
case class Dog(name: String)

def echoWhatYouGaveMe(x: Any): String = x match {

  // constant patterns
  case 0 => "zero"
  case true => "true"
  case "hello" => "you said 'hello'"
  case Nil => "an empty List"

  // sequence patterns
  case List(0, _, _) => "a three-element list with 0 as the first element"
  case List(1, _*) => "a list beginning with 1, having any number of elements"
  case Vector(1, _*) => "a vector starting with 1, having any number of elements"

  // tuples
  case (a, b) => s"got $a and $b"
  case (a, b, c) => s"got $a, $b, and $c"
  case (a, b, c, _) => s"4-elem tuple"

  // constructor patterns
  case Person(first, "Alexander") => s"found an Alexander, first name = $first"
  case Dog("Suka") => "found a dog named Suka"

  // typed patterns
  case s: String => s"you gave me this string: $s"
  case i: Int => s"thanks for the int: $i"
  case f: Float => s"thanks for the float: $f"
  case a: Array[Int] => s"an array of int: ${a.mkString(",")}"
  case as: Array[String] => s"an array of strings: ${as.mkString(",")}"
  case d: Dog => s"dog: ${d.name}"
  case list: List[_] => s"thanks for the List: $list"
  case m: Map[_, _] => m.toString

  // the default wildcard pattern
//  case _ => "Unknown"
  case foo => s"Hmm, you gave me a $foo"
}

// trigger the constant patterns
println(echoWhatYouGaveMe(0))
println(echoWhatYouGaveMe(true))
println(echoWhatYouGaveMe("hello"))
println(echoWhatYouGaveMe(Nil))

// trigger the sequence patterns
println(echoWhatYouGaveMe(List(0,1,2)))
println(echoWhatYouGaveMe(List(1,2)))
println(echoWhatYouGaveMe(List(1,2,3)))
println(echoWhatYouGaveMe(Vector(1,2,3)))

// trigger the tuple patterns
println(echoWhatYouGaveMe((1,2)))         // two element tuple
println(echoWhatYouGaveMe((1,2,3)))       // three element tuple

// trigger the constructor patterns
println(echoWhatYouGaveMe(Person("Melissa", "Alexander")))
println(echoWhatYouGaveMe(Dog("Suka")))

// trigger the typed patterns
println(echoWhatYouGaveMe("Hello, world"))
println(echoWhatYouGaveMe(42))
println(echoWhatYouGaveMe(42F))
println(echoWhatYouGaveMe(Array(1,2,3)))
println(echoWhatYouGaveMe(Array("coffee", "apple pie")))
println(echoWhatYouGaveMe(Dog("Fido")))
println(echoWhatYouGaveMe(List("apple", "banana")))
println(echoWhatYouGaveMe(Map(1->"Al", 2->"Alexander")))

// trigger the wildcard pattern
println(echoWhatYouGaveMe(33d))

def matchType(x: Any): String = x match {

  //case x: List(1, _*) => s"$x"          // doesn't compile
  case x @ List(1, _*) => s"$x"           // works; prints the list

  //case Some(_) => "got a Some"          // works, but can't access the Some
  //case Some(x) => s"$x"                 // works, returns "foo"
  case x @ Some(_) => s"$x"               // works, returns "Some(foo)"

  case p @ Person(first, "Doe") => s"$p"  // works, returns "Person(John,Doe)"

}

println(matchType(List(1,2,3)))            // prints "List(1, 2, 3)"
println(matchType(Some("foo")))            // prints "Some(foo)"
println(matchType(Person("John", "Doe")))  // prints "Person(John,Doe)"

def toInt(s: String): Option[Int] = {
  try {
    Some(Integer.parseInt(s.trim))
  } catch {
    case e: Exception => None
  }
}

toInt("42  ") match {
  case Some(i) => println(s"Int with value $i")
  case None => println("That wasn't an Int.")
}

def num(i: Int) = i match {
  case a if 0 to 9 contains a => println("0-9 range: " + a)
  case b if 10 to 19 contains b => println("10-19 range: " + b)
  case c if 20 to 29 contains c => println("20-29 range: " + c)
  case _ => println("Hmmm...")
}

num(13)

val list = 1 :: 2 :: 3 :: 4 :: Nil

//recursive call
def listToString (list: List[Int]): String = list match {
  case pre :: rest => pre + " " + listToString(rest)
  case Nil => ""
}

println(listToString(list))

def sum (list: List[Int]): Int = list match {
  case Nil => 0
  case n :: rest => n + sum(rest)
}

def multiply(list: List[Int]): Int = list match {
  case Nil => 1
  case n :: rest => n * multiply(rest)
}

println(sum(list))
println(multiply(list))

val s = "Foo"
try {
  val i = s.toInt
} catch {
  case bad: NumberFormatException => println("bad format") throw bad
  case ex: Exception => ex.printStackTrace()
  case other: Throwable => //ignore
}

@throws(classOf[NumberFormatException])
def toIntThrow(s: String): Option[Int] =
  try {
    Some(s.toInt)
  } catch {
    case e: NumberFormatException => throw e
  }

