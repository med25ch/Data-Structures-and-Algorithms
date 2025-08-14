import kotlin.math.max

fun main() {
    println("Hello lengthOfLongestSubstring!")
    println(lengthOfLongestSubstring("abcbde"))


}


/*
Given a string s, find the length of the longest substring without duplicate characters.


Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

 */

fun lengthOfLongestSubstring(s: String): Int {

    val hashMap = hashSetOf<Char>()
    var left = 0
    var answer = 0

    for (right in s.indices) {

        while (hashMap.contains(s[right])){
            hashMap.remove(s[left])
            left++
        }

        hashMap.add(s[right])
        answer = max(answer, right - left + 1)

    }

    return answer
}