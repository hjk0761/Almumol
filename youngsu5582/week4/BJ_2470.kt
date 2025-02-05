import java.util.*
import kotlin.math.abs

// 10:10 - 10:36

private fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val st = StringTokenizer(readLine())
    val ary = LongArray(n) { 0 }
    repeat(n) {
        ary[it] = st.nextToken().toLong()
    }
    ary.sort()

    var left = 0
    var right = (n - 1)
    var answer = Solution(-1_000_000_000, 0)
    while (left < right) {
        val l = ary[left]
        val r = ary[right]
        val solution = Solution(l, r)
        if (solution.sum() < answer.sum()) {
            answer = solution
        }
        if (compare(l, r)) {
            left++
        } else {
            right--
        }
    }
    println("${answer.left} ${answer.right}")
}

data class Solution(
    val left: Long,
    val right: Long
) {
    fun sum(): Long {

        return abs(right + left)
    }
}

// 왼쪽이 더 크다면 True
// 아니라면 False
private fun compare(left: Long, right: Long): Boolean {
    return abs(left) > abs(right)
}

// N : 100,000
// 산성 특성값 : 1 ~ 1,000,000,000
// 알칼리 독성값 : -1 ~ -1,000,000,000

// 특성값 들은 모두 다름
// 산성,알칼리로만 나올 수도 있음

// 정렬을 필연적으로 해야 한다.

// -99 -2 -1 4 98
// 왼쪽이 절대값이 더 크면? - 왼쪽을 오른쪽으로 당긴다.
// 오른쪽이 절대값이 더 크면? - 오른쪽을 왼쪽으로 당긴다.
