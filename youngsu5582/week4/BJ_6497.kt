import java.util.*

// 22:00 - 24:11

fun main() = with(System.`in`.bufferedReader()) {
    while (true) {
        val (m, n) = readLine().split(" ").map { it.toInt() }
        if (m == 0 && n == 0) {
            break
        }
        val pq = PriorityQueue(compareBy<Electron> { it.power })

        repeat(n) {
            val st = StringTokenizer(readLine())
            val x = st.nextToken().toInt()
            val y = st.nextToken().toInt()

            val z = st.nextToken().toInt()
            val electron = Electron(x, y, z)
            pq.add(electron)
        }
        val total = pq.sumOf { it.power }

        val visited = IntArray(m) { it }
        // 가장 작은 값을 하되, 그래프를 이루는지
        var answer = mutableListOf<Electron>()
        while (pq.isNotEmpty()) {
            val electron = pq.poll()

            // 조회하는데, 두 개의 같은 조상이 나올 시
            val left = electron.left
            val right = electron.right
            if (union(visited, left, right)) {
                answer.add(electron)
            }
            if (answer.size == m - 1) break
        }

        println(total - answer.sumOf { it.power })
    }
}

private fun union(ary: IntArray, left: Int, right: Int): Boolean {
    val leftIndex = find(ary, left)
    val rightIndex = find(ary, right)

    if (leftIndex == rightIndex) {
        return false
    }
    ary[rightIndex] = leftIndex
    return true
}

private fun find(ary: IntArray, number: Int): Int {
    return if (number == ary[number]) number
    else find(ary, ary[number])
}

data class Electron(
    val left: Int,
    val right: Int,
    val power: Int
)
