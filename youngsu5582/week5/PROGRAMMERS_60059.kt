package week5

fun solution(key: Array<IntArray>, lock: Array<IntArray>): Boolean {

    var keyClone = key
    val offset = key.size - 1

    val expandSize = lock.size * 2 - 1

    for (i in 0 until expandSize) {
        for (j in 0 until expandSize) {
            repeat(4) {
                // 자물쇠 본뜸
                val ary = Array(58) { IntArray(58) }
                for (x in lock.indices) {
                    for (y in lock.indices) {
                        ary[offset + x][offset + y] = lock[x][y]
                    }
                }
                // KEY 대입
                for (x in i until i + key.size) {
                    for (y in j until j + key.size) {
                        ary[x][y] += keyClone[x - i][y - j]
                    }
                }
                if (check(ary, offset, lock.size)) {
                    return true
                }
                keyClone = rotate(keyClone)
            }
        }
    }
    return false
}

private fun check(ary: Array<IntArray>, offset: Int, size: Int): Boolean {
    for (x in 0 until size) {
        for (y in 0 until size) {
            if (ary[offset + x][offset + y] != 1) {
                return false
            }
        }
    }
    return true
}

private fun rotate(key: Array<IntArray>): Array<IntArray> {
    val size = key.size
    val tmp_arr = Array<IntArray>(size) { IntArray(size) }
    for (i in 0 until size) {
        for (j in 0 until size) {
            tmp_arr[j][size - 1 - i] = key[i][j]
        }
    }
    return tmp_arr
}
