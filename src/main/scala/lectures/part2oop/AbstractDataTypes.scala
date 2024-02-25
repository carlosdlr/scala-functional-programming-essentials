package lectures.part2oop

object AbstractDataTypes extends App {

  // abstract classes cannot be instantiated
  abstract class Animal {
    val creatureType: String = "wild" // non abstract member
    def eat: Unit // abstract member
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    def eat: Unit = println("crunch crunch")
  }
  
  //  traits "multiple inheritance"
  trait Carnivore {
    def eat(animal:Animal): Unit
  }
  
  trait ColdBlooded
  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "croc"
    def eat: Unit = println("nomnomnom")
    def eat(animal:Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
  }
  
  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)
  
  // traits vs abstract classes
  // 1- traits do not have constructor arguments
  // 2- multiple traits maybe inherited by the same class
  // 3- traits = behavior 

}
