package org.example

import java.util.*

fun main() {

    val letterPoints = hashMapOf(
        'e' to 1, 'a' to 1, 'i' to 1, 'o' to 1, 'n' to 1, 'r' to 1, 't' to 1, 'l' to 1, 's' to 1, 'u' to 1,
        'd' to 2, 'g' to 2,
        'b' to 3, 'c' to 3, 'm' to 3, 'p' to 3,
        'f' to 4, 'h' to 4, 'v' to 4, 'w' to 4, 'y' to 4,
        'k' to 5,
        'j' to 8, 'x' to 8,
        'q' to 10, 'z' to 10
    )

//    val words = mutableListOf<String>()
//
//    val input = Scanner(System.`in`)
//
//    val n = input.nextInt()
//
//    if (input.hasNextLine()) {
//        input.nextLine()
//    }
//
//    for (i in 0 until n) {
//        val word = input.nextLine()
//        words.add(word)
//    }

    //val letters = input.nextLine()

    // Only for testing :

    val words = listOf(
        "because",
        "first",
        "these",
        "could",
        "which"
    )

    val letters = "hicquwh"

    val winningWord = getWordScoringMostPoints(letterPoints, words, letters)
    println(winningWord)

}

fun getWordScoringMostPoints(letterPoints: HashMap<Char, Int>, words: List<String>, letters: String): String {

    val matchingWords = mutableListOf<String>()
    val matchingWordsWithScores = linkedMapOf<String, Int>()

    // should find a way to count each char in letters
    // count each char in word
    // compare

    for (word in words) {

        //BUG IS HERE !!
        if (canFormWord(letters,word)) {
            matchingWords.add(word)
        }
    }

    // calculate score of each winning word :
    for (word in matchingWords) {

        var wordScore = 0

        for (char in word) {
            wordScore += letterPoints.getOrDefault(char, 0)
        }

        if (!matchingWordsWithScores.containsKey(word)) {
            matchingWordsWithScores[word] = wordScore
        }

    }

    //Get word with the highest score
    val maxEntry = matchingWordsWithScores.maxBy { it.value }

    return maxEntry.key
}


fun canFormWord(given: String, playerWord: String): Boolean {
    // Count occurrences in given letters
    val available = HashMap<Char, Int>()
    for (c in given) {
        available[c] = (available[c] ?: 0) + 1
    }

    // Count occurrences in player's word
    val needed = HashMap<Char, Int>()
    for (c in playerWord) {
        needed[c] = (needed[c] ?: 0) + 1
    }

    // Compare counts
    for ((char, count) in needed) {
        if (count > (available[char] ?: 0)) {
            return false
        }
    }
    return true
}
