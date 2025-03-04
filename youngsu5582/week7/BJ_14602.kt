// 11:18
import java.util.*
import java.util.concurrent.CompletableFuture

fun main() = with(System.`in`.bufferedReader()) {
    val (m, n, k, w) = readLine().split(" ").map { it.toInt() }
    val ary = Array(m) { IntArray(n) }

    repeat(m) { i ->
        val st = StringTokenizer(readLine())
        repeat(n) { j ->
            ary[i][j] = st.nextToken().toInt()
        }
    }

    val result = Array(m - w + 1) { IntArray(n - w + 1) }
    for (i in 0..m - w) {
        for (j in 0..n - w) {
            val temp = mutableListOf<Int>()
            for (x in i until i+w) {
                for (y in j until j+w) {
                    temp.add(ary[x][y])
                }
            }
            result[i][j] = temp.sorted()[(w * w) / 2]
        }
    }
    val sb = StringBuilder()
    for (i in 0 until m - w + 1) {
        for (j in 0 until n - w + 1) {
            sb.append(result[i][j]).append(" ")
        }
        sb.append("\n")
    }
    println(sb)
}

// 0 - 가장 어두운
// k - 가장 밝음

// 행렬 A : M * N

// 1 ≤ i ≤ M-W+1
// 1 ≤ j ≤ N-W+1
// 0 ≤ x, y < W

// 입력
// 행렬 크기 M N ( 1 <= ... <= 30)

// 최고 밝기 K ( 1 <= K <= 10000 ), 정수 W ( 홀수 ) ( M 과 N 중 최소값 )
// -> 홀수이므로 무조건 보장

// M 번 반복
// 각 줄마다 N개의 0 이상 K 이하 정수 주어짐

// 3 3 10 1
// 1 2 3
// 4 5 6
// 7 8 9

// 1 ≤ i ≤ 3
// 1 ≤ j ≤ 3

// 5 5 20 3
// 5 1 2 8 10
// 12 10 3 20 7
// 8 12 19 18 15
// 17 19 2 5 13
// 11 2 4 14 16

// 1 2 3 5 8 10 12 12 19
// 8

// 5 1 2
// 12 10 3
// 8 12 19
