package lectures.part2oop

object Exceptions  extends App {

  val x: String = null
  //println(x.length) // this will crash due to a null pointer exception

  // throwing and catching exceptions

  //val aWierdValue: String = throw new NullPointerException

  // throwable classes extend the Throwable class.
  // Exception and Error are the major Throwable subtypes

  // 2. how to catch exceptions
  def getInt(withExceptions: Boolean): Int =
    if(withExceptions) throw new RuntimeException("No int for you")
    else 42

 val potentialFail = try {
   // code that might throw
   getInt(true)

 } catch {
   case e: RuntimeException => 43
 } finally {
   // code that will executed no matter what
   // optional
   // does not influence the return type of this expression
   // use finally only for side effects
   println("finally")
 }

 println(potentialFail)

 // 3. how to define your own exceptions
 class MyException extends Exception
 val exception = new MyException

 //throw exception

 /*
 1. crash your program with an OutOfMemoryError
 2. crash with stack overflow error
 3. pocket calculator
  - add(x,y)
  - subtract(x,y)
  - multiply(x,y)
  - divide(x,y)

 Throw
  - OverflowException if add(x,y) exceeds INT.MAX_VALUE
  - UnderflowException if subtract(x,y) exceeds Int.MIN_VALUE
  - MathCalculationException for division by 0
  */

  // OutOfMemoryException
  //val array = Array.ofDim[Int](Int.MaxValue)

 // Stack Overflow
// def infinite: Int = 1 + infinite
// val noLimit = infinite
  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by 0")

  object PocketCalculator {
   def add(x: Int, y: Int) = {
     val result = x + y
     if(x > 0 && y > 0 && result < 0) throw new OverflowException
     else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
     else result
   }

    def subtract(x: Int, y: Int) = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def multiply(x: Int, y: Int) = {
      val result = x * y
      if(x > 0 && y > 0 && result < 0) throw new OverflowException
      if(x < 0 && y < 0 && result < 0) throw new OverflowException
      else if(x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if(x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def div(x: Int, y: Int) = {
      if(y == 0) throw new MathCalculationException
      else x / y
    }


 }

  //println(PocketCalculator.add(Int.MaxValue, 10))
  println(PocketCalculator.div(2, 0))
}
