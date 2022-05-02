package patterns.visitor.example1

interface CarElementVisitor {
    fun visit(body: Body)
    fun visit(car: Car)
    fun visit(engine: Engine)
    fun visit(wheel: Wheel)
}