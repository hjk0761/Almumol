package week6

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val waters = IntArray(n)
    repeat(n) {
        waters[it] = readLine().toInt()
    }
    val floyd = Array(n) { IntArray(n) }
    repeat(n) { i ->
        val st = StringTokenizer(readLine())
        repeat(n) { j ->
            floyd[i][j] = st.nextToken().toInt()

        }
    }
    // 가장 작은 값부터 나오게
    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                floyd[i][j] = Math.min(floyd[i][k] + floyd[k][j], floyd[i][j])
            }
        }
    }
    println(floyd.contentDeepToString())

    var answer = Int.MAX_VALUE
    for (index in waters.indices) {
        val visited = BooleanArray(n)
        var result = 0
        val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })

        var count = 0

        // left : 위치, right : 비용
        pq.add(Pair(index, waters[index]))
        while (pq.isNotEmpty()) {
            val (pos, cost) = pq.poll()
            if (visited[pos]) {
                continue
            }
            if (count == n) {
                break
            }
            count++
            visited[pos] = true
            result += cost
            for (i in 0 until n) {
                if (!visited[i]) pq.add(Pair(i, floyd[pos][i]))
            }
        }
        answer = Math.min(result, answer)
    }
    println(answer)
}

// 11:22 - 

//각각의 논에 대해 우물을 파는 비용과 논들 사이에 물을 끌어오는 비용들이 주어졌을 때 최소의 비용으로 모든 논에 물을 대는 것이 문제이다.

// 4번째에서 3, -> 1, -> 2 -> 3

// 3 + 2 + 2 + 2

// N 은 300

//[[0, 5, 1, 4], [5, 0, 6, 1], [1, 6, 0, 5], [4, 1, 5, 0]]

// 2(1) -> 4 (1) -> 1 ( 4 ) -> 3 ( 1 )

//
