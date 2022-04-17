package basic

fun main(){
    val b: String?= ""

    val a = b?.length ?: -1

    println(a)

    val c: String?=null

    val d = c?.length ?: -1

    println(d)
}