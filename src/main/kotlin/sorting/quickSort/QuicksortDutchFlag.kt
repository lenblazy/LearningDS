package sorting.quickSort

import sorting.swapAt

fun<T: Comparable<T>> MutableList<T>.partitionDutchFlag(low:
                                                        Int, high: Int, pivotIndex: Int): Pair<Int, Int> {
    val pivot = this[pivotIndex]
    var smaller = low // 1
    var equal = low // 2
    var larger = high // 3
    while (equal <= larger) { // 4
        if (this[equal] < pivot) {
            this.swapAt(smaller, equal)
            smaller += 1
            equal += 1
        } else if (this[equal] == pivot) {
            equal += 1
        } else {
            this.swapAt(equal, larger)
            larger -= 1 }
    }
    return Pair(smaller, larger) // 5
}