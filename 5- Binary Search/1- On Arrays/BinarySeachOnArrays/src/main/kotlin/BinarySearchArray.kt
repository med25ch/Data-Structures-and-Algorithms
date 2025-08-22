package org.example

fun search(nums: IntArray, target: Int): Int {

    var left = 0
    var right = nums.size - 1

    while (left <= right) {

        val mid = left + (right-left)/2
        val num = nums[mid]

        if (num == target) {
            return mid
        }

        if (num < target) {
            left = mid + 1
        }else{
            right = mid - 1
        }
    }

    return -1
}