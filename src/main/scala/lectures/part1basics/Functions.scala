package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String = { // defining a function
    a + " " + b
  }

  println(aFunction("Carlos", 81)) // calling a function

  def aParameterlessFunction(): Int = 42

  println(aParameterlessFunction())

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n== 1) aString
    else aString + " " +aRepeatedFunction(aString, n-1)
  }

  // in Scala instead of using loops we use recursion

  println(aRepeatedFunction("carlos", 5))

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b
    aSmallerFunction(n , n-1) // this will be the return type of the higher function. As we saw on code blocks
  }

  println(aBigFunction(5))

  /*
    1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old"
    2. Factorial function 1 * 2 * 3 * 4 *... * n
    3. A Fibonacci function
        f(1) = 1
        f(2) = 1
        f(n) = f(n - 1) + f(n -2)
     4. Tests if a number is prime.
   */

  def greetingFunction(name: String, age: Int): String = "Hi, my name is " + name + " and I am " + age+ " years old"
  println(greetingFunction("jose", 45))

  def factorialFunction(num: Int): Int = {
    if(num <= 0) 1
    else num * factorialFunction(num -1)
  }

  println(factorialFunction(5))

  def fibonacciFunction(num: Int): Int = {
    if (num <= 2) 1
    else fibonacciFunction(num -1) + fibonacciFunction(num -2)
  }

  println(fibonacciFunction(8))

  def isPrimeNumber(num: Int): Boolean = { // closure
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else num % t != 0 && isPrimeUntil(t - 1)
    }
      isPrimeUntil(num / 2)
   }

  println(isPrimeNumber(11))

}
