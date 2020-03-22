package subtask4

enum class Chars(val char: Char) {
    OPENED_ROUND_BRACKET('('),
    CLOSED_ROUND_BRACKET(')'),
    OPENED_SQUARE_BRACKET('['),
    CLOSED_SQUARE_BRACKET(']'),
    RIGHT_ARROW('>'),
    LEFT_ARROW('<');
}

class StringParser {

    fun getResult(inputString: String): Array<String> {
        val openedRound = mutableListOf<Int>()
        val closedRound = mutableListOf<Int>()
        val openedSquare = mutableListOf<Int>()
        val closedSquare = mutableListOf<Int>()
        val leftArrow = mutableListOf<Int>()
        val rightArrow = mutableListOf<Int>()

        inputString.forEachIndexed { index, char ->
            when (char) {
                Chars.OPENED_ROUND_BRACKET.char -> openedRound.add(index)
                Chars.CLOSED_ROUND_BRACKET.char -> closedRound.add(index)
                Chars.OPENED_SQUARE_BRACKET.char -> openedSquare.add(index)
                Chars.CLOSED_SQUARE_BRACKET.char -> closedSquare.add(index)
                Chars.LEFT_ARROW.char -> leftArrow.add(index)
                Chars.RIGHT_ARROW.char -> rightArrow.add(index)
            }
        }

        val pairs = mutableListOf<Pair<Int, Int>>()

        if (leftArrow.size == rightArrow.size && leftArrow.size > 0) {
            leftArrow.reverse()

            for (index in 0 until leftArrow.size) {
                val sumList = mutableListOf<Int>()

                rightArrow.forEach {
                    sumList.add(it - leftArrow[index])
                }

                val outElement = sumList.filter { it > 0 }.min()
                val position = sumList.indexOf(outElement)

                pairs.add(Pair(leftArrow[index], rightArrow[position]))

                rightArrow[position] = 0
            }
        }

        if (openedRound.size == closedRound.size && openedRound.size > 0) {
            openedRound.reverse()

            for (index in 0 until openedRound.size) {
                val sumList = mutableListOf<Int>()

                closedRound.forEach {
                    sumList.add(it - openedRound[index])
                }

                val outElement = sumList.filter { it > 0 }.min()
                val position = sumList.indexOf(outElement)

                pairs.add(Pair(openedRound[index], closedRound[position]))

                closedRound[position] = 0
            }
        }

        if (openedSquare.size == closedSquare.size && openedSquare.size > 0) {
            openedSquare.reverse()

            for (index in 0 until openedSquare.size) {
                val sumList = mutableListOf<Int>()

                closedSquare.forEach {
                    sumList.add(it - openedSquare[index])
                }

                val outElement = sumList.filter { it > 0 }.min()
                val position = sumList.indexOf(outElement)

                pairs.add(Pair(openedSquare[index], closedSquare[position]))

                closedSquare[position] = 0
            }
        }

        pairs.sortBy { it.first }

        val result = mutableListOf<String>()

        pairs.forEach { pair ->
            result.add(inputString.substring(pair.first + 1, pair.second))
        }

        return result.toTypedArray()
    }
}
