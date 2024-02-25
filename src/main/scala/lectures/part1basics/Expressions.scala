package lectures.part1basics

object Expressions extends App {

  val x = 1 + 2 //expression
  println(x)

  println(2 + 3 * 4)
  // math operators + - * / & | ^ << >> (bitwise operators) >>> (right shift with zero extension)

  println(1 == x) //boolean expression == != > >= < <=

  println(!(1 == x)) // logical negation ! && ||

  var aVariable = 2
  aVariable += 3 // increments also works with -= *= /=  ... side effects
  println(aVariable)

  // Instructions (DO) instructions are executed example java vs Expressions give me the value of.. are evaluated example
  // scala(VALUE)

  // IF expression
  val aCondition = true
  val aConditionValue = if (aCondition) 5 else 3 // IF EXPRESSION
  println(aConditionValue)
  println(if (aCondition) 5 else 3)
  println(1 + 3)

  // scala has loops but is discouraged due to doesn't return anything meaningful just side effects and belongs
  // to an imperative language like java

  var i = 0
  val aWhile = while (i < 10) {       // NEVER WRITE THIS AGAIN ON SCALA
    println(i)
    i += 1
  }
   // EVERYTHING in scala is an expression!
   val aWeirdValue = (aVariable = 3) // Unit type in scala is equivalent to void in java
   println(aWeirdValue)

  // side effects: println(), whiles, reassign

  // code block is an expression. the value of the code block is the last expression value

  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if(z > 2) "hello" else "goodbye"
  }

  println(aCodeBlock)

  // In Scala we'll think in terms of expressions
  // 1. difference between "hello world" vs println("hello world") ?
  // R/ "hello world" literal string value, println("hello world") is a side effect (returns Unit)
  // 2.
  val someValue = {
    2 < 3
  }

  val someOtherValue = {
    if (someValue) 239 else 498
    42
  }

  println(someValue)
  println(someOtherValue)

}
