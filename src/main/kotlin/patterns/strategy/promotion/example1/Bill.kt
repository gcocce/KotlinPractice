package patterns.strategy.promotion.example1

interface Item{
    abstract val price: Double
}

class Bill {
    private val items = mutableListOf<Item>() // list of producsts on the bill
    fun addItem(item: Item): Bill {
        items.add(item)
        return this
    }

    // strategies can be passed in the constructor, or in the method that uses them
    fun calculateFinalPrice(promotion: Promotion): Double {
        println("applying ${promotion.name}")
        val initialSum = items.sumOf { it.price }
        return promotion.calculate(initialSum) // the promotion object calculates the price
    }
}


