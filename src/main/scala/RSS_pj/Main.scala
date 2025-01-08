package RSS_pj

import scalaj.http.{Http, HttpResponse}
import scala.xml.XML

object MyMain extends App {
    val response: HttpResponse[String] = Http("https://feeds.bbci.co.uk/news/science_and_environment/rss.xml").asString
    val xml = XML.loadString(response.body)
    val titles = xml.\\("item").\("title")
    // println(titles)
    val titleTexts = for{ title <- titles } yield title.text
    titleTexts.foreach(titleTexts => println(titleTexts))
}

// ***Short version***
// import scalaj.http.Http
// import scala.xml.XML

// object MyMain extends App {
//     val response = Http("https://feeds.bbci.co.uk/news/science_and_environment/rss.xml").asString
//     val xml = XML.loadString(response.body)
//     val titles = xml \\"item" \"title"
//     // println(titles)
//     val titleTexts = for{ title <- titles } yield title.text
//     titleTexts.foreach(println)
// }

