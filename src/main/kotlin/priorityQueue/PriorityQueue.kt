package priorityQueue

import heap.ComparableHeapImpl

class ComparablePriorityQueueImpl<T : Comparable<T>> :
    AbstractPriorityQueue<T>() {
    override val heap = ComparableHeapImpl<T>()
}

class ComparatorPriorityQueueImpl<T>(
    private val comparator: Comparator<T>
) : AbstractPriorityQueue<T>() {
    override val heap = ComparatorHeapImpl(comparator)
}