package week1;

private fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val s = readLine().toInt()
    if (s % 4763 != 0) {
        println("0")
        return
    }
    val findNumber = s / 4763
    findNumbers(findNumber)
}

private fun findNumbers(findNumber: Int) {
    val list = mutableListOf<Score>()
    for (i in 0..200) {
        for (j in 0..200) {
            if (findNumber == i * 508 + j * 212 ||
                findNumber == i * 108 + j * 212 ||
                findNumber == i * 508 + j * 305 ||
                findNumber == j * 108 + i * 305
            ) {
                list.add(Score(i, j))
            }
        }
    }

    println(list.size)
    list.forEach {
        println("${it.english} ${it.science}")
    }
}

data class Score(
    val english: Int,
    val science: Int
) {

}
// 19:55

// if : 국어 점수 > 영어 점수 -> 두 점수 차 * 508
// else : 두 점수 차 * 108

// if 수학 > 탐구 : 두 점수 차 * 212
// else : 두 점수 차 & 305

// 두 값 더한 후, * 4763

// 가능한 모든 수
// 국어, 수학, 영어, 탐구
// 0 ~ 200 사이 표준점수

// S 는 0<=  ~ <= 200
// 국어 - 영어 차 낮은 순서대로 정렬
