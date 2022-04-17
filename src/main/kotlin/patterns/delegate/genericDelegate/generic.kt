package patterns.delegate.genericDelegate

interface Base {
    val message: String
    fun print()
}

class BaseImpl(val x: Int) : Base {
    override val message = "BaseImpl: x = $x"
    override fun print() { println(message) }
}

class BaseImpl2(val x: Int) : Base {
    override val message = "BaseImpl2: x = $x"
    override fun print() { println(message) }
}

class Derived<T : Base>(b: T) : Base by b {
    // This property is not accessed from b's implementation of `print`
    override val message = "Message of Derived"
}

fun myF(b: Base){
    b.print()
}

fun main() {
    val b = BaseImpl(10)
    val b2 = BaseImpl2(2)
    val derived = Derived(b)
    val derived2 = Derived(b2)
    derived.print()
    println(derived.message)
    derived2.print()
    println(derived2.message)

    myF(derived)
    myF(derived2)
}