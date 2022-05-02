package patterns.visitor.example1

interface CarElement {
    fun accept(visitor: CarElementVisitor)
}