package week2

import java.util.*

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val ary = IntArray(n)
    val booms = PriorityQueue<Bomb>(compareByDescending { it.power })
    repeat(n) {
        ary[it] = readLine().toInt()
        booms.add(Bomb(it, ary[it]))
    }
    val visited = BooleanArray(n) { false }
    val answers = PriorityQueue<Int>()
    while (!booms.isEmpty()) {
        val bomb = booms.poll()
        if (!visited[bomb.position]) {
            visited[bomb.position] = true
            answers.add(bomb.position)
            action(bomb.position, bomb.power, ary, visited)
        }
    }
    while (answers.isNotEmpty()) {
        println(answers.poll() + 1)
    }
}

// 가장 큰 폭탄을 가져온다.
// 폭탄 주변을 터트린다.
// 그 후, 전파를 한다.

// 50000개, P 10000개

private fun action(index: Int, power: Int, ary: IntArray, visited: BooleanArray) {
    if (check(index - 1, power, ary, visited)) {
        action(index - 1, ary[index-1], ary, visited)
    }
    if (check(index + 1, power, ary, visited)) {
        action(index + 1, ary[index+1], ary, visited)
    }
}

private fun check(index: Int, power: Int, ary: IntArray, visited: BooleanArray): Boolean {
    if (0 > index || index >= ary.size) {
        return false
    }
    if (ary[index] >= power) {
        return false
    }
    if (!visited[index]) {
        visited[index] = true
        return true
    }
    return false
}

data class Bomb(
    val position: Int,
    val power: Int
)

