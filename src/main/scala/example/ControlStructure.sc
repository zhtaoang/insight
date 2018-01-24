
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

