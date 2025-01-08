// Map
val items = Map (
    "a" -> 100,
    "b" -> 200,
    "c" -> 300
)
items.keys
items.values

val states = collection.mutable.Map("Tk" -> "Tokyo")
states += ("Osk" -> "Osaka")
states ++= Map("Ac" -> "Aichi", "Stm" -> "Saitama")
states -= ("Ac")
states("Tk") = "Tokyo!"
states("Tk")

val ratings = Map (
    "A" -> 2,
    "B" -> 3,
    "C" -> 4
)

for (rating <- ratings) println(rating._1)
for ((k, v) <- ratings) println(s"$k, $v")
ratings.foreach {
    case (k, v) => {
        println(s"$k, $v")
    }
}


// Filter (functional programing)
val ints = (1 to 10).toList
ints.map(in => in + 1)
ints.map(_ + 1)
ints.filter(_ > 5)
ints.filter(_ > 5).sum()

ratings

ratings.view.filterKeys(Set("B", "C")).toMap.values.sum