package week7

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    repeat(t) {
        val n = readLine().toInt()

        val experience = calculate(n.toLong())
        var left = 0
        var right = 1000_000_000
        while (left <= right) {
            val mid = (left + right) / 2
            val needExperience = mid * (mid - 1).toLong()

            if (needExperience > experience) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        println(left - 1)
    }
}

private fun calculate(n: Long): Long {
    return n * (n + 1) / 2
}

// 유저가 지금까지 처치한 슬라임 수를 x라 할 때, 새로운 슬라임을 처치하면 x + 1 만큼의 경험치

// 레벨업 시 y를 소모한 뒤, 다음 레벨 업에 필요한 경허치는 y + 2 이다.
//레벨 1일 경우 경험치 2

// 11마리
// 1 2 3 4 5 6 7 8 9 10 11
// -> 66 

// 10마리
// -> 55

// 1 2 3 4 5 6 7 8
// 2 -> 4 -> 6 -> 8 -> 10 -> 12 -> 14 -> 16
// 72
