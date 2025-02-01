package week3

import java.util.*;

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val ary = Array(n) { IntArray(m) }
    repeat(n) { x ->
        val st = StringTokenizer(readLine())
        repeat(m) { y ->
            ary[x][y] = st.nextToken().toInt()
        }
    }
    var answer = Depth(0, 0)
    repeat(n) { x ->
        repeat(m) { y ->
            if (ary[x][y] != 0) {
                val depth = bfs(x, y, ary, n, m)
                if (depth.isGreat(answer)) {
                    answer = depth
                }
            }

        }
    }
    println(answer.answer)
}

val DIRECTION: Array<Pair<Int, Int>> = arrayOf(
    Pair(-1, 0),
    Pair(0, 1),
    Pair(1, 0),
    Pair(0, -1)
)


private fun bfs(x: Int, y: Int, ary: Array<IntArray>, n: Int, m: Int): Depth {
    val list = mutableListOf<Elements>()
    list.add(Elements(x, y))
    val visited = Array(n) { BooleanArray(m) { false } }
    visited[x][y]=true
    var depth = 0
    val start = ary[x][y]
    var answer = Pair(0, 0)
    while (list.isNotEmpty()) {
        val length = list.size
        depth++
        for (index in 0 until length) {
            val element = list.removeFirst()
            for (direction in DIRECTION) {
                val nextX = element.x + direction.first
                val nextY = element.y + direction.second
                if (nextX in 0..<n && nextY in 0..<m && ary[nextX][nextY] != 0) {
                    if (!visited[nextX][nextY]) {
                        visited[nextX][nextY] = true
                        list.add(Elements(nextX, nextY))
                    }
                }
            }
        }
        val temp = findMax(list, ary)
        if (temp != 0) {
            answer = Pair(depth, temp)
        }
    }
    return Depth(start + answer.second, answer.first)
}

private fun findMax(list: MutableList<Elements>, ary: Array<IntArray>): Int {
    var answer = 0
    for (element in list) {
        answer = Math.max(answer, ary[element.x][element.y])
    }
    return answer
}

data class Depth(
    val answer: Int,
    val depth: Int
) {
    // 자신이 더 큼을 표시
    fun isGreat(other: Depth): Boolean {
        if (this.depth > other.depth) {
            return true
        } else if (this.depth == other.depth && this.answer > other.answer) {
            return true
        }
        return false
    }
}

data class Elements(
    val x: Int,
    val y: Int,
)
