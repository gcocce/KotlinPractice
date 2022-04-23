package generic.invariant

open class Weapon
open class Rifle : Weapon()
class SniperRifle : Rifle()

class Case<T> {
    private val contents = mutableListOf<T>()
    fun produce(): T = contents.last()         // Producer: OK
    fun consume(item: T) = contents.add(item)  // Consumer: OK
}

fun useProducerConsumer(case: Case<Rifle>) {
    // Produces Rifle and its subtypes
    case.produce()
    // Consumes Rifle and its subtypes
    case.consume(SniperRifle())
}

fun main(){
    //useProducerConsumer(Case<SniperRifle>())       // Error
    useProducerConsumer(Case<Rifle>())             // OK
    //useProducerConsumer(Case<Weapon>())            // Error
}