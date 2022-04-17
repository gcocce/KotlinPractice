package graphs

import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/*

recursive implementation

procedure DFS(G, v) is
    label v as discovered
    for all directed edges from v to w that are in G.adjacentEdges(v) do
        if vertex w is not labeled as discovered then
            recursively call DFS(G, w)

iterative implementation

procedure DFS_iterative(G, v) is
    let S be a stack
    S.push(v)
    while S is not empty do
        v = S.pop()
        if v is not labeled as discovered then
            label v as discovered
            for all edges from v to w in G.adjacentEdges(v) do
                S.push(w)
*/

fun main() {

    println("DFS")

    //val g: ArrayList<Array<Int>> = ArrayList<Array<Int>>(0)
    var processed = 0
    val m: MutableMap<Int, Array<Int>> = mutableMapOf()

    println("how many nodes?")
    val nodes = readLine()!!.trim().toInt()

    while (processed<nodes) {
        println("node name?")
        val node = readLine()!!.trim().toInt()
        println("neighbors?")
        m[node]=readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
        processed+=1
    }

    for(node in m){
        println(node.key)
        for (each in node.value) print("$each ")
        println()
    }

}

