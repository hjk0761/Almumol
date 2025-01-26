package week2

import java.util.*

private fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val st = StringTokenizer(readLine())
    val ary = mutableListOf<Int>()

    repeat(n) {
        ary.add(st.nextToken().toInt())
    }
    var left = 0
    var right = 2000000

    while (left <= right) {
        val mid = (left + right) / 2
        var total = 0
        var count = 0

        for (sentence in ary) {
            total += sentence
            if (total >= mid) {
                count++
                total = 0
            }
        }
        if (count >= k) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    println(right)
}

// 일정 문제 갯수까지 합친다.
// 안된다면? -> 점수를 낮춰.
// 된다면? 점수를 높여

// 시험지 개수 : N, 시험지 나눌 그룹의  K ( 1 <= K <= N <= 10^5 )
// 각 시험지마다 맞은 문제의 개수 x

//8 2
//12 7 19 20 17 14 9 10

//8 3
//38 37 33
// 3 2 3
