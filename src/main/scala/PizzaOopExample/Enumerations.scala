package PizzaOopExample

sealed trait Topping
case object Cheese extends Topping
case object Pepperoni extends Topping
case object Sausage extends Topping
case object Mushrooms extends Topping
case object Onions extends Topping

sealed trait CrustSize
case object SmallCrustSize extends CrustSize
case object MediumCrustSize extends CrustSize
case object LargeCrustSize extends CrustSize

sealed trait CrustType
case object RegularCrustType extends CrustType
case object ThinCrustType extends CrustType
case object ThickCrustType extends CrustType

object PriceList {
    val toppingPrice: Map[Topping, Int] = Map(  
                                                Cheese -> 1, 
                                                Pepperoni -> 2, 
                                                Sausage -> 3,
                                                Mushrooms -> 4,
                                                Onions -> 5
                                            )
    val crustSizePrice: Map[CrustSize, Int] = Map(
                                                SmallCrustSize -> 1,
                                                MediumCrustSize -> 2,
                                                LargeCrustSize -> 3
                                            )
    val crustTypePrice: Map[CrustType, Int] = Map(
                                                RegularCrustType -> 1,
                                                ThinCrustType -> 2,
                                                ThickCrustType -> 3
                                            )
}