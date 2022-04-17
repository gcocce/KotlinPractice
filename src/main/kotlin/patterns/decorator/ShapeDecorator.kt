package patterns.decorator

abstract class ShapeDecorator(protected var decoratedShape: Shape) : Shape {

    override fun draw(): String{
        return decoratedShape.draw()
    }
}