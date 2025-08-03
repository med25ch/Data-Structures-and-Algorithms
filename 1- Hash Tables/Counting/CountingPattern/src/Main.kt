fun main() {
    println("Hello findLongestSubstring!")
    println(findLongestSubstring("eceba", 2))

    println("Hello intersection!")
    val array = arrayOf(
        intArrayOf(7, 3, 1, 2, 4, 5),
        intArrayOf(7, 1, 2, 3, 4),
        intArrayOf(7, 3, 4, 5, 6)
    )
    println(intersection(array))

    // noticed its sorted without sorting :

    // explanation from ChatGbt


    /*
    You're seeing the result already sorted (like [3, 4, 7]) even though you didn’t call result.sort() — and that’s surprising since you expected the result in the order [7, 3, 4]. Here's what's happening:

🔍 Why is the result sorted?

   You're using a HashMap and then doing:

    for (item in hashMap) {
        if (item.value == twoDArray.size) {
            result.add(item.key)
        }
    }

    But iteration order in HashMap is not guaranteed, and in practice, especially in recent JVM versions, the iteration of keys in a HashMap often appears in increasing order of integers — but that’s not reliable or by design.

    So, the appearance of sorting is incidental and can vary between JVM versions or platforms.

     */
}

/*
You are given a string s and an integer k.

Find the length of the longest substring that contains at most k distinct characters.

For example, given s = "eceba" and k = 2, return 3. The longest substring with at most 2 distinct characters is "ece"
 */


fun findLongestSubstring(s : String, k : Int) : Int{

    val tracker = hashMapOf<Char, Int>()
    var left = 0
    var answer = 0

    for (right in s.indices){

        val char = s[right]
        tracker[char] = tracker.getOrDefault(char,0) +1

        while(tracker.count() > k) {
            val toRemove = s[left]
            tracker[toRemove] = tracker.getOrDefault(toRemove,0)-1

            if(tracker[toRemove] == 0) {
                tracker.remove(toRemove)
            }

            left++
        }

        answer = maxOf(answer , right - left +1)

    }

    return answer

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