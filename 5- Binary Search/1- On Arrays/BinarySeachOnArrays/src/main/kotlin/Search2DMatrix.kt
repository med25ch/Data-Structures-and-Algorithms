package org.example

fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {

    var leftMatrix = 0
    var rightMatrix = matrix.size - 1

    while (leftMatrix <= rightMatrix) {

        val midMatrix = leftMatrix + (rightMatrix - leftMatrix)/2

        if (matrix[midMatrix].first() > target){
            rightMatrix = midMatrix - 1
        }else if(matrix[midMatrix].last() < target){
            leftMatrix = midMatrix + 1
        }else {
            // looping inside the midMatrix
           return matrix[midMatrix].binarySearch(target) >= 0
        }
    }

    return false
}