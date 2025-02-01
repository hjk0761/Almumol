package week2

import java.util.*

// 36분
// 시간 소요를 줄이기 위해 subList 대신 sliding window 를 만들자.
private fun main() = with(System.`in`.bufferedReader()) {
    val q = readLine().toInt()
    var ary = IntArray(500000)
    val result = StringBuilder()

    var startIndex = 0
    var endIndex = 0
    repeat(q) {
        val st = StringTokenizer(readLine())
        val command = st.nextToken().toInt()
        if (command == 1) {
            val number = st.nextToken().toInt()
            ary[endIndex++] = number
        } else {
            val mid = (startIndex + endIndex) / 2
            val left = sum(ary, startIndex, mid)
            val right = sum(ary, mid, endIndex)
            if (left <= right) {
                result.append(left).append("\n")
                startIndex = mid
            } else {
                result.append(right).append("\n")
                endIndex = mid
            }
        }
    }
    for (i in startIndex until endIndex) {
        result.append(ary[i]).append(' ')
    }
    println(result.toString().trimEnd())
}

// subList 가 아니라 배열을 덮자

private fun sum(ary: IntArray, start: Int, end: Int): Int {
    var total = 0
    for (i in start until end) {
        total += ary[i]
    }
    return total
}

// 1 : 배열 가장 뒤 정수 x 삽입
// 2 : 앞 N / 2개 원소, 뒤 N / 2개 원소 나눈후, 합이 더 작은 부분 배열에서 삭제 후 합을 출력
