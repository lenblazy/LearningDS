package queue

class ArrayListQueue<T>: Queue<T> {

    private val list = arrayListOf<T>()

    //O(1)
    override fun enqueue(element: T): Boolean {
        list.add(element)
        return true
    }

    //O(n)
    override fun dequeue(): T? = if (isEmpty) null else list.removeAt(0)

    //O(1)
    override val count: Int
        get() = list.size

    //O(1)
    override fun peek(): T? = list.getOrNull(0)

    override fun toString(): String = list.toString()
}