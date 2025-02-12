fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    repeat(t) {
        val n = readLine().toInt()
        val students = readLine().split(" ").map { it.toInt() }.toMutableList()

        // 임의 숫자 - Index 1 맞추기 위함
        students.add(0, -1)
        var answer = 0
        val visited = BooleanArray(n + 1) { false }
        for (i in 1 until students.size) {
            if(i==students[i]){
                answer++
                visited[i] = true
            }
        }

        for (i in 1 until students.size) {
            if (visited[i]) continue
            var next = students[i]
            val graph = mutableListOf<Int>()
            while (next != i) {
                if (visited[next]) {
                    graph.add(next)
                    break
                }
                visited[next] = true
                graph.add(next)
                next = students[next]
            }

            if (next == i) {
                visited[next] = true
                // 자신을 포함시키기 위해 + 1
                answer += graph.size + 1
            } else {
                val index = graph.indexOf(next)
                // 맨 마지막에 자신을 추가했으므로 -1
                answer+=graph.size-index-1
            }
        }
        println(n - answer)
    }
}

// 4 -> 7
// 7 -> 6
// 6 -> 4

// first:4, next: 7
// 

// first 가 next 랑 같을때까지
// 
