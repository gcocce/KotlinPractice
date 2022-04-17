package patterns.decorator

class ExtendedShape(private val innerShape: Shape ): Shape by innerShape {
    override fun draw(): String {
        return innerShape.draw() + " Extended"
    }
}