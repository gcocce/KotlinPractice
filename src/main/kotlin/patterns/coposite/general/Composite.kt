package patterns.coposite.general

class Composite(private val name:String): Component {

    var componentList:MutableList<Component> = mutableListOf()

    override val size: Int
        get() = componentList.map { it.size }.sum() + 1

    override fun operation() {

    }

    override fun print() {
        println("I am Composite $name")
        componentList.forEach { it.print() }
    }

    fun add(component: Component) = componentList.add(component)
    fun remove(component: Component) = componentList.remove(component)
    fun getChild(){}

}