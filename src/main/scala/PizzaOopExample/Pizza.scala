package PizzaOopExample

case class Pizza (
    val crustSize: CrustSize,
    val crustType: CrustType,
    val toppings: List[Topping]
) {

    def addTopping(t: Topping): Pizza = { copy( toppings = t +: toppings) }
    def removeTopping(t: Topping): Pizza = { copy( toppings = toppings.filter(_!=t)) }
    def removeAllToppings(): Pizza = { copy( toppings = List[Topping]()) }

    override def toString(): String = {
        val toppingsString = for (t <- toppings) yield t
        s"""Pizza:
           |  Crust Size: $crustSize
           |  Crust Type: $crustType
           |  $toppingsString
         """.stripMargin
    }

    def getPrice(
        toppingsPrices: Map[Topping, Int],
        crustSizePrices: Map[CrustSize, Int],
        crustTypePrices: Map[CrustType, Int]
    ): Int = {
        val crustTypePrice = 
            crustTypePrices.view.filter(_._1 == crustType).toMap.values.sum
        val crustSizePrice = 
            crustSizePrices.view.filter(_._1 == crustSize).toMap.values.sum
        val toppingPrice = 
            toppingsPrices.view.filterKeys(toppings.toSet).toMap.values.sum
        crustTypePrice + crustSizePrice + toppingPrice
    }

}


