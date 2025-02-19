package week5

fun solution(fees: IntArray, records: Array<String>): IntArray {

    val defaultMinute = fees[0]
    val defaultPrice = fees[1]
    val unitTime = fees[2]
    val unitPrice = fees[3]

    val visited = mutableMapOf<Int, Int>()
    val totaled = mutableMapOf<Int, Int>()

    for (record in records) {
        val temp = record.split(" ")
        val time = convertInt(temp[0])
        val carNumber = temp[1].toInt()
        val status = temp[2]

        if (status == "IN") {
            visited.put(carNumber, time)
        } else {
            val prevTime = visited.get(carNumber)!!
            val totalTime = totaled.getOrDefault(carNumber, 0)
            visited.put(carNumber, 1439)
            totaled.put(carNumber, totalTime + time - prevTime)
        }
    }
    for (carNumber in visited.keys) {
        val prevTime = visited.get(carNumber)!!
        val totalTime = totaled.getOrDefault(carNumber, 0)
        totaled.put(carNumber, totalTime + 1439 - prevTime)
    }

    val answer = mutableListOf<Int>()

    for (sortedKey in totaled.keys.sorted()) {
        val totalTime = totaled.get(sortedKey)!!
        if (totalTime <= defaultMinute) {
            answer.add(defaultPrice)
        } else {

            val count = calculateTime(totalTime - defaultMinute, unitTime)
            // println("$totalTime\t$defaultMinute\t$sortedKey\t$count")
            answer.add(defaultPrice + count * unitPrice)
        }

    }

    return answer.toIntArray()
}

private fun calculateTime(time: Int, unit: Int): Int {
    return if (time % unit == 0) time / unit
    else time / unit + 1
}

private fun convertInt(time: String): Int {
    val temp = time.split(":").map { it.toInt() }
    return temp[0] * 60 + temp[1]
}


