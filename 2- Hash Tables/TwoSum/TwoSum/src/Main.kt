fun main() {
    println("Hello getIndices")
    println(getIndices(arrayOf(5,2,7,10,3,9), 8))

    println("Hello finAllNumbers")
    println(finAllNumbers(arrayOf(5,4,6,3,2,9,10,8,15)))
}

/*
Given an array of integers nums and an integer target, return indices of two numbers such that they add up to target. You cannot use the same index twice.
 */


fun getIndices(array : Array<Int>,target : Int) : String{

    val map = hashMapOf<Int, Int>()

    for (i in array.indices){
        if (map.containsKey(target - array[i])){
            return "$i , ${map[target - array[i]]}"
        }
        map[array[i]] = i
    }

    return "No result"
}

/*

Given an integer array nums, find all the numbers x in nums that satisfy the following: x + 1 is not in nums, and x - 1 is not in nums.

If a valid number x appears multiple times, you only need to include it in the answer once.

 */

fun finAllNumbers(array : Array<Int>) : HashSet<Int> {

    val answers = hashSetOf<Int>()
    val hashSetOfArray = array.toHashSet()

    for (item in hashSetOfArray){
        if(!hashSetOfArray.contains(item + 1) && !hashSetOfArray.contains(item -1)){
            answers.add(item)
        }
    }

    return answers
}