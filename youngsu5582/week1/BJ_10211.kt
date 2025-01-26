package week1

private fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    val list = IntArray(t)
    for (i in 0 until t) {
        val n = readLine().toInt()
        val numbers = readLine().split(" ").map { it.toInt() }.toIntArray()
        list[i] = findMax(numbers)
    }

    list.forEach { println(it) }
}

fun findMax(numbers: IntArray): Int {
    for (i in 1 until numbers.size) {
        val value = numbers[i - 1] + numbers[i]
        if (value > numbers[i]) {
            numbers[i] = value
        }
    }
    return numbers.max()
}
