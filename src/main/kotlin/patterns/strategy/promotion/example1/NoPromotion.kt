package patterns.strategy.promotion.example1

// this is a NullObject, a special case of Strategy not performing any actions
object NoPromotion : Promotion {
    override val name = "No Promotion"
    override fun calculate(sum: Double): Double {
        return sum
    }
}