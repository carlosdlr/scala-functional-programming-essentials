package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(num: Int): Int = {
    if (num <= 0) 1
    else{
      println("Computing factorial of " + num + "- I first need factorial of " + (num-1))
      val result = num * factorial(num - 1)
      println("Computing factorial of " + num)
      result
    }
  }

  //println(factorial(10))
  //println(factorial(5000))

  def anotherFactorial(n: Int): BigInt = {
    @tailrec // to allow the compiler to double check if the implementation is tail recursive
    def factHelper(x: Int, accumulator: BigInt): BigInt = {
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator) // tail recursion = use recursive call as the last expression
    }
    factHelper(n, 1)
  }

  /*
   anotherFactorial(10) = factHelper(10,1)
   = factHelper(9, 10 * 1)
   = factHelper(8, 9 * 10 * 1)
   = factHelper(7, 8 * 9 * 10 * 1)
   = ...
   = factHelper(2, 3 * 4 * ... * 10 * 1)
   = factHelper(1, 1 * 2 * 3 * 4 *...* 10)
   = 1 * 2 * 3 * 4 * ... * 10
   */

  println(anotherFactorial(5000))

  // WHEN YOU NEED LOOPS, USE _TAIL_RECURSION

  @tailrec
  def concatenateTailRec(aString: String, n: Int, accumulator: String): String = {
    if(n <= 0) accumulator
    else concatenateTailRec(aString, n - 1, aString + " " + accumulator)
  }

  println(concatenateTailRec("carlos", 5, " "))

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailRec(t: Int, isStillPrime: Boolean): Boolean = {
      if(!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailRec(t -1, n % t !=0 && isStillPrime)
    }
    isPrimeTailRec(n / 2, true)
  }

  println(isPrime(2003))
  println(isPrime(629))

  def fibonacci(n: Int): Int = {
    def fibonacciTailRec(i: Int, last: Int, nextToLast: Int): Int = {
      if(i >=n) last
      else fibonacciTailRec(i + 1,  last + nextToLast, last)
    }
    if(n <= 2) 1
    else fibonacciTailRec(2, 1, 1)
  }

  println(fibonacci(8))

  def powerSum(X: Int, N: Int, start: Int = 1): Int = {
    if (Math.pow(start,N).toInt > X) 0
    else if (Math.pow(start,N).toInt == X) 1
    else powerSum(X, N, start + 1) + powerSum(X - Math.pow(start,N).toInt, N, start + 1)
  }


  println(powerSum(10,2))

}
