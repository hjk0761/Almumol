// 막대 자석 문자열에 등장하는 N의 개수와 S의 개수 동일

// 문자열의 앞쪽 절반을 구성하는 문자는 모두 N이거나 모두 S

// 주어진 문자열의 부분 문자열 중에서 가장 긴 막대 자석 문자열의 길이를 출력한다. 만약 막대 자석 문자열을 찾을 수 없다면, 대신 0을 출력

// 1 <= K <= 300 000

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val magnet = readLine()


    // 
    // 굳이 알 필요 있는가?
    val memorization = IntArray(n) { 1 }

    for (i in 1 until n) {
        // 이전과 동일하다면
        if (magnet[i] == magnet[i - 1]) {
            memorization[i] = memorization[i - 1] + 1
        }
    }
    var max = 0
//    println(memorization.contentToString())
    for (i in 1 until n) {
        // 자기꺼에서 그전꺼로 넘어감
        // SS 와 같이 2 연속시?
        // 2가 빠져서 그전 요소
//        println(i)
//        println(memorization[i])
        val prevIndex = i - memorization[i]
        // 0일 경우 그 이전으로 돌아가면 예외 발생
        if(prevIndex<0){
            continue
        }
        val m = magnet[prevIndex]
        if (m != magnet[i]) {
            // 이전 index
            val prev = memorization[prevIndex]
            if (prev < 0) {
                continue
            }
            if (prev >= memorization[i]) {
                max = Math.max(memorization[i] * 2, max)
            }
        }
    }

    println(max)
}

//DP?

// 자기 그전에 몇개 있는지를 메모리제이션
// S 체크 -> 인덱스 2개 빼고 -> N 2개인지 체크 ?
// => 2n
