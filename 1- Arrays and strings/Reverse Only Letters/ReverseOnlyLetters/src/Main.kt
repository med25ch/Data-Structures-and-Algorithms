import kotlin.text.StringBuilder

fun main() {
    println("Hello reverseOnlyLetters!")
    println(reverseOnlyLetters("a-bC-dEf-ghIj"))
}


/*

Given a string s, reverse the string according to the following rules:

All the characters that are not English letters remain in the same position.
All the English letters (lowercase or uppercase) should be reversed.
Return s after reversing it.


Example 1:

Input: s = "ab-cd"
Output: "dc-ba"
Example 2:

Input: s = "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"
Example 3:

Input: s = "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"


Constraints:

1 <= s.length <= 100
s consists of characters with ASCII values in the range [33, 122].
s does not contain '\"' or '\\'.

 */


fun reverseOnlyLetters(s: String): String {

    val stringBuilder = StringBuilder(s)
    var left = 0
    var right = s.length - 1


    while (left < right) {

        if( stringBuilder[right]  in 'A'..'Z' ||  stringBuilder[right] in 'a'..'z' ){
            if( stringBuilder[left]  in 'A'..'Z' ||  stringBuilder[left] in 'a'..'z') {
                val temp = stringBuilder[right]
                stringBuilder.setCharAt(right,stringBuilder[left])
                stringBuilder.setCharAt(left,temp)
                right --
                left ++
            }
            else {
                left++
            }
        }
        else if(stringBuilder[left]  in 'A'..'Z' ||  stringBuilder[left] in 'a'..'z')
        {
            right --
        }else {
            right --
            left ++
        }

    }

    return stringBuilder.toString()
}