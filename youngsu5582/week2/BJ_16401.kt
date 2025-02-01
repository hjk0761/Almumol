package week2

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (m, n) = readLine().split(" ").map { it.toInt() }
    val st = StringTokenizer(readLine())
    val ary = IntArray(n)
    repeat(n) {
        ary[it] = st.nextToken().toInt()
    }
    var left = 1
    var right = 1_000_000_000
    var answer = 0

    while (left <= right) {
        val mid = (left + right) / 2
        var count = 0
        for (chip in ary) {
            count += chip / mid
        }
        if (count >= m) {
            answer = answer.coerceAtLeast(mid)
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    println(answer)
}


