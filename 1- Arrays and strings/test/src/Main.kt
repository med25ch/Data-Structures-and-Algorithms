fun main() {
    println("Hello intersection!")
    val array = arrayOf(
        intArrayOf(7, 3, 1, 2, 4, 5),
        intArrayOf(7, 1, 2, 3, 4),
        intArrayOf(7, 3, 4, 5, 6)
    )
    println(intersection(array))
}

/*
Given a 2D array nums that contains n arrays of distinct integers, return a sorted array containing all the numbers that appear in all n arrays.

For example, given nums = [[3,1,2,4,5],[1,2,3,4],[3,4,5,6]], return [3, 4]. 3 and 4 are the only numbers that are in all arrays.
 */

fun intersection (twoDArray: Array<IntArray>) : IntArray {

    val hashMap = hashMapOf<Int,Int>()
    val result = mutableListOf<Int>()

    for (array in twoDArray){
        for (item in array) {
            if (hashMap.containsKey(item)){
                hashMap[item] = hashMap.getOrDefault(item,0) + 1
            }
            else
            {
                hashMap[item] = 1
            }
        }
    }

    for (item in hashMap){
        if (item.value == twoDArray.size){
            result.add(item.key)
        }
    }

    //order the result
    //result.sort()

    return result.toIntArray()

}
