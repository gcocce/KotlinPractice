package patterns.strategy.general

// the client class, strategy is provided in the constructor
class Context(private val strategy: Strategy) {
    // using generic strategy interface
    fun useStrategy() = strategy.use()
}

interface Strategy { // using interface instead of class is very important
    // abstract or concrete class would limit using the strategy only to its hierarchy
    fun use() // strategies usually have single public method
}

class StrategyA : Strategy { // first strategy
    override fun use() { // concrete algorithm implementation
        println("using strategy A")
    }
}

class StrategyB : Strategy { // second strategy
    override fun use() {
        println("using strategy B")
    }
}

fun main() {
    // using either strategy is identical
    // strategies are transparent for the client
    val contextA = Context(StrategyA())
    contextA.useStrategy()
    val contextB = Context(StrategyB())
    contextB.useStrategy()
}
