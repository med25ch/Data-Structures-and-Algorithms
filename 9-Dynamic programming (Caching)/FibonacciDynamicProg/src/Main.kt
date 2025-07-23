fun main() {

    println("Fibonacci without dynamic programming (caching)")
    println("result : ${fibonacci(15)}")
    println("number of calculation without caching : $calculation")
    println()
    println("===============================")
    println()
    println()
    println("Fibonacci with dynamic programming (caching)")
    println("result : ${fibonacciCached(15)}")
    println("number of calculation without caching : $cachedCalculation")

}


/* The Fibonacci sequence is a series of numbers where each number
   is the sum of the two preceding ones. It starts like this:

0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ...

F(n) = F(n - 1) + F(n - 2)

F(0) = 0
F(1) = 1

*/

var calculation = 0
var cachedCalculation = 0
val cachedResults : MutableMap<Int,Int> = mutableMapOf()

fun fibonacci(number : Int) : Int{
    calculation++

    if(number <= 1){
        return number
    }

    val result = fibonacci(number-1) + fibonacci(number-2)

    return result

}

fun fibonacciCached(number : Int) : Int{

    if (cachedResults.containsKey(number)){
        return cachedResults[number]!!
    }

    cachedCalculation++

    //case of 1 or 0
    if(number <= 1){
        cachedResults[number] = number
        return number
    }

    //other cases
    val result = fibonacciCached(number-1) + fibonacciCached(number-2)
    cachedResults[number] = result

    return result

}