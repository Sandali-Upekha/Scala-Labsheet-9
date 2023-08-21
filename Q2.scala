import scala.io.StdIn.readInt
object RationalDemo {
  def main(args: Array[String]): Unit = {
    println("Numebr x")
    print("Enter numerator: ")
    var xnume = readInt()
    print("Enter denominator: ")
    var xdeno = readInt()

    println("Numebr y")
    print("Enter numerator: ")
    var ynume = readInt()
    print("Enter denominator: ")
    var ydeno = readInt()

    println("Numebr z")
    print("Enter numerator: ")
    var znume = readInt()
    print("Enter denominator: ")
    var zdeno = readInt()


    val x = MyRational(xnume, xdeno)
    val y = MyRational(ynume, xdeno)
    val z = MyRational(znume, zdeno)

    val result = x - y - z
    println("x = " + x)
    println("y = " + y)
    println("z = " + z)
    println("x - y - z = " + result)
  }
}

class MyRational(n: Int, d: Int) {

  private val gcdValue: Int = gcd(n.abs, d.abs)
  val numerator: Int = n / gcdValue
  val denominator: Int = d / gcdValue

  def this(n: Int) = this(n, 1)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  def +(other: MyRational): MyRational = new MyRational(
    numerator * other.denominator + other.numerator * denominator,
    denominator * other.denominator
  )

  def -(other: MyRational): MyRational = new MyRational(
    numerator * other.denominator - other.numerator * denominator,
    denominator * other.denominator
  )

  override def toString: String = numerator + "/" + denominator
}

object MyRational {
  def apply(n: Int, d: Int): MyRational = new MyRational(n, d)

}
