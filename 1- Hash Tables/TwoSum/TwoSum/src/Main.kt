fun main() {
    println("Hello getIndices")
    println(getIndices(arrayOf(5,2,7,10,3,9), 8))
}

/*
Given an array of integers nums and an integer target, return indices of two numbers such that they add up to target. You cannot use the same index twice.
 */


fun getIndices(array : Array<Int>,target : Int) : String{

    val map = hashMapOf<Int, Int>()

    for (i in array.indices){
        if (map.containsKey(target - array[i])){
            return "$i , ${map[target - array[i]]}"
        }
        map[array[i]] = i
    }

    return "No result"
}