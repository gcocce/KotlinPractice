package patterns.visitor.example1

class Engine : CarElement {
    override fun accept(visitor: CarElementVisitor) {
        visitor.visit(this)
    }
}
