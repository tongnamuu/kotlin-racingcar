package onestep.calculator

fun main() {
    println("계산식을 입력하세요.")
    val inputData = readLine()
    try {
        CalculatorInputManager
            .calculate(inputData)
            .run {
                println("정답 : $this")
            }
    } catch (e: Exception) {
        println("Error : ${e.localizedMessage}")
    }
}

object CalculatorInputManager {
    private val regex = Regex("\\d+(\\s[+\\-*/]\\s\\d+)+")

    fun calculate(inputStr: String?): String {
        val list = validationCheckInput(inputStr).split(" ")

        var result: Double = list.first().toDouble()
        for (i in 2..list.size step 2) {
            result = Calculator.calculate(result, list[i - 1], list[i].toDouble())
        }
        return result.toString()
    }

    private fun validationCheckInput(inputStr: String?): String {
        if (inputStr.isNullOrBlank()) {
            throw IllegalArgumentException("Wrong Input")
        }
        if (regex.matches(inputStr).not()) {
            throw IllegalArgumentException("Wrong Expression Input")
        }
        return inputStr
    }
}