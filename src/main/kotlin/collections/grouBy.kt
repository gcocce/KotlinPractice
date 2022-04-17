package collections

class Contact(var name:String, var age:Int) {
}

fun main(){
    /****** groupBy *****/

    /*The Kotlin standard library provides extension functions for grouping collection elements.
    The basic function groupBy() takes a lambda function and returns a Map. In this map,
    each key is the lambda result and the corresponding value is the List of elements
    on which this result is returned. */

    val list = arrayListOf<Contact>()

    list.add(Contact("juan", 23))
    list.add(Contact("juan", 24))
    list.add(Contact("juan", 25))
    list.add(Contact("pedro", 23))
    list.add(Contact("pedro", 24))

    val num = list.groupBy { it.name.first() }.count()

    println(num)

    val num2 = list.groupBy { it.name.first() }


    val numbers = listOf("one", "two", "three", "four", "five")
    println(numbers.groupBy { it.first().uppercase() })
    println(numbers.groupBy(keySelector = { it.first() }, valueTransform = { it.uppercase() }))


    /********** groupingBy()  *******************/

    /* If you want to group elements and then apply an operation to all groups at one time,
    use the function groupingBy(). It returns an instance of the Grouping type.
    The Grouping instance lets you apply operations to all groups in a lazy manner:
    the groups are actually built right before the operation execution. */

    val res = list.groupingBy { it.name.first() }.eachCount()
    println(res)

}