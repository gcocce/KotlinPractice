package graphs

fun main(){

    val graph:Graph<Int> = Graph()

    graph.addEdge(1,2)
    graph.addEdge(1,3)
    graph.addEdge(1,4)
    graph.addEdge(4,5)
    graph.addEdge(5,1)

    print(graph)

    println(depthFirstTraversal(graph, 1))


    println(breadthFirstTraversal(graph, 1))

}