package lectures.part1basics

object CBNvsCBV extends App {

  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  def calledByName(x: => Long): Unit = {
    println("by name: " + x) // it's evaluated every time
    println("by name: " + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  //printFirst(infinite(), 34) // here throws a stack overflow exception
  printFirst(34, infinite()) // here not fails because of the y parameter it's not used

  // Call by value:
  // value is computed before all
  // same value used everywhere

  //Call by name
  // expression is passed literally
  // expression is evaluated at every use within

}
