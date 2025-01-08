println("Hello World!")

// variable & value
// 1. val: for constant value
// 2. var: for changable value
// *Prio val > var. Except some cases
val value = "x"
var vari = 0
vari = 1
println(vari)


// controle structures
val result = 
    if (vari == 0) "It is zero" 
    else if (vari > 0) "Greater than zero"
    else "Less than zero"
// loops
val list = List(1, 2, 3)
for{ item <- list } print(item)
list.foreach(item => println(item))

// create new ds from old ds using for
for{ item <- list } yield item + 1

// recursion
def addOne(list: List[Int]) = {
    // take in original_list, create new_list : return list
    def recur(o: List[Int], n: List[Int]): List[Int] = {
        if(o.isEmpty) n
        else recur(o.tail, n :+ o.head + 1)
    }
    recur(list, List())
}

addOne(list)


// import in scala

// normal
import scala.concurrent.blocking
// list of library
import scala.concurrent.{Future, Promise}
// rename imported standard class
// in this case List in Java -> rename into JavaList
import java.util.{List => JavaList}


// OOP in scala
// Class parameter are class members
class Person(var firstName: String, var lastName: String) {
    var age = 0
    def printFullName() = println(s"$firstName $lastName")

    // override
    override def toString() = s"$firstName"
    print("end of constructor")
}
// can make class variable by not included "var" in front of them

val p = new Person("John", "Stephens")
println(p.firstName)
println(p.lastName)
p.printFullName()

// override result
p.toString()


// Scala *Right-Associative (swap side of parameter and instance of class)
class ScalaClass(value: String) {
    def oneParameter(x: String) = x
    def >>(some: String) = s" >> $some"
    // Right-Associative (add ":")
    def ->:(none: String) = s" -> $none"
}

val sc = new ScalaClass("something")
sc.oneParameter("skoolio")
sc oneParameter "skoolio"
sc.>>("skoolio")
sc >> "skoolio"
sc.->:("skoolio")
// Right-Associative
"skoolio" ->: sc


// Class Singleton (similar to static class in Java + can only has 1 instance)
object Logger {
    def printSomething(message: String) = println(s"Message $message")
}

class Project(name: String, dataToFinish: Int) {}

class Test {
    // can import function from object and use them (._ mean import all)
    import Logger._
    val project1 = new Project("a", 5)
    val project2 = new Project("b", 3)
    // function from "object Logger"
    printSomething("2 projects created")
}

val test = new Test


// Companion Object
// 1) class and object with the same name can exchange data
// 2) use this appoach to create multiple constructor for class
class companionPerson {
    var name = ""
    var age = 0
    def accessPrivateInformation() = println(companionPerson.HiddenFilename)
}

// Companion object
object companionPerson {
    // "apply" standard name for constructor in scala
    def apply(name: String, age: Int) = {
        var p = new companionPerson
        p.name = name
        p.age = age
        p
    }
    def apply(name: String) = {
        var p = new companionPerson
        p.name = name
        p
    }
    private val HiddenFilename = "/usr/save/private"
}

val p1 = companionPerson("roof1")
val p2 = companionPerson("roof2", 47)
p1.name
p1.age
p2.name
p2.age


// Case Class
// Let start from problem of other way to create class
val p3 = companionPerson("check")
val p4 = companionPerson("check")
// this return false because scala compare hash code of p3 and p4 not value inside
p3 == p4
// Case Class advantages
// 1) auto create apply method
// 2) auto create unapply (destuctor)
// 3) auto create copy method
// 4) auto create equals method
// 5) default toString is generated -> helpful for debugging
case class caseClassPerson(name:String, age:Int) {}

// now they are not showing hash code
val cp1 = caseClassPerson("roof", 47)
val cp2 = caseClassPerson("roof", 47)
cp1 == cp2
cp1.toString()
// this will be a really powerfull tool combine with pattern matching


// Trait (similar to interface)
trait TaskTrait {
    val id: Int
    def next(): TaskTrait
    def previous(): TaskTrait
}
// if we want to use class TaskTrait we have to implement all the members

// Pattern Matching (similar to switch cases)
// Example (Basic case)
val something = 9
something match
    case 1 => println("ONE")
    case 2 => println("TWO")
    // "_" = others case
    case _ => println("ELSE")

// (compare class value)
case class Something(content: String) {}
val first = Something("first")
val second = Something("second")
val third = Something("third")

third match
    case Something(content) if(content == "first") => println("FIRST")
    case Something(content) if(content == "second") => println("SECOND")
    case _ => println("ELSE")

// fizzBuzz 
// -> if input % 3 == 0 and input % 5 == 0 change it to FizzBuzz
// -> else if input % 3 == 0 change it to Fizz
// -> else if input % 5 == 0 change it to Buzz
// -> else do nothing
// pattern matching with Tuple
object Count {
    def fizzBuzzBasicIf(value: Int) = {
        if ((value % 3 == 0) && (value % 5 == 0)) "FizzBuzz"
        else if (value % 3 == 0) "Fizz"
        else if (value % 5 == 0) "Buzz"
        else value.toString()
    }
    def fizzBuzzPatternMatching(value: Int) = {
        (value % 3 == 0, value % 5 == 0) match
            case (true, true) => "FizzBuzz"
            case (true, flase) => "Fizz"
            case (flase, true) => "Buzz"
            case _ => value.toString()
    }
}

Count.fizzBuzzBasicIf(15)
Count.fizzBuzzPatternMatching(15)

// pattern matching with type (similar to polymorphism)
trait Animal {
    val name:String
}

case class Dog(name:String) extends Animal {}
case class Cat(name:String) extends Animal {}

val myDog = Dog("shiba")
val myCat = Cat("neko")

object Caller {
    def say(animal:Animal) = {
        animal match
            // "_" can be use if we only care for type
            case Dog(_) => println("woof")
            case Cat(name) => println("meaw")
            case _ => println("IDK")
    }
}

Caller.say(myDog)
Caller.say(myCat)