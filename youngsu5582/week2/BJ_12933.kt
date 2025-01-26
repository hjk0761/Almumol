package week2

import kotlin.math.max

private fun main() = with(System.`in`.bufferedReader()) {
    val sound = readLine()
    val ducks = mutableListOf<Duck>()
    var maxDuckSize = 0
    for (noise in sound) {
        if (noise == 'q') {
            ducks.add(Duck())
            continue
        }
        maxDuckSize = max(ducks.size, maxDuckSize)


        val duck = findDuck(ducks, noise)
        if (duck == null) {
            maxDuckSize = -1
            break
        }
        duck.add(noise)
        if (duck.isFinish()) {
            ducks.remove(duck)
        }
    }
    if (ducks.size != 0) {
        println(-1)
    } else {
        println(maxDuckSize)
    }
}

private fun findDuck(mutableList: MutableList<Duck>, word: Char): Duck? {
    return mutableList.find { it.check(word) }
}

// q 이면 바로 추가
// 나머지는 찾아서 add
// 찾지 못할 시 -1 종료

// q u a c k

// quackquacquaquqkckackuack
data class Duck(
    val mutableList: MutableList<Char>
) {
    constructor() : this(mutableListOf('q'))

    fun check(word: Char): Boolean {
        return mutableList.size == MAP[word]
    }

    fun add(word: Char) {
        mutableList.add(word)
    }

    fun isFinish(): Boolean {
        return mutableList.size == 5
    }

    companion object {
        val MAP: Map<Char, Int> = mapOf(Pair('q', 0), Pair('u', 1), Pair('a', 2), Pair('c', 3), Pair('k', 4))
    }
}


