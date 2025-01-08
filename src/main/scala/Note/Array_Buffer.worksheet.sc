// Array Buffer
// 1) create arrbuffer from scala collection
val arrbuffer = scala.collection.mutable.ArrayBuffer[Int]()
// 2) another way to create
val nums = scala.collection.mutable.ArrayBuffer(1, 2, 3)
// 3) manipulate arr buffer
nums += 4
nums += 5 += 6
nums ++= List(7, 8, 9)
nums -= 9
nums -= 8 -= 7
nums --= List(5, 6)
nums --= Array(3, 4)

nums.append(3)
nums.appendAll(Seq(5, 8))
nums.clear

nums.insert(0, 5)
nums

nums.insertAll(0, Vector(1, 2, 3, 4))
nums.prepend(0)

nums.remove(5)
nums

val d = scala.collection.mutable.ArrayBuffer.range('a', 'f')
d.trimStart(2)
d.trimEnd(2)
d