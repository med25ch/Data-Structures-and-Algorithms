fun main() {
    println("First Recurring Character")
    val array1 = arrayOf(2, 5, 5, 2, 3, 5, 1, 2, 4) // return 5 because the pairs are before 2,2
    val array2 = arrayOf(2, 3, 4, 5) //It should return undefined
    val array3 = arrayOf(2, 1, 1, 2, 3, 5, 1, 2, 4) //It should return 1
    val array4 = arrayOf(2, 5, 1, 2, 3, 5, 1, 2, 4) //It should return 2

    val result = firstRecurringCharacter(array3)
    println(result)
}



//Google Question
//Given an array = [2,5,1,2,3,5,1,2,4]:
//It should return 2

//Given an array = [2,1,1,2,3,5,1,2,4]:
//It should return 1

//Given an array = [2,3,4,5]:
//It should return undefined


//Bonus... What if we had this:
// [2,5,5,2,3,5,1,2,4]
// return 5 because the pairs are before 2,2

fun firstRecurringCharacter (array: Array<Int>) : String {

    val map = HashMap<Int,Int>()

    for (i in array.indices) {
        if (map.containsKey(array[i])){
            return array[i].toString()
        }else{
            map[array[i]] = i
        }
    }

    return "undefined"
}
