// List
val list = List(1, 2, 3)
val list0 = 0 +: list
val list4 = list :+ 4
val list2 = List(5, 6)
val listx = list :: list4
val listy = list ::: list4
val a = (1 to 10)
a.toList
val b = (1 to 10 by 2)
b.toList
val c = (1 until 5).toList
val d = List.range(1, 5)
val e = List.range(1, 10, 3)