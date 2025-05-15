package week6

fun lengthOfLongestSubstring(s: String): Int {
    if(s.length<=1){
        return s.length
    }
    if(s.trim().isBlank()){
        return 1
    }
    var answer = 0
    val visited = IntArray(150){-1}
    var lastIndex = 0
    for(i in 0 until s.length){
        val index = s[i].code
        if(visited[index]!=-1){
            lastIndex = Math.max(visited[index]+1,lastIndex)
        }
        visited[index] = i
        answer = Math.max(answer,i-lastIndex + 1)
    }
    return answer
}
