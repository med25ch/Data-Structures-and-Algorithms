import java.util.ArrayDeque


class MyQueue {

    private val inStack = ArrayDeque<Int>()
    private val outStack = ArrayDeque<Int>()

    fun push(x: Int) {
        inStack.push(x)
    }

    fun pop(): Int? {
        if (outStack.isEmpty()) {
            moveAllElements()
            return outStack.pop()
        }
        else{
            return outStack.pop()
        }
    }

    fun peek(): Int? {
        if (outStack.isEmpty()) {
            moveAllElements()
            return outStack.peek()
        }
        else{
            return outStack.peek()
        }
    }

    fun empty(): Boolean {
        return if (outStack.isEmpty()) {
            inStack.isEmpty()
        }else{
            outStack.isEmpty()
        }
    }

    private fun moveAllElements(){
        while (!inStack.isEmpty()) {
            val item = inStack.pop()
            outStack.push(item)
        }
    }

}