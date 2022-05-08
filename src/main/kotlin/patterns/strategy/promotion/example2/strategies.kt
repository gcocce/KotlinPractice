package patterns.strategy.promotion.example2

interface Tax {
    fun applyTaxes(sum: Double): Double
}

interface Promotion {
    val name: String
    fun applyPromotion(sum: Double): Double
}

interface LoyaltyProgram {
    fun applyPolicy(sum: Double): Double
}

object NewClient : LoyaltyProgram {
    override fun applyPolicy(sum: Double): Double {
        return sum * 0.9
    }
}

object ReturningClient : LoyaltyProgram{
    override fun applyPolicy(sum: Double): Double {
        return sum * 0.8
    }

}

// singleton, because this strategy doesn't need to keep its state - but it could
object ChristmasPromotion : Promotion {
    override val name = "Christmas Promotion"
    override fun applyPromotion(sum: Double): Double {
        return sum * 0.8
    }
}

// this is a NullObject, a special case of Strategy not performing any actions
object NoPromotion : Promotion {
    override val name = "No Promotion"
    override fun applyPromotion(sum: Double): Double {
        return sum
    }
}

object SpecialPromotion : Promotion {
    override val name = "Special Promotion"
    override fun applyPromotion(sum: Double): Double {
        return when {
            sum > 20 -> sum * 0.95
            sum > 30 -> sum * 0.85
            sum > 40 -> sum * 0.75
            else -> sum
        }
    }
}

object DefaultTax: Tax{
    override fun applyTaxes(sum: Double):Double{
        return sum * 1.21
    }
}

object NoTax: Tax{
    override fun applyTaxes(sum: Double): Double {
        return sum
    }

}


