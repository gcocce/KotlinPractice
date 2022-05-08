package patterns.strategy.promotion.example1

object SpecialPromotion : Promotion {
    override val name = "Special Promotion"
    override fun calculate(sum: Double): Double {
        return when {
            sum > 20 -> sum * 0.95
            sum > 30 -> sum * 0.85
            sum > 40 -> sum * 0.75
            else -> sum
        }
    }
}