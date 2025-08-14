fun main() {
    println("Hello Ransom Note !")
    println(canConstruct("aa","aab"))
}


/*
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.


Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true

 */

fun canConstruct(ransomNote: String, magazine: String): Boolean {

    val hashRansomNote = hashMapOf<Char,Int>()

    val hashMagazine = hashMapOf<Char,Int>()

    // populate hash from ransomNote
    for (character in ransomNote){
        hashRansomNote[character] = hashRansomNote.getOrDefault(character, 0) + 1
    }

    // populate hash from magazine
    for (character in magazine){
        hashMagazine[character] = hashMagazine.getOrDefault(character, 0) + 1
    }

    // check in hash magazine
    for (kv in hashRansomNote) {
        if (hashMagazine.getOrDefault(kv.key, 0) < kv.value){
            return false
        }
    }

    return true
}