package week2

import java.util.*
import kotlin.math.min

private fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    val aSt = StringTokenizer(readLine())
    val bSt = StringTokenizer(readLine())

    val pq = PriorityQueue<Grade>()

    repeat(m) {
        val default = aSt.nextToken().toInt()
        val performance = bSt.nextToken().toInt()
        pq.add(Grade(default, performance))
    }
    var time = n * 24

    var answer = 0
    while (time > 0 && pq.isNotEmpty()) {
        val grade = pq.poll()
        if (grade.default == 100) {
            answer += 100
            continue
        }
        val useTime = min(grade.calculate(), time)
        time -= useTime
        pq.add(grade.study(useTime))
    }
    val sum = pq.sumOf { it.default }
    println(answer + sum)
}

data class Grade(
    val default: Int,
    val performance: Int
) : Comparable<Grade> {
    fun calculate(): Int {
        return (100 - default) / performance
    }

    fun study(time: Int): Grade {
        val newGrade = default + time * performance
        return Grade(newGrade, 100 - newGrade)
    }

    override fun compareTo(other: Grade): Int {
        return other.performance.compareTo(performance)
    }
}

