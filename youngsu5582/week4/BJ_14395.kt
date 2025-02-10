package week4

// 11:19 - 12:01

val max = 100000_0000L
// * -> + -> - -> /

fun main() = with(System.`in`.bufferedReader()) {
    val (s, t) = readLine().split(" ").map { it.toLong() }
    val dq = mutableListOf<Operation>()
    dq.add(Operation(s, StringBuilder()))
    val visited = mutableMapOf<Long, Boolean>()

    if (s == t) {
        println(0)
        return
    }

    val minus_number = 0L
    val div_number = 1L

    while (dq.isNotEmpty()) {
        val (number, sb) = dq.removeFirst()
        val plus_number = number + number
        val mul_number = number * number
        if (number == t) {
            println(sb)
            return
        }

        if (visited.containsKey(mul_number).not()) {
            visited[mul_number] = true
            dq.add(Operation(mul_number, sb.newWithChar('*')))
        }
        if (visited.containsKey(plus_number).not()) {
            visited[plus_number] = true
            dq.add(Operation(plus_number, sb.newWithChar('+')))
        }
        if (visited.containsKey(minus_number).not()) {
            visited[minus_number] = true
            dq.add(Operation(minus_number, sb.newWithChar('-')))
        }

        if (visited.containsKey(div_number).not()) {
            visited[div_number] = true
            dq.add(Operation(div_number, sb.newWithChar('/')))
        }
    }
    println(-1)
}

data class Operation(
    val number: Long,
    val sb: StringBuilder
)

fun StringBuilder.newWithChar(char: Char): StringBuilder {
    return StringBuilder(this).append(char)
}

//512MB

// s = s + s
// s = s - s
// s = s * s
// s = s / s

// 14
// 196

// 1 10000000
// 2 4 8 64 128 256
