package week3

import java.util.*

fun main(): Unit = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val ary = Array(n) { BooleanArray(n) }
    repeat(n) {
        val st = StringTokenizer(readLine())
        repeat(n) { idx ->
            ary[it][idx] = if (st.nextToken().toInt() == 1) true else false
        }
    }
    // 갈 수 있으면 true, 없으면 false
    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                ary[i][j] = ary[i][j] || ary[i][k] && ary[k][j]
            }
        }
    }
    val sb = StringBuilder()
    for (i in 0 until n) {
        for (j in 0 until n) {
            sb.append(if (ary[i][j]) 1 else 0).append(" ")
        }
        sb.append("\n")
    }
    println(sb)
}
