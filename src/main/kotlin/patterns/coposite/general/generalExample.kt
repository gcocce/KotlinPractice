package patterns.coposite.general

fun main(){

    val container= Composite("1")

    container.add(Leaf("1"))
    container.add(Leaf("2"))
    container.add(Leaf("3"))

    val container2 = Composite("2")
    container2.add(Leaf("4"))
    container2.add(Leaf("5"))
    container2.add(Leaf("6"))
    container2.add(Leaf("7"))

    container.add(container2)

    container.print()
    println(container.size)
}