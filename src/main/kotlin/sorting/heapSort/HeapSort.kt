package sorting.heapSort

private fun leftChildIndex(index: Int) = (2 * index) + 1
private fun rightChildIndex(index: Int) = (2 * index) + 2

fun <T> Array<T>.siftDown(
    index: Int,
    upTo: Int,
    comparator: Comparator<T>
) {
    var parent = index
    while (true) {
        val left = leftChildIndex(parent)
        val right = rightChildIndex(parent)
        var candidate = parent
        if (left < upTo &&
            comparator.compare(this[left], this[candidate]) > 0
        ) {
            candidate = left
        }
        if (right < upTo &&
            comparator.compare(this[right], this[candidate]) > 0
        ) {
            candidate = right
        }
        if (candidate == parent) {
            return
        }
        this.swapAt(parent, candidate)
        parent = candidate
    }
}