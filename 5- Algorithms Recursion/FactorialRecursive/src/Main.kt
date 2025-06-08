fun main() {

    val iterativeResult = findFactorialIterative(5)
    println("The iterative result of $iterativeResult")

    val recursiveResult = findFactorialRecursive(5)
    println("The iterative result of $recursiveResult")

}

// Write two functions that finds the factorial of any number. One should use recursive, the other should just use a for loop

fun findFactorialRecursive(number : Int) : Int{
    //code here
    return if (number <= 1) {
        1
    } else {
        number * findFactorialRecursive(number - 1)
    }
}

fun findFactorialIterative(number : Int) : Int{
    //code here
    var result = 1
    for (i in 1..number){
        result *= i
    }

    return result
}