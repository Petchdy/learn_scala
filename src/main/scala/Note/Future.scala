package Note

// To create a concurrent program in scala use the following
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Failure
import scala.util.Success

object MainFuture extends App {

    // add key word "Future"
    def bakePizza(): Future[String] = Future {
        Thread.sleep(3000)
        "Pizza"
    }

    def makePasta(): Future[String] = Future {
        Thread.sleep(2000)
        "Pasta"
    }

    def makeDrink(): Future[String] = Future {
        Thread.sleep(1000)
        "Drink"
    }
    
    def currentTime = System.currentTimeMillis()
    def deltaTime(t0: Long) = currentTime - t0
    
    val startTime = currentTime
    
    // wait -> add .onComplete and error handling
    bakePizza().onComplete {
        case Success(value) => println("pizza is ready")
        case Failure(exception) => println("pizza is not ready")
    }
    makePasta().onComplete {
        case Success(value) => println("pasta is ready")
        case Failure(exception) => println("pasta is not ready")
    }
    makeDrink().onComplete {
        case Success(value) => println("drink is ready")
        case Failure(exception) => println("drink is not ready")
    }

    // group task (similar to barrier)
    val mainCourse = for {
        pizza <- bakePizza()
        pasta <- makePasta()
    } yield (pizza, pasta)

    mainCourse.onComplete{
        case Success(value) => println(s"maincourse is ready $value")
        case Failure(exception) => println("maincourse is not ready")
    }

    val totalTime = deltaTime(startTime)
    println(s"Total time is $totalTime")

}