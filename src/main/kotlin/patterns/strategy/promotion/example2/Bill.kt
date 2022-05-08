package patterns.strategy.promotion.example2

interface Item{
    abstract val price:Double
}

class Bill private constructor (
    private val tax: Tax,
    private val promotion: Promotion,
    private val clientPolicy: LoyaltyProgram
) {

    private val items = mutableListOf<Item>() // list of producsts on the bill
    fun addItem(item: Item): Bill {
        items.add(item)
        return this
    }

    fun calculateFinalPrice(): Double {
        val initialSum = items.sumOf { it.price }
        return initialSum
            .applyPromotion(promotion)
            .applyPolicy(clientPolicy)
            .applyTaxes(tax)
        // nice :)
    }


    companion object Factory{
        val defaultTax = DefaultTax
        val defaultPromotion = NoPromotion
        val defaultClientPolicy = NewClient

        fun returningClient(): Bill = Bill(
            defaultTax, defaultPromotion, ReturningClient
        )

        fun returningClientWithSpecialPromotion() = Bill(
            defaultTax, SpecialPromotion, ReturningClient
        )

        fun newClientAnarchist() = Bill(
            NoTax, defaultPromotion, NewClient
        )
    }
}

fun Double.applyPromotion(promotion: Promotion): Double {
    return promotion.applyPromotion(this)
}

fun Double.applyPolicy(policy: LoyaltyProgram): Double {
    return policy.applyPolicy(this)
}

fun Double.applyTaxes(tax: Tax): Double {
    return tax.applyTaxes(this)
}
