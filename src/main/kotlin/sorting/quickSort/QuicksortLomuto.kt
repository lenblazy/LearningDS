package sorting.quickSort

import sorting.swapAt

fun <T : Comparable<T>> MutableList<T>.partitionLomuto(
    low: Int,
    high: Int
): Int {
    // 1 Set the pivot. Lomuto always chooses the last element as the pivot.
    val pivot = this[high]
    // 2 The variable i indicates how many elements are less than the pivot. Whenever you encounter an element that is
    // less than the pivot, you swap it with the element at index i and increase i.
    var i = low
    // 3 Loop through all the elements from low to high, but not including high since it’s the pivot.
    for (j in low until high) {
        // 4 Check to see if the current element is less than or equal to the pivot.
        if (this[j] <= pivot) {
            // 5 If it is, swap it with the element at index i and increase i.
            this.swapAt(i, j)
            i += 1
        }
    }
    // 6 Once done with the loop, swap the element at i with the pivot. The pivot always
    //sits between the less and greater partitions.
    this.swapAt(i, high)
    // 7 Return the index of the pivot.
    return i

}

fun<T: Comparable<T>> MutableList<T>.quicksortLomuto(low: Int,
                                                     high: Int) {
    if (low < high) {
        val pivot = this.partitionLomuto( low, high)
        this.quicksortLomuto( low, pivot - 1)
        this.quicksortLomuto( pivot + 1, high)
    }
}