import kotlin.math.max

/*

Given an array of positive integers nums and an integer k,

find the length of the longest subarray whose sum is less than or equal to k.

 */

fun finLongestSubarray(array: Array<Int>, k: Int) : Int {

    var left = 0
    var curr = 0
    var longestLength = 0

    for (right in array.indices) {

        curr += array[right]

        while (curr > k) {
            curr -= array[left]
            left++
        }

        longestLength = max(longestLength, right - left + 1)
    }

    return longestLength
}


/*

You are given a binary string s (a string containing only "0" and "1").

You may choose up to one "0" and flip it to a "1". What is the length of the longest substring achievable that contains only "1"?

For example, given s = "1101100111", the answer is 5. If you perform the flip at index 2, the string becomes 1111100111.

 */

fun longestSubstring(s : String) : Int {
    var left = 0
    var curr = 0
    var answer = 0

    for (right in s.indices){

        if (s[right] == '0'){
            curr ++
        }

        while (curr > 1) {
            if (s[left] == '0'){
                curr--
            }

            left++
        }

        answer = max(answer, right-left+1)
    }

    return  answer
}


/*
You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.

Any answer with a calculation error less than 10-5 will be accepted.

Constraints:

n == nums.length
1 <= k <= n <= 105
-104 <= nums[i] <= 104

 */

fun findMaxAverage(nums: IntArray, k: Int): Double {

    var curr = 0.0
    var answer: Double
    // Sum all the first sub of k

    for (i in 0..<k){
        curr += nums[i]
    }

    answer = curr

    // Slide the window through the array
    for (i in k..<nums.size) {
        curr += nums[i] - nums[i - k]  // Add new element, remove old one
        answer = maxOf(answer, curr)
    }

    return answer/k
}













