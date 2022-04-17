package basic

open class Shape

class Rectangle(var height: Double, var length: Double): Shape() {
    var perimeter = (height + length) * 2
}

fun main(args: Array<String>){
    println("Inheritance between classes is declared by a colon (:)")
    println("Classes are final by default")
    println("to make a class inheritable, mark it as open.")

}