package sorting.quickSort

fun <T : Comparable<T>> List<T>.quicksortNaive(): List<T> {
    // 1 There must be more than one element in the list. If not, the list is considered sorted.
    if (this.size < 2) return this

    // 2 Pick the middle element of the list as your pivot.
    val pivot = this[this.size / 2]

    // 3 Using the pivot, split the original list into three partitions. Elements less than,
    //equal to or greater than the pivot go into different buckets.
    val less = this.filter { it < pivot }
    val equal = this.filter { it == pivot }
    val greater = this.filter { it > pivot }

    // 4 Recursively sort the partitions and then combine them.
    return less.quicksortNaive() + equal +
            greater.quicksortNaive()
}