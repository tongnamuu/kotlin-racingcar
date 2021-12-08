package study

class StringCalculator(
    private val input: String?
) {
    fun validate() {
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException()
        }
    }
    fun singleAdd(firstNum: Int, secondNum: Int) = firstNum + secondNum
    fun singleSubtract(firstNum: Int, secondNum: Int) = firstNum - secondNum
    fun singleMultiply(firstNum: Int, secondNum: Int) = firstNum * secondNum
    fun singleDivision(firstNum: Int, secondNum: Int) = firstNum / secondNum
}
