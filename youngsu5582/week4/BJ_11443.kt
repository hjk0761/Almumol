// 21:28 - 23:32

fun main() = with(System.`in`.bufferedReader()) {
    val fibo = Fibo(Pair(1, 1), Pair(1, 0))
    var n = readLine().toLong()
    if ((n % 2).toInt() == 0) n += 1

    println(pow(fibo, n).second.first-1)
}

fun pow(value: Fibo, exp: Long): Fibo {
    if (exp.toInt() == 1) {
        return value
    } else if (exp.toInt() == 0) {
        return Fibo(Pair(0, 0), Pair(0, 0))
    }
    val result = pow(value, exp / 2)
    return if (exp % 2 == 1L) {
        mul(mul(result, result), value)
    } else {
        mul(result, result)
    }
}

fun mul(first: Fibo, second: Fibo): Fibo {
    val f = (first.first.first * second.first.first + first.first.second * second.second.first)%MOD
    val s = (first.first.first * second.first.second + first.first.second * second.second.second)%MOD
    val t = (first.second.first * second.first.first + first.second.second * second.second.first)%MOD
    val four = (first.second.first * second.first.second + first.second.second * second.second.second)%MOD
    return Fibo(Pair(f, s), Pair(t, four))
}

const val MOD = 1_000_000_007
val ary: Array<IntArray> = arrayOf(intArrayOf(1, 1), intArrayOf(1, 0))

data class Fibo(
    val first: Pair<Long, Long>,
    val second: Pair<Long, Long>
)
//피보나치 적용 + 짝수
//어마어마하게 큰 수 처리

// 0 1 2 3 4 5 6 7 8 9 10
// 0 1 1 2 3 5 8 13 21 34 55 89

// 8 + 3 + 1 + 0 = 12
// 55 + 21 + 8 + 3 + 1 = 88

// 홀수일 시 , 7 -> 6의 값 13 -1 = 12
// 짝수일 시, 10 -> 10의 값 -1 = 88
// 그전값 -1
// 그다음값 -1

// 6과,7은 동일
//

