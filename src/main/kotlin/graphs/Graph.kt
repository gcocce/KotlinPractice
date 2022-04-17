package graphs

import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.HashMap
import kotlin.collections.HashSet

/**
 * https://developerlife.com/2018/08/16/algorithms-in-kotlin-5/
 *
 * [More info](https://www.geeksforgeeks.org/graph-and-its-representations/).
 */
class Graph<T> {
    val adjacencyMap: HashMap<T, HashSet<T>> = HashMap()

    fun addEdge(sourceVertex: T, destinationVertex: T) {
        // Add edge to source vertex / node.
        adjacencyMap
            .computeIfAbsent(sourceVertex) { HashSet() }
            .add(destinationVertex)
        // Add edge to destination vertex / node.
        adjacencyMap
            .computeIfAbsent(destinationVertex) { HashSet() }
            .add(sourceVertex)
    }

    override fun toString(): String = StringBuffer().apply {
        for (key in adjacencyMap.keys) {
            append("$key -> ")
            append(adjacencyMap[key]?.joinToString(", ", "[", "]\n"))
        }
    }.toString()
}

/**
 * Depth first traversal leverages a [Stack] (LIFO).
 *
 * It's possible to use recursion instead of using this iterative
 * implementation using a [Stack].
 * Also, this algorithm is almost the same as [breadthFirstTraversal],
 * except that [Stack] (LIFO) is replaced w/ a [Queue] (FIFO).
 *
 * [More info](https://stackoverflow.com/a/35031174/2085356).
 */
fun <T> depthFirstTraversal(graph: Graph<T>, startNode: T): String {

    // Mark all the vertices / nodes as not visited.
    val visitedMap = mutableMapOf<T, Boolean>().apply {
        graph.adjacencyMap.keys.forEach { node -> put(node, false) }
    }

    // Create a stack for DFS. Both ArrayDeque and LinkedList implement Deque.
    //val stack: Deque<T> = ArrayDeque()
    val stack: ArrayDeque<T> = ArrayDeque<T>()

    // Initial step -> add the startNode to the stack.
    //stack.push(startNode)
    stack.addLast(startNode)

    // Store the sequence in which nodes are visited, for return value.
    val traversalList = mutableListOf<T>()

    // Traverse the graph.
    while (stack.isNotEmpty()) {
        // Pop the node off the top of the stack.
        val currentNode = stack.removeLast()

        if (!visitedMap[currentNode]!!) {

            // Store this for the result.
            traversalList.add(currentNode)

            // Mark the current node visited and add to the traversal list.
            visitedMap[currentNode] = true

            // Add nodes in the adjacency map.
            graph.adjacencyMap[currentNode]?.forEach { node ->
                stack.addLast(node)
            }

        }

    }

    return traversalList.joinToString()
}

/**
 * Breadth first traversal leverages a [Queue] (FIFO).
 */
fun <T> breadthFirstTraversal(graph: Graph<T>,
                              startNode: T,
                              maxDepth: Int = Int.MAX_VALUE): String {
    //
    // Setup.
    //

    // Mark all the vertices / nodes as not visited. And keep track of sequence
    // in which nodes are visited, for return value.
    class VisitedMap {
        val traversalList = mutableListOf<T>()

        val visitedMap = mutableMapOf<T, Boolean>().apply {
            for (node in graph.adjacencyMap.keys) this[node] = false
        }

        fun isNotVisited(node: T): Boolean = !visitedMap[node]!!

        fun markVisitedAndAddToTraversalList(node: T) {
            visitedMap[node] = true
            traversalList.add(node)
        }
    }

    val visitedMap = VisitedMap()

    // Keep track of the depth of each node, so that more than maxDepth nodes
    // aren't visited.
    val depthMap = mutableMapOf<T, Int>().apply {
        for (node in graph.adjacencyMap.keys) this[node] = Int.MAX_VALUE
    }

    // Create a queue for BFS.
    class Queue {
        //val deck: Deque<T> = ArrayDeque<T>()
        val deck: ArrayDeque<T> = ArrayDeque<T>()
        fun add(node: T, depth: Int) {
            // Add to the tail of the queue.
            deck.add(node)
            // Record the depth of this node.
            depthMap[node] = depth
        }

        fun addAdjacentNodes(currentNode: T, depth: Int) {
            for (node in graph.adjacencyMap[currentNode]!!) {
                add(node, depth)
            }
        }

        fun isNotEmpty() = deck.isNotEmpty()
        //fun remove() = deck.remove()
        fun remove() = deck.removeFirst()
    }

    val queue = Queue()

    //
    // Algorithm implementation.
    //

    // Initial step -> add the startNode to the queue.
    queue.add(startNode, /* depth= */0)

    // Traverse the graph
    while (queue.isNotEmpty()) {
        // Remove the item at the head of the queue.
        val currentNode = queue.remove()
        val currentDepth = depthMap[currentNode]!!

        if (currentDepth <= maxDepth) {
            if (visitedMap.isNotVisited(currentNode)) {
                // Mark the current node visited and add to traversal list.
                visitedMap.markVisitedAndAddToTraversalList(currentNode)
                // Add nodes in the adjacency map.
                queue.addAdjacentNodes(currentNode, /* depth= */currentDepth + 1)
            }
        }

    }

    return visitedMap.traversalList.toString()
}

