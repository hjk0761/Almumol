import java.util.*
import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    var list = mutableListOf<Human>()
    repeat(n) {
        val (h, o) = readLine().split(" ").map { it.toInt() }
        if (h < o) list.add(Human(h, o))
        else list.add(Human(o, h))
    }

    val d = readLine().toInt()

    // 정렬
    list.sortWith(compareBy({ it.right }, { it.left }))

    var answer = 0
    // 오른쪽값이 무조건 제일 작은 값임을 보장한다.
    // 오름차순 정렬

    val pq = PriorityQueue<Int>()
    for (i in 0 until n) {
        val element = list[i]
        // 왼쪽값을 게속 추출
        while (pq.isNotEmpty() && pq.peek() < element.right - d) {
            pq.poll()
        }
        if (element.left >= element.right - d) {
            pq.add(element.left)
        }
        answer = max(answer, pq.size)
    }
    println(answer)
}

// -1억 ~ 1억 
data class Human(val left: Int, val right: Int) {
}



