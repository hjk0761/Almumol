class Solution {
    fun solution(citations: IntArray): Int {
        return (0..1000)
            .reversed()
            .first { h ->
                citations.count {
                    it >= h
                } >= h
            }
    }
}