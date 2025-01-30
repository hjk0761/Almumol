package week3

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val ary = IntArray(Math.max(n+1,3))
    ary[1]= 1
    ary[2]= 2

    for(i in 3..n){
        ary[i] = (ary[i-2] + ary[i-1]) % 10007
    }
    println(ary[n])
}

// 1칸 : 1
// 2칸 : 2
// 3칸 : 3
// 21 : 2
// 111 : 1

// 4칸 : 5
// 22 : 1
// 211 : 3
// 1111 : 1

// 5칸 : 8 
// 221 : 3
// 2111 : 4
// 11111 : 1

// 6칸 : 13
// 222
// 111111
// 2211 : 6
// 1122, 1212, 1221, 2121, 2211, 2112
// 21111 : 5

// 18 : 4181
// 19 : 6765
// 20 : 10946
