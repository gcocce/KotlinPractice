package generic.functions

fun <T> singletonList(item: T): List<T> {
    return listOf(item)
}

fun <T> T.basicToString(): String { // extension function
    return "basicToString message"
}

fun main(){
    val l = singletonList(1)

    println(l)
    print(l.basicToString())
}