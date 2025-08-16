package org.example

class RecentCounter {

    var count : Int = 0
        private set

    private val requests : ArrayDeque<Int> = ArrayDeque()

    fun ping(t: Int): Int {

        requests.addLast(t)

        while (requests.first() < t-3000) {
            requests.removeFirst()
        }
        count = requests.count()

        return count
    }

}