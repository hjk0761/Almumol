class Solution {
    fun solution(numbers: IntArray): String {
        val sortedNumbers = numbers
            .map { it.toString() }
            .sortedWith { o1, o2 ->
                val combined1 = o1 + o2
                val combined2 = o2 + o1
                combined2.compareTo(combined1)
            }

        val answer = sortedNumbers.joinToString("")

        return if (answer.all { it == '0' }) "0" else answer
    }
}
