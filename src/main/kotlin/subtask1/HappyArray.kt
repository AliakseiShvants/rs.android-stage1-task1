package subtask1

class HappyArray {

    fun convertToHappy(sadArray: IntArray): IntArray {
        var resultArr = sadArray.toMutableList()
        var isSad: Boolean

        do {
            isSad = false

            for (x in 1 until resultArr.size - 1) {
                if (resultArr[x - 1] + resultArr[x + 1] < resultArr[x]) {
                    resultArr.removeAt(x)
                    isSad = true

                    break
                }
            }
        } while (isSad)

        return resultArr.toIntArray()
    }
}