import java.util.*

// 16:20 - 45

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val st = StringTokenizer(readLine())
    val pq = PriorityQueue<Matrocika>(compareBy { it.height })
    repeat(n) {
        pq.add(Matrocika(st.nextToken().toInt()))
    }


    // 자동 정렬
    val list = mutableListOf<Matrocika>()
    // 처음값 추가
    list.add(pq.poll())
    while (pq.isNotEmpty()) {
        val matrocika = pq.poll()
        val first = list.first()

        // 무조건 작은값 순인게 보장되므로
        if (first.height == matrocika.height) {
            list.add(matrocika)
            continue
        }
        list.removeFirst()
        list.add(matrocika)
    }
    println(list.size)
}

data class Matrocika(
    val height: Int,
)


// i,j 번째 a[i] < a[j]
// 남아있는 마트로시카는 줄어듬.

// 7
// 3 3 4 5 2 2 3

// 2 2 3 3 3 4 5

// -> 3 4 5 , 2 3, 2, 3

// 속이 차있으면, 불가능

// 속이 차있는지, 없는지 판별

// 계속해서 반복

// 정렬하므로, 최소 -> 다음 을 보장한다.
