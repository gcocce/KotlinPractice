package patterns.visitor.example1

internal class CarElementPrintVisitor : CarElementVisitor {
    override fun visit(body: Body) {
        println("Visiting body")
    }

    override fun visit(car: Car) {
        println("Visiting car")
    }

    override fun visit(engine: Engine) {
        println("Visiting engine")
    }

    override fun visit(wheel: Wheel) {
        println("Visiting " + wheel!!.name + " wheel")
    }
}