package subtask5

private const val NINE = '9'
private const val ERROR = "-1"

class HighestPalindrome {

    fun highestValuePalindrome(n: Int, k: Int, digitString: String): String {
        val startPart = digitString.substring(0, n / 2).toCharArray()
        val endPart = digitString.substring(n / 2).toCharArray()
        val diff = mutableListOf<Int>()

        endPart.reverse()

        startPart.forEachIndexed { index, char ->
            if (endPart[index] != char) diff.add(index)
        }

        if (diff.size > k) {
            return ERROR
        }

        var x = k

        loop@ while (x > 0) {
            when {
                diff.size > 0 -> {
                    val index = diff[0]
                    val element = if (startPart[index].toInt() > endPart[index].toInt()) {
                        startPart[index]
                    } else {
                        endPart[index]
                    }

                    startPart[index] = element
                    endPart[index] = element
                    diff.remove(index)
                    x--

                    continue@loop
                }
                else -> {
                    if (k > 1) {
                        val element = startPart.firstOrNull { it != NINE }

                        element?.let {
                            startPart[startPart.indexOf(element)] = NINE
                            endPart[endPart.indexOf(element)] = NINE
                        }

                        x -= 2
                    }
                }
            }
        }

        endPart.reverse()

        return "${String(startPart)}${String(endPart)}"
    }
}
