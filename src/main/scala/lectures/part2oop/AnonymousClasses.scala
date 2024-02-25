package lectures.part2oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  //Anonymous Class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("hahahahahaha")
  }
  /* how the compiler under the hood creates an anonymous class
  class AnonymousClasses$$anon$1 extends Animal {
    override def eat: Unit = println("hahahahahaha")
  }
  val funnyAnimal: Animal = new AnonymousClasses$$anon$1
   */

  println(funnyAnimal.getClass)

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name $name, how can i help?")
  }

  val jim = new Person("jim") {
    override def sayHi: Unit = println(s"Hi, my name jim, how can i help?")
  }

  /*
    1. Generic trait MyPredicate[T] with a little method test(T) => Boolean
    2. Generic trait MyTransformer[A, B] with a method transform(A) => B
    3. MyList:
      - map(transformer) => MyList
      - filter(predicate) => MyList
      - flatMap(transformer from A to MyList[B]) => MyList[B]

      class EvenPredicate extends MyPredicate[Int]
      class StringToIntTransformer extends MyTransformer[String, Int]

      [1,2,3].map(n * 2) = [2,4,6]
      []
   */

}
