package coroutines

import kotlinx.coroutines.*

/**** A coroutine is an instance of suspendable computation. ****/

fun main() = runBlocking { // this: CoroutineScope
    launch { // launch a new coroutine and continue
        delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
        println("World!") // print after delay
    }

    val r = async {
        delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
        println("Helooo oh ou ") // print after delay
        9
    }
    println(r.await())
    println("Hello") // main coroutine continues while a previous one is delayed
}