package stack

interface Stack<Element> {
    fun push(element: Element)
    fun pop(): Element?
    fun peek(): Element?
    val count: Int
    val isEmpty: Boolean
        get() = count == 0
}

class StackImpl<T> : Stack<T> {
    private val storage = arrayListOf<T>()

    override fun push(element: T) {
        storage.add(element)
    }

    override fun pop(): T? {
        return if (isEmpty) null
        else storage.removeAt(storage.size - 1)
    }

    override fun peek(): T? {
        return storage.lastOrNull()
    }

    override val count: Int
        get() = storage.size

    override fun toString() = buildString {
        appendLine("----top----")
        storage.asReversed().forEach {
            appendLine("$it")
        }
        appendLine("-----------")
    }

}