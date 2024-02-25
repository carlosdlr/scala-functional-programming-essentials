package lectures.part2oop

object Inheritance extends App {

  sealed class Animal {
    val creatureType = "wild"
    def eat = println("nomnom")
  }
  // Single class inheritance
  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat

  cat.crunch

  // Constructors
  class Person(name: String, age: Int)
  class Adult(name:String, age: Int, idCard: String) extends Person(name, age)

  // Overriding
  class Dog(override val creatureType: String) extends Animal {
    //override val creatureType = "domestic"
    override def eat = {
      super.eat
      println("crunch, crunch")
    }
  }

  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)

  // type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  // overriding vs overloading

  //super

  // to prevent overrides
  // 1 - use final on class member
  // 2 - use final at class level
  // 3 - seal the class - extended classes in this file, prevent extension in other files
  // 4 -
}
