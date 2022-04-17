package coroutines


import kotlinx.coroutines.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

//A launch coroutine builder returns a Job object that is a handle to the launched coroutine and can be used
// to explicitly wait for its completion.
fun main(){
    runBlocking {
    val job = launch { // launch a new coroutine and keep a reference to its Job
        delay(1000L)
        println("World!")
    }
    println("Hello")
    job.join() // wait until child coroutine completes
    println("Done")
    }
}