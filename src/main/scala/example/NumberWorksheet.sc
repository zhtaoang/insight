import scala.collection.JavaConverters._

Int.MaxValue
Int.MinValue

100.toFloat
100.toLong

Integer.parseInt("100", 2)

implicit class StringToInt(s: String) {
  def toInt(radix: Int) = Integer.parseInt(s, radix)
}

"100".toInt(2)

12.5.toInt
val l = 12.5.toLong
val L = 12L
l == L
l.isValidLong

val style1 = 0:Byte
val style2:Byte = 0
style1 == style2

val hex:Long = 0x20
hex.isInstanceOf[Long]

val s = "Tao"
val upCast = s: Object
upCast.isInstanceOf[Object]


var name = null.asInstanceOf[String]

var a: Int = 1
a += 1
println(a)
a -= 1
println(a)
a *= 2
println(a)
a /= 2
println(a)

var b = BigInt(1234567890)
b *= b

val bigIsBig = b > Int.MaxValue

val r = scala.util.Random
r.nextInt()

r.nextInt(100) // from 0 to 99

r.nextDouble // between 0.0 to 1.0

r.setSeed(1000L)

r.nextPrintableChar()

var range = 0 to r.nextInt(10)

for (i <- 0 to r.nextInt(10)) yield i * 2

range = 1 to 10

range = Range.inclusive(1, 10, 2)

for (i <- range) println(i)

for (i <- 1 to 5) println(i) // inclusive
for (i <- 1 until 5) println(i) // exclusive

val arr = range.toArray
val lis = range.toList

val array = (1 to 10).toArray
val list = (1 until 10).toList
val anotherArray = 1.to(10).toArray
val anotherList = 1.until(10).toList
val ranArr = 0.to(scala.util.Random.nextInt(10)).toArray

val dou = for (i <- 1 to 5) yield i * 2
val arrAgain = dou.toArray

val pi = scala.math.Pi
println(f"$pi%1.5f")
println(f"$pi%2.2f")

val formatter = java.text.NumberFormat.getInstance
formatter.format(1000000.33)

val currencyFormat = java.text.NumberFormat.getCurrencyInstance
currencyFormat.format(123456.789)

val x = if (pi > 4) pi else pi.toInt.toDouble
