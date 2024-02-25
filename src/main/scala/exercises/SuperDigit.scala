package exercises

object SuperDigit {
  def superDigit(n: String, k: Int = 1): Int = {
    def calcSuperDigit(num: String): Int = {
      if (num.length == 1) num.toInt
      else calcSuperDigit( num.map(_-'0').sum.toString )
    }

    if (k == 1) calcSuperDigit(n)
    else calcSuperDigit( (n * k).map(_-'0').mkString )
  }

  def main(args: Array[String]): Unit = {
    val number = "148"
    val k = 3
    println(s"The super digit of $number (* $k) is ${superDigit(number, k)}")
  }
}
