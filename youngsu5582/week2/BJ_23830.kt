package week2

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val st = StringTokenizer(readLine())
    val ary = IntArray(n)
    repeat(n) {
        ary[it] = st.nextToken().toInt()
    }

    val (p, q, r, s) = readLine().split(" ").map { it.toLong() }

    var left = 1L
    var right = 20000000000L

    while (left <= right) {
        var total = 0L
        var mid = (left + right) / 2
        for (element in ary) {
            total += calculate(element, mid, p.toInt(), q.toInt(), r.toInt())
        }

        if (total >= s) {
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    if (left >= 20000000000) println(-1) else println(left)
}

private fun calculate(element: Int, mid: Long, p: Int, q: Int, r: Int): Int {
    return if (element > mid + r) {
        element - p
    } else if (element < mid) {
        element + q
    } else {
        element
    }
}
