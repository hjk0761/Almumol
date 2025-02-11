import java.util.*


// 12:26 -
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val a = IntArray(n)
    val b = IntArray(n)
    val c = IntArray(n)
    val d = IntArray(n)
    repeat(n) {
        val st = StringTokenizer(readLine())
        a[it] = st.nextToken().toInt()
        b[it] = st.nextToken().toInt()
        c[it] = st.nextToken().toInt()
        d[it] = st.nextToken().toInt()
    }
    val (ab, cd) = merge(a, b, c, d)

    var count = 0L

    var left = 0
    var right = cd.size - 1
    while (left < cd.size && right >= 0) {
        val leftValue = ab[left]
        val rightValue = cd[right]
        val result = leftValue + rightValue
        if (result > 0) {
            right--
        } else if (result < 0) {
            left++
        } else {
            val (abIndex, abCount) = mulPositive(ab, left)
            val (cdIndex, cdCount) = mulNegative(cd, right)
            left = abIndex
            right = cdIndex
            count += abCount.toLong() * cdCount.toLong()
            // 똑같은게 없으면 그 자리에서 멈춤
            left++
        }
    }
    println(count)
}

private fun mulPositive(ab: IntArray, abIndex: Int): Pair<Int, Int> {
    var index = abIndex
    var count = 1
    while (index+1 < ab.size && ab[index] == ab[index + 1]) {
        count++
        index++
    }
    return Pair(index, count)
}

private fun mulNegative(cd: IntArray, cdIndex: Int): Pair<Int, Int> {
    var index = cdIndex
    var count = 1
    while (index > 0 && cd[index] == cd[index - 1]) {
        count++
        index--
    }
    return Pair(index, count)
}

fun merge(first: IntArray, second: IntArray, third: IntArray, fourth: IntArray): Pair<IntArray, IntArray> {
    val size = first.size

    val ab = IntArray(size*size)
    val cd = IntArray(size*size)
    var index = 0
    for (i in 0 until size) {
        for (j in 0 until size) {
            ab[index]=first[i] + second[j]
            cd[index++] = third[i] + fourth[j]
        }
    }
    ab.sort()
    cd.sort()
    return Pair(ab, cd)
}

// 4000 * 4 = 16000

// 6
// -45 22 42 -16
// -41 -27 56 30
// -36 53 -37 77
// -36 30 -75 -46
// 26 -38 -10 62
// -32 -54 -6 45

//  A + B <-> C + D
//
