import java.util.*

fun main() {
    println("BFS Algorithm in Kotlin!")

    val nodeE = Node("E")
    val nodeF = Node("F")

    val node1B1 = Node("1-B-1")
    val node1B2 = Node("1-B-1")

    val node1B = Node("1-B", listOf(node1B1,node1B2))
    val node2B = Node("2-B")


    val nodeB = Node("B", listOf(node1B,node2B))
    val nodeC = Node("C", listOf(nodeE, nodeF))
    val nodeD = Node("D")
    val root = Node("A", listOf(nodeB, nodeC, nodeD))

    println("BFS Traversal of Tree:")
    bfs(root)
}

fun bfs(root: Node) {

    val queue : Queue<Node> = LinkedList()
    queue.add(root)

    while (queue.isNotEmpty()){
        val current = queue.remove()
        println("We visited ${current.value}")

        for (child in current.children){
            queue.add(child)
        }
    }
}