fun String.findAllSubStrings(length: Int): List<String> =
    (0..this.lastIndex - length + 1)
        .map { this.substring(it, it + length) }
        .toList()

class Solution {
    fun solution(t: String, p: String): Int {
        return t.findAllSubStrings(p.length).map {
            it.toLong()
        }.count { it <= p.toLong() }
    }
}