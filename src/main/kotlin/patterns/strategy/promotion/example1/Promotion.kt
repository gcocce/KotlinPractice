package patterns.strategy.promotion.example1

interface Promotion {
    fun calculate(sum: Double): Double
    val name: String
}
