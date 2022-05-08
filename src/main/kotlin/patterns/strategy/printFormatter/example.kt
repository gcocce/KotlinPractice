package patterns.strategy.printFormatter

class Printer(val stringFormatterStrategy: (String) -> String) {
    fun printString(string: String) = println(stringFormatterStrategy.invoke(string))
}

val lowerCaseFormatter = { it: String -> it.toLowerCase() }

val upperCaseFormatter = { it: String -> it.toUpperCase() }

fun main(args: Array<String>) {

    val lowerCasePrinter = Printer(lowerCaseFormatter)
    lowerCasePrinter.printString("LORE ipsum DOLOR sit amet")

    val upperCasePrinter = Printer(upperCaseFormatter)
    upperCasePrinter.printString("LORE ipsum DOLOR sit amet")

    val prefixPrinter = Printer({ "Prefix: " + it })
    prefixPrinter.printString("LORE ipsum DOLOR sit amet")
}