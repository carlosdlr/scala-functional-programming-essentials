package lectures.part2oop

object Generics extends App {

  class MyList[+A] {
    // use the type A
    def add[B >: A](element: B): MyList[B] = ???
    /*
    A = Cat
    B = Animal
     */
  }

  class MyMap[key, value]
  //val listOfIntegers = new MyList[Int]
  //val listOfStrings = new MyList[String]

  //generic methods
  object MyList { // objects cannot be generic
    def empty[A]: MyList[A] = new MyList
  }

  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1. yes List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  //animalList.add(new Dog) ??? HARD Question => we return a list of animals

  // 2. No = Invariance
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. Hell, no Contravariance
  class Trainer[-A]
  val contravariantList: Trainer[Cat] = new Trainer[Animal]

  // bounded types
  class Cage[A <: Animal] (animal: A) // this means that the class cage only receive animal subtypes
  val cage = new Cage(new Dog)

  class Car
  //val newCage = new Cage(new Car)

  // expand MyList to be generic

  abstract class MyGenericList[+A] {
    /*
     head = first element of the list
     tail = last element of the list
     isEmpty = is this list empty
     add(int) => new list with this element added
     toString => a String representation of the list
     */

    def head: A
    def tail: MyGenericList[A]
    def isEmpty: Boolean
    def add[B >: A](element: B): MyGenericList[B]
    def printElements: String
    // polymorphic call
    override def toString: String = "[" + printElements + "]"
  }

  object Empty extends MyGenericList[Nothing] {
    def head: Nothing = throw new NoSuchElementException
    def tail: MyGenericList[Nothing] = throw new NoSuchElementException
    def isEmpty: Boolean = true
    def add[B >: Nothing](element: B): MyGenericList[B] = new Cons(element, Empty)
    def printElements: String = ""
  }

  class Cons[+A](h: A, t: MyGenericList[A]) extends MyGenericList[A] {
    def head: A = h
    def tail: MyGenericList[A] = t
    def isEmpty: Boolean = false
    def add[B >: A] (element: B): MyGenericList[B] = new Cons(element, this)
    def printElements: String = {
      if(t.isEmpty) "" + h
      else s"$h ${t.printElements}"
    }
  }


    val listOfIntegers: MyGenericList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
    val listOfStrings: MyGenericList[String] = new Cons("Hello", new Cons("Scala", Empty))
    println(listOfIntegers.toString)
    println(listOfStrings.toString)



}
