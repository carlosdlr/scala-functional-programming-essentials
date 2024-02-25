package lectures.part2oop
                          // alias
import playground.{Luigi, Mario => Plumber}
//import playground._ // to import everything

import java.util.Date
import java.sql.{Date => SqlDate}

object PackagingAndImports extends App {

  // package members are accessible by their simple name
  val writer = new Writer("Daniel", "RockTheJVM", 2018)

  val mario = new Plumber // playground.Mario = fully qualified name

  // packages are in hierarchy
  // matching folder structure

  // package object
  sayHello
  println(SPEED_OF_LIGHT)

  // imports
  val luigi = new Luigi

  // 1. use fully qualified name
  val date = new Date
  val sqlDate = new SqlDate(2018, 5, 4)
  // 2. use aliases
  
  //default imports
  // java.lang - String, Object, Exception
  // 

}
