// scala has 2 appoch dealing with error 
// 1) "Option & Some & None"
// Option -> if there is no exception then return "Some"
def getElementByIndex(index:Int) : Option[Int] = {
    val list = List(1, 2, 3)
    try {
        Some(list.apply(index))
    }
    // In scala catch is used with case 
    catch {
        // If exception is catched return "None"
        case e: Exception => None
    }
}

getElementByIndex(9) match {
    case Some(value) => println(s"$value")
    case None => println("out of bound")
}


// 2) Try
import scala.util.{Try, Success, Failure}
def getElementByIndex2(index:Int) : Try[Int] = Try {
    val list2 = List(1, 2, 3)
    list2.apply(index)
}

getElementByIndex2(9) match {
    case Success(value) => println(s"$value")
    case Failure(exception) => println("out of bound")
}
