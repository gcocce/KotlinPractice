package patterns.coposite.general

class Leaf(private val name:String) : Component{

    override fun operation() {}

    override fun print() {
        println("I am leaf $name")
    }
}