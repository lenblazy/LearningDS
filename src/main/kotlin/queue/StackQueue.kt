package queue

import stack.StackImpl

class StackQueue<T>: Queue<T> {

    private val leftStack = StackImpl<T>()
    private val rightStack = StackImpl<T>()

    //O(1)
    override val isEmpty: Boolean
        get() = leftStack.isEmpty && rightStack.isEmpty

    private fun transferElements() {
        var nextElement = rightStack.pop()
        while (nextElement != null) {
            leftStack.push(nextElement)
            nextElement = rightStack.pop()
        }
    }

    override fun enqueue(element: T): Boolean {
        rightStack.push(element)
        return true
    }

    override fun dequeue(): T? {
        if (leftStack.isEmpty) { // 1
            transferElements() // 2
        }
        return leftStack.pop() // 3
    }

    override fun toString(): String {
        return "Left stack: \n$leftStack \n Right stack: \n$rightStack"
    }

    override val count: Int
        get() = TODO("Not yet implemented")

    //O(n)
    override fun peek(): T? {
        if (leftStack.isEmpty) {
            transferElements()
        }
        return leftStack.peek()
    }
}