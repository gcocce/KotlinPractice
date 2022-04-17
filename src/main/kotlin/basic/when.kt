package basic

fun describe(obj: Any): String =
    when (obj) {
        1          -> "One"
        "Hello"    -> "Greeting"
        is Long    -> "Long"
        !is String -> "Not a string"
        else       -> "Unknown"
    }


fun main(){

    println(describe(2))
    println("Next......")
    println(describe(1))
    println("Next......")
    println(describe("asdf"))


}