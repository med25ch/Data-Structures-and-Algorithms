import java.time.temporal.IsoFields

fun main() {
    println("Hello Fibonacci!")
    val answer = fibonacciRecursive(12)
    println("Answer: $answer")

}


// Given a number N return the index value of the Fibonacci sequence, where the sequence is:

// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144 ...
// the pattern of the sequence is that each value is the sum of the 2 previous values, that means that for N=5 → 2+3

//For example: fibonacciRecursive(6) should return 8

fun fibonacciRecursive(number : Int) : Int{

    return when (number) {
        0 -> 0
        1 -> 1
        else -> fibonacciRecursive(number - 1) + fibonacciRecursive(number - 2)
    }

}
