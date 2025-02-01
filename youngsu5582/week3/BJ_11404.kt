package week3

import java.util.*

private const val max = 100000 * 100
private fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val ary = Array(n) { IntArray(n) { max } }
    repeat(n) {
        ary[it][it] = 0
    }
    val m = readLine().toInt()
    repeat(m) {
        val st = StringTokenizer(readLine())
        val a = st.nextToken().toInt() - 1
        val b = st.nextToken().toInt() - 1
        val c = st.nextToken().toInt()
        ary[a][b] = ary[a][b].coerceAtMost(c)
    }

    for (k in 0 until n) {
        for (i in n - 1 until n) {
            for (j in 0 until n) {
                if (ary[i][j] > ary[i][k] + ary[k][j]) {
                    ary[i][j] = ary[i][k] + ary[k][j]
                }
            }
        }
    }
    repeat(n) { x ->
        repeat(n) { y ->
            if (ary[x][y] == max) {
                ary[x][y] = 0
            }
        }
    }
    ary.forEach { println(it.joinToString(" ")) }
}

// 예제1
//2
//2
//1 2 10
//2 1 5

// 예제2
//3
//
//1 2 10
//2 1 5
//3 2 4
//3 1 100
//2 3 10

private fun bfs(ary: Array<LongArray>, visited: Array<BooleanArray>, queue: MutableList<Element>) {
    while (queue.isNotEmpty()) {
        val element = queue.removeFirst()
        val x = element.x
        val y = element.y
        val value = element.value
        for (j in ary.indices) {
            if (visit(ary, visited, Pair(y, j))) {
                ary[x][j] = ary[x][j].coerceAtMost(value + ary[y][j])
                visited[y][j] = true
                queue.add(Element(y, j, value + ary[y][j]))
            }
        }
    }
}

private fun visit(ary: Array<LongArray>, visited: Array<BooleanArray>, pair: Pair<Int, Int>): Boolean =
    ary[pair.first][pair.second] != Long.MAX_VALUE && !visited[pair.first][pair.second]

private data class Element(
    val x: Int,
    val y: Int,
    val value: Long
)


// n(2 ≤ n ≤ 100)개의 도시가 있다. 그리고 한 도시에서 출발하여 다른 도시에 도착하는 m(1 ≤ m ≤ 100,000)개의 버스가 있다. 각 버스는 한 번 사용할 때 필요한 비용이 있다.
// 모든 도시의 쌍 (A, B)에 대해서 도시 A에서 B로 가는데 필요한 비용의 최솟값을 구하는 프로그램을 작성하시오.

// 0 -> 1
// 1에 도착시? 2
// 모든걸 초기화?
// 1을 통해 가는 모든 경우

// 4 5
// 5 1
// 4 1 -> ?
