package week1

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val ary = Array<MutableList<Int>>(size = n + 1, init = { mutableListOf() })
    val under = Array(size = n + 1) { 0 }

    (1..n).forEach {
        val number = readLine().toInt()
        ary[it].add(number)
        under[it] = number
    }

    val founded = Array(size = n + 1) { false }

    (1..n).forEach {
        val under = under[it]
        if (!founded[under]) {
            find(under, it, ary).forEach { findNode ->
                founded[findNode] = true
            }
        }
    }
    val filtered = (1..n).filter { founded[it] }
    println(filtered.size)
    filtered.forEach { println(it) }
}

// 4 5 6 7
// 7 5 4 6
// 순회를 하며 끝에 원하는 값이 있는지 찾아야 한다. ( 4 -> 7 -> 6 -> 4 )
// 5 -> 5 는 어차피 순회후 바로 끝난다.

private fun find(number: Int, findNumber: Int, ary: Array<MutableList<Int>>): List<Int> {
    val visited = MutableList(ary.size) { false }
    val dq = ArrayDeque<FindMap>()
    dq.add(FindMap(number, listOf(findNumber)))
    visited[number] = true
    while (dq.isNotEmpty()) {
        val next = dq.removeFirst()
        if (next.currentNumber == findNumber) {
            return next.path
        }
        ary[next.currentNumber].forEach { path ->
            if (!visited[path]) {
                visited[path] = true
                dq.add(FindMap(currentNumber = path, path = next.path.plus(next.currentNumber)))
            }
        }
    }
    return listOf()
}

private data class FindMap(
    val currentNumber: Int,
    val path: List<Int>
)
