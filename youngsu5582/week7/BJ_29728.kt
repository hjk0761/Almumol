package week7

// 15:00 - 15:17
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val primes = createPrimes(n)
    // 0은 S, 1은 B
    val ary = ArrayDeque<Int>()

    // true 일시 오른쪽, false 일시 왼쪽
    var flag = true
    for (i in 1..n) {
        if (primes[i]) {
            change(ary, flag)
            add(ary, flag, 0)
            flag = !flag
        } else {
            add(ary, flag, 1)
        }
    }
    println("${ary.count { it == 1 }} ${ary.count { it == 0 }}")
}

private fun createPrimes(number: Int): BooleanArray {
    val array = BooleanArray(number + 1) { true }
    array[1] = false
    for (i in 2 until Math.sqrt(number.toDouble()).toInt() + 1) {
        if (array[i]) {
            var j = 2
            while (i * j <= number) {
                array[i * j++] = false
            }
        }
    }
    return array
}

private fun change(ary: MutableList<Int>, flag: Boolean) {
    if (flag && ary.last() == 1) {
        ary[ary.size - 1] = 0
        return
    }
    if (flag.not() && ary.first() == 1) ary[0] = 0
}

private fun add(ary: MutableList<Int>, flag: Boolean, number: Int) {
    if (flag) ary.addLast(number)
    else ary.addFirst(number)
}
