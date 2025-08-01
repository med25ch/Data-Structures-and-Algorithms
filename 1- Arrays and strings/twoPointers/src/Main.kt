fun main() {
    println("Hello isPalindrome !")
    println(isPalindrome("abcdcba"))

    println("Hello isSumOfTwoNumbersEqualsTarget !")
    println(isSumOfTwoNumbersEqualsTarget(arrayOf(1, 2, 4, 6, 8, 9, 14, 15),13))

    println("Hello twoCombinedArrays !")
    val combinedArray = twoCombinedArrays(arrayOf(1, 2, 4, 6, 8, 9, 14, 15),arrayOf(1, 2, 4, 6, 8, 9, 14, 15))
    println(combinedArray.asList())

    println("Hello reverseString !")
    reverseString(charArrayOf('h','e','l','l','o'))
    reverseString(charArrayOf('u','k','c','u','f'))

    println("Hello finLongestSubarray !")
    println(finLongestSubarray(arrayOf(3, 1, 2, 7, 4, 2, 1, 1, 5),8))

    println("Hello longestSubstring !")
    println(longestSubstring("1101100111"))


    println("Hello findMaxAverage !")
    println(findMaxAverage(intArrayOf(5),1))

}


/*
Given a string s, return true if it is a palindrome, false otherwise.

A string is a palindrome if it reads the same forward as backward.

That means, after reversing it, it is still the same string.

For example: "abcdcba", or "racecar".
 */

fun isPalindrome(str : String) : Boolean {
    var leftPointer = 0
    var rightPointer = str.length - 1

    while (leftPointer < rightPointer) {

        if(str[leftPointer] != str[rightPointer]){
            return false
        }

        leftPointer++
        rightPointer--
    }

    return true
}

/*
Given a sorted array of unique integers and a target integer,

return true if there exists a pair of numbers that sum to target, false otherwise.

For example, given nums = [1, 2, 4, 6, 8, 9, 14, 15] and target = 13, return true because 4 + 9 = 13.
 */


fun isSumOfTwoNumbersEqualsTarget(nums : Array<Int>,target : Int) : Boolean {

    var leftPointer = 0
    var rightPointer = nums.size - 1

    while (leftPointer < rightPointer){

        if (nums[leftPointer] + nums[rightPointer] == target)
        {
            return true
        }

        if (nums[leftPointer] + nums[rightPointer] < target)
        {
            leftPointer ++
        }
        else
        {
            rightPointer--
        }
    }

    return false

}

/*

Given two sorted integer arrays arr1 and arr2,

return a new array that combines both of them and is also sorted.

 */

fun twoCombinedArrays(array1 : Array<Int>, array2 : Array<Int>) : IntArray {

    var pointer1 = 0
    var pointer2 = 0
    val sortedCombinedArray = arrayListOf<Int>()

    while (pointer1 < array1.size && pointer2 < array2.size){

        val v1 = array1[pointer1]
        val v2 = array2[pointer2]

        if (v1<v2)
        {
            sortedCombinedArray.add(v1)
            pointer1++
        }
        else
        {
            sortedCombinedArray.add(v2)
            pointer2++
        }
    }

    while (pointer1 < array1.size){
        sortedCombinedArray.add(array1[pointer1])
        pointer1++
    }

    while (pointer2 < array2.size){
        sortedCombinedArray.add(array2[pointer2])
        pointer2++
    }

    return sortedCombinedArray.toIntArray()
}














