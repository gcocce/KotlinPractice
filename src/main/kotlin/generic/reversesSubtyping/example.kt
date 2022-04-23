package generic.reversesSubtyping

open class Weapon
open class Rifle : Weapon()
class SniperRifle : Rifle()


class Case<in T> {
    private val contents = mutableListOf<T>()
    //fun produce(): T = contents.last()         // Producer: Error
    fun consume(item: T) = contents.add(item)  // Consumer: OK
}

fun useConsumer(case: Case<Rifle>) {
    // Consumes Rifle and its subtypes
    case.consume(SniperRifle())
}

fun main(){
    //useConsumer(Case<SniperRifle>())               // Error
    useConsumer(Case<Rifle>())                     // OK
    useConsumer(Case<Weapon>())                    // OK
}
