class Node(var value : Int) {
    var left : Node? = null
    var right : Node? = null
}

class CustomBinarySearchTree {

    private var rootNode : Node? = null

    fun insert(value: Int) {
        rootNode =  insertValue(this.rootNode, value)
    }

    private fun hasChilds(): Boolean {
        return this.rootNode != null && this.rootNode!!.right != null && this.rootNode!!.left != null
    }

    fun lookUp(value: Int) : Boolean{
        return recursiveSearch(rootNode!!, value)
    }

    private fun recursiveSearch(node: Node?, value: Int): Boolean {
        if (node == null) return false
        if (value == node.value) return true
        return if (value < node.value) recursiveSearch(node.left, value) else recursiveSearch(node.right, value)
    }

    private fun insertValue(node: Node?, value: Int) : Node {
        if (node == null) return Node(value)

        if (value < node.value) {
            node.left = insertValue(node.left, value)
        } else if (value > node.value) {
            node.right = insertValue(node.right, value)
        }
        return node
    }

    fun remove(value: Int) {
        rootNode = recursiveRemove(this.rootNode,value)
    }

    private fun recursiveRemove(node: Node?,value: Int) : Node?{
        if (node == null) return null

        when {
            value < node.value -> node.left = recursiveRemove(node.left, value)
            value > node.value -> node.right = recursiveRemove(node.right, value)
            else -> {
                // Case 1: No children
                if (node.left == null && node.right == null) return null

                // Case 2: One child
                if (node.left == null) return node.right
                if (node.right == null) return node.left

                // Case 3: Two children
                val minValue = findMinValue(node.right!!)
                node.value = minValue
                node.right = recursiveRemove(node.right, minValue)
            }
        }

        return node
    }

    private fun findMinValue(node: Node): Int {
        var current = node
        while (current.left != null) {
            current = current.left!!
        }
        return current.value
    }

}