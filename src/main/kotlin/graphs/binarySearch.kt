package graphs

fun myBinarySearch(V: Int, arr: Array<Int>): Int? {
    // Lets try a basic binary search
    var start = 0
    var end = arr.size-1

    while(end >= start){
        val mid :Int = (end - start) / 2 + start
        println("start $start end $end mid $mid")
        val value = arr[mid]
        if (value == V) return mid
        if (value>V){
            end = mid - 1
        }else{
            start = mid + 1
        }
    }

    return null
}

fun main() {
    val list = mutableListOf('b', 'a', 'c', 'd', 'e')
    //list.sort()
    println(list.binarySearch('a')) // -1
    list.sort()
    println(list.binarySearch('a')) // 0

    // The list is expected to be sorted in ascending order
    println(list.binarySearch('d')) // 3

    list.remove('d')

    val invertedInsertionPoint = list.binarySearch('d')
    val actualInsertionPoint = -(invertedInsertionPoint + 1)
    println(actualInsertionPoint) // 3

    list.add(actualInsertionPoint, 'd')
    println(list) // [a, b, c, d, e]
}