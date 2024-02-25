package lectures.part3fp

object AnonymousFunctions extends App {

  // anonymous function (Lambda)
  val doubler = (x: Int) => x * 2

  // multiple params in a lambda
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  // no params
  val justDoSomething: () => Int = () => 3

  println(justDoSomething) //function itself
  println(justDoSomething()) // call

  val stringToInt = { (str: String) =>
    str.toInt
  }

  //syntactic sugar
  val niceIncrement: Int => Int = _ +1 // equivalent to x => x + 1
  val niceAdder : (Int, Int) => Int = _ + _ // equivalent to (a,b) => a + b

  /*
   1. MyList: Replace all functionX calls with lambdas
   2. the "special" adder as an anonymous function
   */

  val superAdd = (x: Int) => (y: Int) => x + y

 }
