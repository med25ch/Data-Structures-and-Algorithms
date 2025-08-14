package org.example

/*
https://leetcode.com/problems/simplify-path/description/

 */


fun simplifyPath(path: String): String {

    val stack = ArrayDeque<String>()
    val splitPath = arrayListOf<String>()

    path.split("/")
        .filter { it.isNotEmpty() }
        .forEach { splitPath.add(it) }

    for (item in splitPath) {
        when (item) {
            "", "." -> continue
            ".." -> if (stack.isNotEmpty()) stack.removeLast()
            else -> stack.addLast(item)
        }
    }

    return "/" + stack.joinToString("/")

}