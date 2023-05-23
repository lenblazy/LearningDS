package stack

interface Stack<Element> {
    fun push(element: Element)
    fun pop(): Element?
}

class StackImpl<T : Any>() : Stack<T> {
    private val storage = arrayListOf<T>()

    override fun push(element: T) {
        storage.add(element)
    }

    override fun pop(): T? {
        if (storage.size == 0) {
            return null
        }
        return storage.removeAt(storage.size - 1)
    }

    override fun toString() = buildString {
        appendLine("----top----")
        storage.asReversed().forEach {
            appendLine("$it")
        }
        appendLine("-----------")
    }

}