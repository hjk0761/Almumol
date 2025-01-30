package week3

private fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    repeat(t) {
        val n = readLine().toInt()
        val ary = IntArray(Math.max(n + 1, 4))
        ary[1] = 1
        ary[2] = 2
        ary[3] = 4
        for (i in 4..n) {
            ary[i] = ary[i - 1] + ary[i - 2] + ary[i - 3]
        }
        println(ary[n])
    }
}

// 1 : 1
// 2 : 2
// 3 : 4
// 111, 1 2,2 1,3
// 4 : 7
// 5 : 13
// 6 : 24
// 7 : 42
// 8 : 78
// 9 : 145
// 10 : 274

// 11111

// 113
// 131
// 311

// 1112
// 1121
// 1211
// 2111

// 122
// 212
// 221

// 23
// 32

// 3 + 3 + 4 + 3 = 13

// 111111
// 33
// 222

// 1122
// 1212
// 1221
// 2121
// 2211
// 2112

// 1311
// 3111
// 1131
// 1113

// 123
// 132
// 213
// 231
// 312
// 321

// 11112
// 11121
// 11211
// 12111
// 21111

// 6 : 24

// 3 + 6 + 4 + 6 + 5 = 24

// 6 : 24
// 7 : 40
