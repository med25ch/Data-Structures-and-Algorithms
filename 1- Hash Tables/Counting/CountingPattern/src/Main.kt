fun main() {
    println("Hello findLongestSubstring!")
    println(findLongestSubstring("eceba", 2))
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