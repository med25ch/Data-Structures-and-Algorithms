package org.example

fun main() {
}

/*
Implement a function which finds four numbers within the provided list which have a sum equal to the target.

An example is provided, but is too slow on larger testcases because it has too many nested loops.
    •There will always be at least one valid quadruplet.
    •The same number can be used any number of times.
    •Numbers can be returned in any order.
 */


fun fourSum(target : Int, nums : List<Int>) : List<Int> {

    val pairSum = mutableMapOf<Int,Pair<Int,Int>>()

    // sum of all pairs in the list
    for (i in nums.indices){
        for (j in nums.indices){
            val sum = nums[i] + nums[j]
            pairSum[sum] = Pair(nums[i],nums[j])
        }
    }

    //Check if we have a pair that meet target
    for ((sum,pair) in pairSum){
        val complement = target - sum
        if(pairSum.containsKey(complement)){
            val found = pairSum[complement]!!
            return listOf(pair.first,pair.second,found.first,found.second)
        }
    }

    return emptyList()
}