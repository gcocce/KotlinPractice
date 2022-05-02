package patterns.visitor.example1

internal class CarElementDoVisitor : CarElementVisitor {
    override fun visit(body: Body) {
        println("Moving my body")
    }

    override fun visit(car: Car) {
        println("Starting my car")
    }

    override fun visit(wheel: Wheel) {
        println("Kicking my " + wheel!!.name + " wheel")
    }

    override fun visit(engine: Engine) {
        println("Starting my engine")
    }
}