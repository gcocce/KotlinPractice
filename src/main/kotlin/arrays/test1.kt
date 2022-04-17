package arrays

fun main() {

    val a = Array<Char>(10) { _ -> 'x'}

    a[2] = 's'      // can be modified
    println("a.joinToString()")
    println(a.joinToString() )
    println("a.joinToString(\"\")")
    println(a.joinToString("") )

    println("a.forEach {print(it)}")
    a.forEach { print(it) }
    println()

    val result: String = String(a.toCharArray());

    println(result)

    val b = Array<Int>(10) { i -> i}

    println(b.toIntArray().joinToString())
    println(b.toIntArray().joinToString(""))

    for (e in b){
        print(e)
    }; println()

/*
Kotlin also has classes that represent arrays of primitive types without boxing overhead:
ByteArray, ShortArray, IntArray, and so on. These classes have no inheritance relation
to the Array class, but they have the same set of methods and properties. */

    val x: IntArray = intArrayOf(1, 2, 3)
    x[0] = x[1] + x[2]

    // Array of int of size 5 with values [0, 0, 0, 0, 0]
    val arrI1 = IntArray(5)

    // e.g. initialise the values in the array with a constant
    // Array of int of size 5 with values [42, 42, 42, 42, 42]
    val arrI2 = IntArray(5) { 42 }

    // e.g. initialise the values in the array using a lambda
    // Array of int of size 5 with values [0, 1, 2, 3, 4] (values initialised to their index value)
    var arrI3 = IntArray(5) { it * 1 }


    val asc = Array(5) { i -> (i * i).toString() }
    asc.forEach { println(it) }


/*
    crossword[0] = "+-++++++++"
    crossword[1] = "+-++++++++"
    crossword[2] = "+-++++++++"
    crossword[3] = "+-----++++"
    crossword[4] = "+-+++-++++"
    crossword[5] = "+-+++-++++"
    crossword[6] = "+++++-++++"
    crossword[7] = "++------++"
    crossword[8] = "+++++-++++"
    crossword[9] = "+++++-++++"

 */
    //val crossword = Array<String>(10, { "" })
    //val crossword = ArrayList<Array<Char>>()

    val crossword = Array<Array<Char>>(10) { Array<Char>(10) {' '}}

    crossword[0] = "+-++++++++".toCharArray().toTypedArray()
    crossword[1] = "+-++++++++".toCharArray().toTypedArray()
    crossword[2] = "+-++++++++".toCharArray().toTypedArray()
    crossword[3] = "+-----++++".toCharArray().toTypedArray()
    crossword[4] = "+-+++-++++".toCharArray().toTypedArray()
    crossword[5] = "+-+++-++++".toCharArray().toTypedArray()
    crossword[6] = "+++++-++++".toCharArray().toTypedArray()
    crossword[7] = "++------++".toCharArray().toTypedArray()
    crossword[8] = "+++++-++++".toCharArray().toTypedArray()
    crossword[9] = "+++++-++++".toCharArray().toTypedArray()

    for (i in 0..9){
        for (j in 0..9){
            print(crossword[i][j])
        }
        println()
    }

}