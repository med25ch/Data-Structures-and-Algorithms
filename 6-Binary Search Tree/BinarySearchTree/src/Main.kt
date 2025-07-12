

fun main() {
    println("Hello Binary Search Tree")

    val bsr = CustomBinarySearchTree()

    bsr.insert(20)
    bsr.insert(50)
    bsr.insert(18)
    println(bsr)
    println(bsr.lookUp(200))
}