fun main() {
    println("Hello Stack implementation!")

    val stack = MyCustomStack<Int>()
    stack.push(1)
    stack.push(2)
    stack.push(3)
    stack.push(4)

    stack.pop()
    stack.pop()
    stack.pop()
    stack.pop()
    stack.pop()

    val peek = stack.peek()

    println("$peek")

}