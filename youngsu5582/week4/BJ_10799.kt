// 09:20 - 09:44

fun main() = with(System.`in`.bufferedReader()) {
    val line = readLine()
    val array = line.toCharArray()
    val stack = mutableListOf<Char>()

    var prev = array[0]
    stack.add(prev)
    var piece = 0
    for (i in 1 until array.size) {
        val value = array[i]
//        println("$prev\t$value\t$stack\t$piece")
        if (value == ')' && prev == '(') {
            stack.removeLast()
            piece += stack.size
        } else if (value == ')') {
            piece++
            stack.removeLast()
        } else {
            stack.add(value)
        }
        prev = value
    }
    println(piece)
}


// ( 와 ) 가 바로 나오면 레이저이다.
// 그전이 ) 인데 )가 나오면 하나의 막대기가 끝난 것이다.
// 끝날때도 +1 해줘야 한다.
