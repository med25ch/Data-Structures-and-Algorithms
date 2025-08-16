package org.example

/*

https://leetcode.com/problems/valid-parentheses/description/

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',

determine if the input string is valid.

The string is valid if all open brackets are closed by the same type of closing bracket in the correct order, and each closing bracket closes exactly one open bracket.

For example, s = "({})" and s = "(){}[]" are valid, but s = "(]" and s = "({)}" are not valid.
 */


fun isInputValid(input : String) : Boolean {

    val stack = ArrayDeque<Char>()

    val openAndClosed = hashMapOf(
        '(' to ')',
        '[' to ']',
        '{' to '}'
    )

    for (char in input) {
        if (char in openAndClosed.keys) {
            stack.addLast(char)
        } else if (stack.isNotEmpty() && openAndClosed[stack.last()] == char) {
            stack.removeLast()
        } else {
            return false
        }
    }

    return stack.isEmpty()
}

