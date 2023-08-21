import scala.io.StdIn.readInt
object Main {
  def main(args: Array[String]): Unit = {
    print("Enter numerator: ")
    var nume = readInt()
    print("Enter denominator: ")
    var deno = readInt()
    val num = Rational(nume, deno)
    val negnum = num.neg
    println("Rational number: " + num )
    println("Negative rational number: " + negnum)
  }
}

class Rational(n: Int, d: Int) {

  private val gcdVal: Int = gcd(n.abs, d.abs)
  val nume: Int = n/gcdVal
  val deno: Int = d/gcdVal


  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  def neg: Rational = new Rational(-nume, deno)

  override def toString: String = nume + "/" + deno
}

object Rational {
  def apply(n: Int, d: Int): Rational = new Rational(n, d)
}
