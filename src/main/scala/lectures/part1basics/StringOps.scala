package lectures.part1basics

object StringOps extends App {

  val str: String = "Hello, I am learning Scala"

  println(str.charAt(2))
  println(str.substring(7,11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.length)

  val aNumberString = "2"
  val number = aNumberString.toInt
  println('a' +: aNumberString :+ 'z') // prepending and appending
  println(str.reverse)
  println(str.take(2))

  // Scala specific: String interpolators

  // S-interpolators
  val name = "Carlos"
  val age = 33
  val greeting = s"Hello, my name is $name and I am $age year old"
  val anotherGreeting = s"Hello, my name is $name and I will be turning ${age + 1} years old" // in the interpolation you can use expressions
  println(greeting)
  println(anotherGreeting)

  // F-interpolators adds format
  val speed = 1.2f
  val myth = f"$name%s can eat $speed%2.2f burger per minute"
  println(myth)

  // raw-interpolators
  println(raw"This is a \n new line") // prints every literal character
  val escaped = "This is a \n new line"
  println(raw"$escaped") // raw interpolator escape characters when is used with variable interpolation
}
