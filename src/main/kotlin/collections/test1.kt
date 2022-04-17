package collections

/*The following collection types are relevant for Kotlin:

    List is an ordered collection with access to elements by indices – integer numbers that reflect their position.
    Elements can occur more than once in a list. An example of a list is a telephone number: it's a group of digits,
    their order is important, and they can repeat.

    Set is a collection of unique elements. It reflects the mathematical abstraction of set: a group of objects
    without repetitions. Generally, the order of set elements has no significance. For example, the numbers on
     lottery tickets form a set: they are unique, and their order is not important.

    Map (or dictionary) is a set of key-value pairs. Keys are unique, and each of them maps to exactly one value.
    The values can be duplicates. Maps are useful for storing logical connections between objects, for example,
    an employee's ID and their position.
*/


fun List<String>.getShortWordsTo(shortWords: MutableList<String>, maxLength: Int) {
    this.filterTo(shortWords) { it.length <= maxLength }
    // throwing away the articles
    val articles = setOf("a", "A", "an", "An", "the", "The")
    shortWords -= articles
}


fun main() {
    val words = "A long time ago in a galaxy far far away".split(" ")
    val shortWords = mutableListOf<String>()
    words.getShortWordsTo(shortWords, 30)
    println(shortWords)
}
