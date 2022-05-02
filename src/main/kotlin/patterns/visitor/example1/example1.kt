package patterns.visitor.example1

fun main(){
    val car = Car()

    car.accept(CarElementPrintVisitor())
    car.accept(CarElementDoVisitor())
}