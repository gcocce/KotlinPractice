package patterns.decorator

class RedShapeDecorator(decoratedShape: Shape) : ShapeDecorator(decoratedShape) {

    override fun draw(): String {
        return drawWithRedBorder(decoratedShape)
    }

    private fun drawWithRedBorder(decoratedShape: Shape): String{
        return decoratedShape.draw() + " Red"
    }
}