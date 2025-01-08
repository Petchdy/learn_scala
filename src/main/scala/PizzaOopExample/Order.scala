package PizzaOopExample

case class Order (
    val pizzas: List[Pizza],
    val customer: Customer
) {

    def addPizza(p: Pizza): Order = {
        copy(pizzas = p +: pizzas)
    }

    def removePizza(p: Pizza): Unit = {
        copy(pizzas.filter(_ == p))
    }

    // need to implement these
    def getBasePrice(): Int = {
        pizzas.map(
            _.getPrice(
                toppingsPrices = PriceList.toppingPrice,
                crustSizePrices = PriceList.crustSizePrice,
                crustTypePrices = PriceList.crustTypePrice
            )
        ).sum
    }
    def getTaxes(): Double = getBasePrice() * 0.07
    def getTotalPrice(): Double = getBasePrice() + getTaxes()

    def printOrder(): Unit = {
        for (p <- pizzas) {
            println(p)
        }
    }

}
