package graphs

import com.sun.jmx.remote.internal.ArrayQueue
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
procedure BFS(G, root) is
2      let Q be a queue
3      label root as explored
4      Q.enqueue(root)
5      while Q is not empty do
6          v := Q.dequeue()
7          if v is the goal then
8              return v
9          for all edges from v to w in G.adjacentEdges(v) do
10              if w is not labeled as explored then
11                  label w as explored
12                  Q.enqueue(w)
*/

class Node(var e:Int){
    override fun equals(other: Any?): Boolean {
        val o= other as Node
        if (e==o.e) return true
        return false
    }

    override fun hashCode(): Int {
        return e
    }
}

class Edge(){}

// Adjacency list, root and goal
fun BFS(A: Map<Node, ArrayList<Node>>, root:Node, goal:Node): Node?{
    val q: Queue<Node> = LinkedList<Node>()     // add() at tail    remove() or poll() first element
    val explored = ArrayList<Node>()

    println("root ${root.e} goal ${goal.e}")

    //1
    explored.add(root)
    q.add(root)

    //2
    while (q.isNotEmpty()){
        val v = q.poll()
        println("v ${v.e}")
        //3
        // Nodes in keys have different references than nodes in values
        if (v==goal) return v      // === compares reference     == compares object data (equals(other: Any?))
        val edges = A.get(v)
        if (edges!=null){
            //4
            for (n in edges){
                //5
                println("process edge ${n.e}")
                if (n !in explored){
                    println("mark explored edge ${n.e}")
                    explored.add(n)
                    q.add(n)
                }
            }
        }
    }

    return null
}

fun main() {

    println("BFS")

    //val g: ArrayList<Array<Int>> = ArrayList<Array<Int>>(0)
    var processed = 0
    //val m: MutableMap<Int, Array<Int>> = mutableMapOf()

    val m : MutableMap<Node, ArrayList<Node>> = mutableMapOf()

    println("how many nodes?")
    val nodes = readLine()!!.trim().toInt()

    while (processed<nodes) {
        println("node name?")
        val node = Node(readLine()!!.trim().toInt())

        println("neighbors?")
        val edges = ArrayList<Node>()
        val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
        for (a in arr){
            edges.add(Node(a))
        }
        m[node]=edges
        processed+=1
    }

    for(node in m){
        print("${node.key.e} -> ")
        for (each in node.value) print("${each.e} ")
        println()
    }

    println("root?")
    val rootValue = readLine()!!.trim().toInt()

    println("dest?")
    val destValue = readLine()!!.trim().toInt()

    var nodeRoot:Node?=null
    var nodeDest:Node?=null
    val nodesK = m.keys
    for (node in nodesK){
        if (node.e==rootValue){
            nodeRoot=node
        }
        if (node.e==destValue){
            nodeDest=node
        }
    }

    if (nodeRoot!=null && nodeDest!=null){
        val res = BFS(m,nodeRoot, nodeDest)
        if (res!=null){
            println(res.e)
        }else{
            println("path not found")
        }
    }else{
        println("root or destination doesn't exist")
    }
}

