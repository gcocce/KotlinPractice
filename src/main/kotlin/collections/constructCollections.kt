package collections

import java.util.*
import kotlin.collections.HashSet

fun main(){

    /****Construct from elements***/

    /*  The most common way to create a collection is with the standard library functions

    listOf<T>(), setOf<T>(), mutableListOf<T>(), mutableSetOf<T>().

     mapOf() and mutableMapOf()

    If you provide a comma-separated list of collection elements as arguments, the compiler detects
    the element type automatically. When creating empty collections, specify the type explicitly.*/

    val numbersSet = setOf("one", "two", "three", "four")
    val emptySet = mutableSetOf<String>()

    val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key4" to 1)

    val numbersMap2 = mutableMapOf<String, String>().apply { this["one"] = "1"; this["two"] = "2" }


    /**** Empty collections ***/

    /*  There are also functions for creating collections without any elements:

    emptyList(), emptySet(), and emptyMap()

     */
    val listEmpty = emptyList<String>()
    val setEmpty = emptySet<String>()
    val mapEmpty = emptyMap<Int, Int>()


    /****** Initializer functions for list    ******/

    val doubled = List(3, { it * 2 })  // or MutableList if you want to change its content later
    println(doubled)


    /*******    Concrete type constructors **********/

    /*  To create a concrete type collection, such as an ArrayList or LinkedList,
    you can use the available constructors for these types. Similar constructors are available
    for implementations of Set and Map.*/

    val linkedList = LinkedList<String>(listOf("one", "two", "three"))
    val presizedSet = HashSet<Int>(32)


    /*******    Copy   **********/

    /* To create a collection with the same elements as an existing collection, you can use copying functions.

    Collection copying functions from the standard library (clone() copyOf()) create shallow copy collections
    with references to the same elements. Thus, a change made to a collection element reflects in all its copies. */

    /* Collection copying functions, such as toList(), toMutableList(), toSet() and others, create a snapshot
    of a collection at a specific moment. Their result is a new collection of the same elements.*/

    val origin = mutableListOf(1, 2, 3)
    val copy = origin       // create another reference
    origin.add(4)
    println("copy $copy")

    class Person(var name:String){
        override fun toString(): String {
            return name
        }
    }

    val alice = Person("Alice")
    val sourceList = mutableListOf(alice, Person("Bob"))
    val copyList = sourceList.toList()                          /***** create new list  ********/
    sourceList.add(Person("Charles"))
    alice.name = "Alicia"
    println("First item's name is: ${sourceList[0].name} in source and ${copyList[0].name} in copy")
    println("List size is: ${sourceList.size} in source and ${copyList.size} in copy")
    println("copyList ")
    for (e in copyList) print("$e ")
    println()

    /* These functions can also be used for converting collections to other types, for example, build a set from
    a list or vice versa.*/
    val sourceList2 = mutableListOf(1, 2, 3)
    val copySet = sourceList2.toMutableSet()
    copySet.add(3)
    copySet.add(4)
    println(copySet)


    /***** Invoke functions on other collections *****/

    /* Collections can be created in result of various operations on other collections. For example,
    filtering a list creates a new list of elements that match the filter:*/

    val numbers = listOf("one", "two", "three", "four")
    val longerThan3 = numbers.filter { it.length > 3 }
    println(longerThan3)

    /* Mapping produces a list of a transformation results: */
    val numbers2 = setOf(1, 2, 3)
    println(numbers2.map { it * 3 })
    println(numbers2.mapIndexed { idx, value -> value * idx })

    /* Association produces maps:*/

    val numbers3 = listOf("one", "two", "three", "four")
    println(numbers3.associateWith { it.length })







}