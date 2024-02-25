package lectures.part1basics

object TypeInference extends App {

  val message = "Type inference" // infers string
  val x = 2
  val y = x + "items" // x is an Int but it's follow by a string so the compilers infers a string concatenation
  // so y String

  def factorialFunction(num: Int) = {
    if (num <= 0) 1
    //else num * factorialFunction(num - 1) // in this case a product with a recursive call the compiler it's not able
    // to infer the type so is necessary to help it to adding the return type of the function
  }

}
