package week5

import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val ary = LongArray(n)
    repeat(n) {
        ary[it] = readLine().toLong()
    }
    ary.sort()
    var left = 0
    var right = 0
    var max = Long.MAX_VALUE
    while (left < n && right < n) {
        val sum = abs(ary[right] - ary[left])
        if (sum >= m) {
            max = Math.min(sum, max)
            left++
        } else {
            right++
        }
    }
    println(max)
}


// 1 ≤ N ≤ 100,000
// 0 ≤ M ≤ 2,000,000,000
// 0 ≤ |A[i]| ≤ 1,000,000,000


//10 5
//-10
//-8
//-6
//-4
//-2
//2
//4
//6
//8
//10

//5 2
//-10
//-7
//-4
//-2
//-1
