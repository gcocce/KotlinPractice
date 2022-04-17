package patterns.delegate.producer

interface Producer1 {

    fun produce(): String
}

interface Producer2 {
    fun produce(): String
}

class ProducerImpl1 : Producer1 {

    override fun produce() = "Producer1Impl"
}

class ProducerImpl2 : Producer2 {

    override fun produce() = "Producer2Impl"
}

//to enhance an existing implementation.
class EnhancedProducer(private val delegate: Producer1) : Producer1 by delegate {
    override fun produce() = "${delegate.produce()} and EnhancedProducer"
}

//to implement several interfaces with implementations
class CompositeProducer(private val p1: Producer1, private val p2: Producer2) : Producer1 by ProducerImpl1(), Producer2 by ProducerImpl2(){
    override fun produce(): String {
        return p1.produce() + p2.produce()
    }
}


fun main(){
    val producer = EnhancedProducer(ProducerImpl1())

    println(producer.produce())
}