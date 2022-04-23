package generic.preservesSubtyping

//out produces T and preserves subtyping

open class Weapon
open class Rifle : Weapon()
class SniperRifle : Rifle()

class Case<out T> {
    private val contents = mutableListOf<T>()
    fun produce(): T? = contents.lastOrNull()        // Producer: OK
    //fun consume(item: T) = contents.add(item)  // Consumer: Error
}

fun useProducer(case: Case<Rifle>) {
    // Produces Rifle and its subtypes
    val rifle = case.produce()
}

fun main(){
    useProducer(Case<SniperRifle>())               // OK
    useProducer(Case<Rifle>())                     // OK
    //useProducer(Case<Weapon>())                    // Error
}