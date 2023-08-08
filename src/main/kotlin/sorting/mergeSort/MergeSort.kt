package sorting.mergeSort

fun <T : Comparable<T>> List<T>.mergeSort(): List<T> {
    if (this.size < 2) return this
    val middle = this.size / 2
    val left = this.subList(0, middle).mergeSort()
    val right = this.subList(middle, this.size).mergeSort()

    return merge(left, right)
}

private fun <T : Comparable<T>> merge(
    left: List<T>, right: List<T>
): List<T> {
    // 1  leftIndex and rightIndex variables track your progress as you parse through the two lists.
    var leftIndex = 0
    var rightIndex = 0

    // 2 The result list will house the combined lists.
    val result = mutableListOf<T>()

    // 3 Starting from the beginning, you compare the elements in the left and right lists sequentially.
    // When you reach the end of either list, there’s nothing else to compare.
    while (leftIndex < left.size && rightIndex < right.size) {
        val leftElement = left[leftIndex]
        val rightElement = right[rightIndex]

        // 4 The smaller of the two elements goes into the result list.
        // If the elements are equal, they can both be added.
        if (leftElement < rightElement) {
            result.add(leftElement)
            leftIndex += 1
        } else if (leftElement > rightElement) {
            result.add(rightElement)
            rightIndex += 1
        } else {
            result.add(leftElement)
            leftIndex += 1
            result.add(rightElement)
            rightIndex += 1
        }

    }

    // 5 The first loop guarantees that either left or right is empty. Since both lists are sorted,
    // this ensures that the leftover elements are greater than or equal to the ones currently in result.
    // In this scenario, you can add the rest of the elements without comparison.
    if (leftIndex < left.size) {
        result.addAll(left.subList(leftIndex, left.size))
    }
    if (rightIndex < right.size) {
        result.addAll(right.subList(rightIndex, right.size))
    }
    return result
}