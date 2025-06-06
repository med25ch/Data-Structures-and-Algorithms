class MyCustomStack<T> {

    private val list = mutableListOf<T>()

    fun pop(){
        if(list.isNotEmpty()){
            list.removeAt(list.lastIndex)
        }
    }

    fun push(item: T) {
        list.add(item)
    }

    fun peek(): T? {
        return list.lastOrNull()
    }

    fun isEmpty(): Boolean {
        return list.isEmpty()
    }
}