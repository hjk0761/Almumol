// 14:19 - 14:24

fun main() = with(System.`in`.bufferedReader()) {
    val k = readLine().toInt()
    val stack = mutableListOf<Int>()
    repeat(k) {
        val num = readLine().toInt()
        if (num == 0) stack.removeLast()
        else stack.add(num)
    }
    println(stack.sum())
}


// 정수는 0에서 1,000,000 사이의 값을 가지며, 정수가 "0" 일 경우에는 가장 최근에 쓴 수를 지우고, 아닐 경우 해당 수를 쓴다.
// 정수가 "0"일 경우에 지울 수 있는 수가 있음을 보장할 수 있다.
