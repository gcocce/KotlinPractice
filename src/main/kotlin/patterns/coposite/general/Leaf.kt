package patterns.coposite.general

class Leaf(private val name:String) : Component{

    override val size: Int
        get() = 1

    override fun operation() {}

    override fun print() {
        println("I am leaf $name")
    }
}