package patterns.visitor.example1

class Car : CarElement {

    private val elements: List<CarElement>

    init {
        elements = java.util.List.of(
            Wheel("front left"), Wheel("front right"),
            Wheel("back left"), Wheel("back right"),
            Body(), Engine()
        )
    }

    override fun accept(visitor: CarElementVisitor) {
        for (element in elements) {
            element.accept(visitor)
        }
        visitor!!.visit(this)
    }
}
