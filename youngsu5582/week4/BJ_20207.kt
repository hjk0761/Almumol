package week4

// 22:40 -

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val scheduleList = mutableListOf<Schedule>()
    repeat(n) {
        val (s, e) = readLine().split(" ").map { it.toInt() }
        scheduleList.add(Schedule(s, e))
    }
    val sorted = scheduleList.sortedWith(compareBy<Schedule> { it.start }.thenByDescending { it.end })
    var schedules = mutableListOf<Schedules>()
    var answer = 0
    for (e in sorted) {
        if (schedules.isEmpty()) {
            schedules.add(createNewSchedules(e))
            continue
        }

        var maxRight = 0
        for (schedule in schedules) {
            maxRight = Math.max(maxRight, schedule.right)
        }
        var added = false

        // 기존에서 추가될 수 있는 경우
        for (schedule in schedules) {
            if (schedule.check(e) && e.start <= maxRight + 1) {
                schedule.add(e)
                added = true
                break
            }
        }

        if (added) {
            continue
        }

        if (e.start <= maxRight) {
            schedules.add(createNewSchedules(e))
            continue
        } else {
            answer += calculate(schedules)
            schedules = mutableListOf(createNewSchedules(e))
        }
    }
    println(answer + calculate(schedules))
}

private fun calculate(schedules: List<Schedules>): Int {
    var maxLeft = Int.MAX_VALUE
    var maxRight = Int.MIN_VALUE
    for (schedule in schedules) {
        maxLeft = Math.min(maxLeft, schedule.left)
        maxRight = Math.max(maxRight, schedule.right)
    }
    return (maxRight - maxLeft + 1) * schedules.size
}

private fun createNewSchedules(schedule: Schedule) = Schedules(mutableListOf(schedule), schedule.start, schedule.end)


data class Schedule(
    val start: Int,
    val end: Int
) {
    fun include(other: Schedule): Boolean {
        return other.start <= this.end
    }
}

data class Schedules(
    val scheduled: MutableList<Schedule>,
    val left: Int,
    var right: Int
) {
    fun check(schedule: Schedule): Boolean {
        return this.right + 1 <= schedule.start
    }

    fun add(schedule: Schedule) {
        this.right = Math.max(this.right, schedule.end)
        this.scheduled.add(schedule)
    }
}
