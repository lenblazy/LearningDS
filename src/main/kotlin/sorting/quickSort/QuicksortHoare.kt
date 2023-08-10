package sorting.quickSort

import sorting.swapAt

fun <T : Comparable<T>> MutableList<T>.partitionHoare(
    low: Int,
    high: Int
): Int {

    val pivot = this[low] // 1 Select the first element as the pivot.


    var i = low - 1 // 2 Indexes i and j define two regions. Every index before i will be less than or equal to the pivot.
    // Every index after j will be greater than or equal to the pivot.
    var j = high + 1
    while (true) {

        do { // 3 j -= 1 Decrease j until it reaches an element that is not greater than the pivot.
        } while (this[j] > pivot)
        do {
            // 4 Increase i until it reaches an element that is not less than the pivot.
            i += 1
        } while (this[i] < pivot)
        if (i < j) { // 5 If i and j have not overlapped, swap the elements.
            this.swapAt(i, j)
        } else {
            return j // 6 } Return the index that separates both regions.

        }
    }
}