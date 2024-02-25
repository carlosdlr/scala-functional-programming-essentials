package lectures.part1basics

object ValuesVariablesTypes extends  App {

  val x: Int = 42
  val y = 42 // types of variables are optional (dynamic typed?) compiler can infer types
  println(x)

  //x = 2 you cannot reassign values val are immutable or use for constants

  /* val a: String = "hello"; val b = "goodbye" semicolon is required to separate multiple single line statements this
  style is not recommended*/

  val a: String = "hello"
  val b = "goodbye"

  // types
  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short = 4613
  val aLong: Long = 4345345345353453534L
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  // variables
  var aVariable: Int = 4
  aVariable = 5 // side effects
}
