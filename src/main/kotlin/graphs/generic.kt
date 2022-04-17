package graphs

//https://www.geeksforgeeks.org/kotlin-generics/

class MyClass<T>(text: T) {
    var name = text
}

fun main() {
    val my : MyClass<String> = MyClass<String>("GeeksforGeeks")

    val my2 = MyClass("GeeksforGeeks")

    val a=ArrayList<Int>()
    a.filter { it < 10 }

    fun repeat(str:String, times:Int){
        print("$str ")
        if (times>0){repeat(str, times -1)}
    }
    repeat( "Hola Mundo", 50)

    with("Abracadabra") {
        repeat(this,50)
    }
}

class generic<T>(input:T) {
    init {
        println("I am getting called with the value "+input)
    }
}


class genericsBinarySearch<T>(input:T) {
    init {
        println("I am getting called with the value "+input)
    }
}

/*
fun ArrayList.filterOnCondition(condition: (T) -> Boolean): ArrayList{
    val rst = arrayListOf()
    for (itm in this){
        if (condition(itm)){
            rst.add(itm)
        }
    }
    return rst
}
* */