import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val visited = IntArray(n + 1)
    repeat(n + 1) {
        visited[it] = it
    }
    val sb = StringBuilder()
    repeat(m) {

        val st = StringTokenizer(readLine())
        val command = st.nextToken().toInt()
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        if (command == 0) {
            // 더 큰쪽이 작은쪽으로 향하게
            // 3 -> 1
            val aParent = find(a, visited)
            val bParent = find(b, visited)
            if (aParent > bParent) {
                visited[aParent] = bParent
            } else {
                visited[bParent] = aParent
            }
        } else {
            if (unionFind(a, b, visited)) {
                sb.append("YES")
            } else {
                sb.append("NO")
            }
            sb.append("\n")
        }
    }
    println(sb)
}

private fun unionFind(a: Int, b: Int, ary: IntArray): Boolean {
    val aIndex = find(a, ary)
    val bIndex = find(b, ary)
    return aIndex == bIndex
}

private fun find(num: Int, ary: IntArray): Int {
    if (ary[num] == num) return num
    ary[num] = find(ary[num], ary)
    return ary[num]
}

