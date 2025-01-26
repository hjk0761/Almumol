package week2

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val ary = IntArray(n)
    repeat(n) {
        ary[it] = readLine().toInt()
    }
    val min = ary.min()
    ary[ary.indexOf(min)] = Int.MAX_VALUE
    val numbers = PriorityQueue<Int>()
    ary.forEach {
        numbers.add(concatToInt(it, min))
        numbers.add(concatToInt(min, it))
    }
    numbers.poll()
    numbers.poll()
    println(numbers.poll())
}

private fun concatToInt(a: Int, b: Int): Int {
    if (a == Int.MAX_VALUE || b == Int.MAX_VALUE) {
        return Int.MAX_VALUE
    }
    return (a.toString() + b.toString()).toInt()
}

// 제일 작은거 하나는 진작 뺌
// 작은거 앞에 or 뒤에 해서 우선순위 넣음

// 3개선에서 끝 ( ? )
//
