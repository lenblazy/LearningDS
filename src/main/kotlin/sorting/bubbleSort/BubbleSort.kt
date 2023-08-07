package sorting.bubbleSort

import sorting.swapAt

fun <T : Comparable<T>> ArrayList<T>.bubbleSort(
    showPasses:
    Boolean = false
) {
// 1
    if (this.size < 2) return
    // 2
    for (end in (1 until this.size).reversed()) {
        var swapped = false
        // 3
        for (current in 0 until end) {
            if (this[current] > this[current + 1]) {
                // 4
                this.swapAt(current, current + 1)
                swapped = true
            }
        }
// 5
        if (showPasses) println(this)
        // 6
        if (!swapped) return
    }
}