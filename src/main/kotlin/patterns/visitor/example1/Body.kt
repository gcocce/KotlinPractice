package patterns.visitor.example1

class Body : CarElement {
    override fun accept(visitor: CarElementVisitor) {
        visitor.visit(this)
    }
}