import kotlin.math.max

// 09:47 - 11:07

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val ary = IntArray(n)
    repeat(n) {
        ary[it] = readLine().toInt()
    }
    if(n==1){
        println(ary[0])
        return
    }
    else if (n == 2) {
        println(ary[0] + ary[1])
        return
    }
    else if (n == 3) {
        println(max(max(ary[0] + ary[1], ary[0] + ary[2]),ary[1]+ary[2]))
        return
    }

    val dp = IntArray(n)

    dp[0] = ary[0]
    dp[1] = dp[0]+ary[1]
    dp[2] = max(dp[1],max(ary[0]+ary[2],ary[1]+ary[2]))
    for(i in 3 until n){
        // o x o o
        // x o x o
        // . . o x
        dp[i] = max(dp[i-3] + ary[i-1] + ary[i], max(dp[i-2]+ary[i],dp[i-1]))
    }
    println(dp.max())
}
// 연속으로 놓인 3잔을 마실 순 없다.
// N 은 1 ~ 10000 ( ary[n] = 1 ~ 1000 )

// 6 10 13 9 8 1
// 배열 2개?


// 붙어있지 않은 배열 
// 6 10 23 23 31 32

// 이전 값이랑 붙어있는지 안 붙어있는지를 확인
// 이전이 붙어있으면? -> 그냥 넘김
// 붙어있지 않으면? -> 붙임
// 3번 연속이 되면 안된다.

// 붙어있는 배열
// 6 16 16 25 33 33

