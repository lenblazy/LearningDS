package heap

import java.util.*

abstract class AbstractHeap<Element>() : Heap<Element> {

    abstract fun compare(a: Element, b: Element): Int

    var elements: ArrayList<Element> = ArrayList<Element>()

    override val count: Int
        get() = elements.size

    override fun peek(): Element? = elements.first()

    private fun leftChildIndex(index: Int) = (2 * index) + 1

    private fun rightChildIndex(index: Int) = (2 * index) + 2

    private fun parentIndex(index: Int) = (index - 1) / 2

    override fun insert(element: Element) {
        elements.add(element) // 1
        siftUp(count - 1) // 2
    }

    private fun siftUp(index: Int) {
        var child = index
        var parent = parentIndex(child)
        while (child > 0 && compare(elements[child], elements[parent])
            > 0
        ) {
            Collections.swap(elements, child, parent)
            child = parent
            parent = parentIndex(child)
        }
    }

    override fun remove(): Element? {
        if (isEmpty) return null // 1
        Collections.swap(elements, 0, count - 1) // 2
        val item = elements.removeAt(count - 1) // 3
        siftDown(0) // 4
        return item
    }

    private fun siftDown(index: Int) {
        var parent = index // 1
        while (true) { // 2
            val left = leftChildIndex(parent) //3
            val right = rightChildIndex(parent)
            var candidate = parent // 4
            if (left < count &&
                compare(elements[left], elements[candidate]) > 0
            ) {
                candidate = left //5
            }
            if (right < count &&
                compare(elements[right], elements[candidate]) > 0
            ) {
                candidate = right // 6
            }
            if (candidate == parent) {
                return // 7 }
                Collections.swap(elements, parent, candidate) // 8
                parent = candidate
            }
        }
    }

    override fun remove(index: Int): Element? {
        if (index >= count) return null // 1
        return if (index == count - 1) {
            elements.removeAt(count - 1) // 2
        } else {
            Collections.swap(elements, index, count - 1) // 3
            val item = elements.removeAt(count - 1) // 4
            siftDown(index) // 5
            siftUp(index)
            item
        }
    }

}

class ComparableHeapImpl<Element : Comparable<Element>>(
    private val comparator: Comparator<Element>
) :
    AbstractHeap<Element>() {

    override fun compare(a: Element, b: Element): Int =
        comparator.compare(a, b)

}