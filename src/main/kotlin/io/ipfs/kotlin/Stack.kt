package io.ipfs.kotlin

class Stack<T>{
    val elements: MutableList<T> = mutableListOf()
    fun isEmpty() = elements.isEmpty()
    fun count() = elements.size
    fun clear() = elements.clear()
    fun push(item: T) = elements.add(item)
    fun pop() : T {
        if (isEmpty()){
	    throw Exception("Stack is empty")
	}

	val item = elements.last()
        elements.removeAt(elements.size -1)
	
        return item
    }

    fun peek() : T? = elements.lastOrNull()

    fun forEach (action: (T) -> Unit) = elements.forEach(action)
    override fun toString(): String = elements.toString()
}

fun <T> Stack<T>.push(items: Collection<T>) = items.forEach { this.push(it) }
