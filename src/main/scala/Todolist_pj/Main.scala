package Todolist_pj

trait Task {
  val id: Int
  def next(): Task
}

case class Todo(id:Int, title:String) {
  def next(): Doing = Doing(id, title)
}

case class Doing(id:Int, title:String) {
  def next(): Done = Done(id, title)
}

case class Done(id:Int, title:String) {
  def next(): Done = this
}

object MyMain extends App {

  val buyBanana = Todo(1, "buy banana")
  println(buyBanana)
  val buyingBanana = buyBanana.next()
  println(buyingBanana)
  val doneBuyBanana = buyingBanana.next()
  println(doneBuyBanana)

}

//// object States extends scala.Enumeration {
////   type State = value
//// var Todo, Doing, Done = Value
//// }

// trait State
// case object Todo extends State
// case object Doing extends State
// case object Done extends State

// trait TaskTrait {
//   val id:Int
//   def next(): TaskTrait
// }

// case class Task(id:Int, title:String, state:State) extends TaskTrait {
//   // import States._
//   def next(): Task {
//     if (state == Todo) copy(state = Doing)
//     else if (state == Doing)  copy(state = Done)
//     else this
//   }
// }

// val buyBanana = Task(1, "buy banana", Todo)
// val buyingBanana = buyBanana.next()