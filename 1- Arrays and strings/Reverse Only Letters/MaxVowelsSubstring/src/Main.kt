import kotlin.math.max

fun main() {
    println("Hello maxVowels!")
    println(maxVowels("abciiidef",3))
}

/*
Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

Example 1:

Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.
Example 2:

Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.
Example 3:

Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.


Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
1 <= k <= s.length

 */

fun maxVowels(s: String, k: Int): Int {

    var current = 0
    var answer = 0

    for (right in s.indices){

        if(isVowel(s[right])) {
            current ++
        }

        if(right >= k && isVowel(s[right-k])) {
            current --
        }

        answer = maxOf(answer, current)

    }

    return answer
}

fun isVowel(c: Char): Boolean {
    return c.lowercaseChar() in listOf('a', 'e', 'i', 'o', 'u')
}