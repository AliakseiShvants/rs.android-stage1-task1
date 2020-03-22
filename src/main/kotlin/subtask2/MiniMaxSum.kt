package subtask2

class MiniMaxSum {

    fun getResult(input: IntArray): IntArray {
        val maxSum = input.sortedArray().drop(1).sum()
        val minSum = input.sortedArray().dropLast(1).sum()

        return arrayOf(minSum, maxSum).toIntArray()
    }
}
