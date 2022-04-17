package patterns.decorator

fun main(args: Array<String>) {

    println("Program arguments: ${args.joinToString()}")

    val circle: Shape = Circle();

    val redCircle: Shape  = RedShapeDecorator(Circle());

    val redRectangle: Shape = RedShapeDecorator(Rectangle());

    println("Circle with normal border");
    println(circle.draw())

    println("\nCircle of red border");
    println(redCircle.draw())

    println("\nRectangle of red border")
    println(redRectangle.draw())
}