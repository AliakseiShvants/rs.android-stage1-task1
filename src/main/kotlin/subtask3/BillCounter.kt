package subtask3

private const val BON_APPETIT = "Bon Appetit"

class BillCounter {

    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        val expectedPaid = bill.filterIndexed { index, _ -> index != k }.sum() / 2
        val diff = b - expectedPaid

        return if (diff > 0) "$diff" else BON_APPETIT
    }
}
