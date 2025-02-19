package week5

fun solution(begin: String, target: String, words: Array<String>): Int {
    var answer = 0

    // 문자열의 순서 캐싱

    // 순서에 해당하는 값 visited 인지 확인
    var count = 0
    val cacheMap = mutableMapOf<String, Int>()
    for (index in words.indices) {
        cacheMap[words[index]] = index
    }
    val queue = ArrayDeque<String>()
    val visited = BooleanArray(words.size)
    queue.add(begin)
    while (queue.isNotEmpty()) {
        repeat(queue.size) {
            val element = queue.removeFirst()
            if (element == target) {
                return count
            }
            words.forEachIndexed { wordIndex, word ->
                if (visited[wordIndex].not() && checkRule(element, word)) {
                    visited[wordIndex] = true
                    queue.add(word)
                }
            }
        }
        count++
    }
    return 0
}

private fun checkRule(a: String, b: String): Boolean {
    return a.indices.count { a[it] != b[it] } == 1
}

data class Element(
    val word: String,
    val visited: BooleanArray
)
