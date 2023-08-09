package sorting.radixSort

fun MutableList<Int>.radixSort() {
    // 1 You’re sorting base 10 integers in this instance
    val base = 10
    // 2 You declare two variables to track your progress. Radix sort works in many passes,
    // so done serves as a flag that determines whether the sort is complete.
    // The digits variable keeps track of the current digit you’re looking at.
    var done = false
    var digits = 1
    while (!done) {
        done = true
        // Bucket sort
        // 1 You instantiate the buckets using a two-dimensional list.
        // Because you’re using base 10, you need ten buckets.
        val buckets = arrayListOf<MutableList<Int>>().apply {
            for (i in 0..9) {
                this.add(arrayListOf())
            }
        }

        // 2 You place each number in the correct bucket.
        this.forEach { number ->
            val remainingPart = number / digits
            val digit = remainingPart % base
            buckets[digit].add(number)
            if (remainingPart > 0) {
                done = false
            }
        }

        // 3 You update digits to the next digit you want to inspect and update the list
        // using the contents of buckets. flatten() flattens the two-dimensional list
        // to a one- dimensional list, as if you’re emptying the buckets into the list.
        digits *= base
        this.clear()
        this.addAll(buckets.flatten())
    }
}
