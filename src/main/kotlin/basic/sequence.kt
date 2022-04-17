package basic

fun main(){

    println("Returns a sequence which invokes the function to calculate the next value on each iteration until the function returns null.")

    //val sequence = generateSequence(1){(it + 1).takeIf { it<0 }}.toList()

    val sequence = generateSequence(5){
        (it - 1 ).takeIf { it > 0 }
    }.toList()

    println("the end")
    println(sequence)
}