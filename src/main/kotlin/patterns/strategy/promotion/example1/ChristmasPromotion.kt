package patterns.strategy.promotion.example1

// singleton, because this strategy doesn't need to keep its state - but it could
object ChristmasPromotion : Promotion {
    override val name = "Christmas Promotion"
    override fun calculate(sum: Double): Double {
        return sum * 0.8
    }
}