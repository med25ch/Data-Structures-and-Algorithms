fun main() {
    println("Hello World!")

    val myQueue = MyQueue() // Queue is FIFO

    myQueue.push(1)
    myQueue.push(2)


    myQueue.peek()?.let { println(it) } // 1
    myQueue.pop()?.let { println(it) } // return 1
    myQueue.peek()?.let { println(it) } // 2
    myQueue.pop()?.let { println(it) } // return 2


    println(myQueue.empty()) // false
    


}