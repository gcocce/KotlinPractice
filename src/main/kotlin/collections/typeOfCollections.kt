package collections

fun main(args: Array<String>){

    println("test2")

    /*  List<T>

        List<T> stores elements in a specified order and provides indexed access to them. Indices start from zero –
        the index of the first element – and go to lastIndex which is the (list.size - 1).*/

    val numbers = listOf("one", "two", "three", "four")
    println("Number of elements: ${numbers.size}")
    println("Third element: ${numbers.get(2)}")

    /*MutableList<T>
        is a List with list-specific write operations, for example, to add or remove an element
        at a specific position.
    * */
    val numbers2 = mutableListOf(1, 2, 3, 4)
    numbers2.add(5)
    numbers2.removeAt(1)
    numbers2[0] = 0
    println("Third element: ${numbers2.get(2)}")
    numbers2.shuffle()
    println("Third element: ${numbers2.get(2)}")
    println(numbers2)


    /* Set<T> stores unique elements; their order is generally undefined. null elements are unique as well:
    a Set can contain only one null. Two sets are equal if they have the same size, and for each element
    of a set there is an equal element in the other set. */

    val numbers3 = setOf(1, 2, 3, 4)
    println("Number of elements: ${numbers3.size}")
    if (numbers3.contains(1)) println("1 is in the set")

    val numbersBackwards = setOf(4, 3, 2, 1)
    println("The sets are equal: ${numbers3 == numbersBackwards}")


    /*  MutableSet is a Set with write operations from MutableCollection.

        The default implementation of Set – LinkedHashSet – preserves the order of elements insertion.
        Hence, the functions that rely on the order, such as first() or last(), return predictable results
        on such sets.*/

    val numbers4 = setOf(1, 2, 3, 4)  // LinkedHashSet is the default implementation
    val numbersBackwards2 = setOf(4, 3, 2, 1)

    println(numbers4.first() == numbersBackwards2.first())
    println(numbers4.first() == numbersBackwards2.last())

    /*  An alternative implementation – HashSet – says nothing about the elements order,
    so calling such functions on it returns unpredictable results. However, HashSet requires less
    memory to store the same number of elements.*/

    /*  Map

        Map<K, V> is not an inheritor of the Collection interface; however, it's a Kotlin collection type as well.
        A Map stores key-value pairs (or entries); keys are unique, but different keys can be paired with equal
         values. The Map interface provides specific functions, such as access to value by key, searching keys
          and values, and so on.

          Two maps containing the equal pairs are equal regardless of the pair order.
          */

    val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key4" to 1)

    println("All keys: ${numbersMap.keys}")
    println("All values: ${numbersMap.values}")
    if ("key2" in numbersMap) println("Value by key \"key2\": ${numbersMap["key2"]}")
    if (1 in numbersMap.values) println("The value 1 is in the map")


    /* MutableMap is a Map with map write operations, for example, you can add a new key-value pair or
    update the value associated with the given key.     */

    val numbersMap2 = mutableMapOf("one" to 1, "two" to 2)
    numbersMap2.put("three", 3)
    numbersMap2["one"] = 11

    println(numbersMap2)

}