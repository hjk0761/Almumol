// 09:35 - 10:15

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (n, d) = readLine().split(" ").map { it.toInt() }
    val monster = mutableListOf<Long>()
    val equip = mutableListOf<Long>()


    repeat(n) {
        val st = StringTokenizer(readLine())
        val command = st.nextToken().toInt()
        val info = st.nextToken().toLong()
        if (command == 1) {
            monster.add(info)
        } else {
            equip.add(info)
        }
    }

    monster.sort()
    equip.sort()

    var count = 0
    var human = d.toLong()
    while (monster.isNotEmpty() || equip.isNotEmpty()) {
        // 몬스터 방 조회
        if (monster.isNotEmpty()) {
            val mon = monster.removeFirst()
            if (isWin(mon, human)) {
                human += mon
                count++
                continue
            }
            // 못이기시 장비 조회 - 이길때까지 계속 조회 해야 한다.
            while (equip.isNotEmpty()) {
                val e = equip.removeFirst()
                human *= e
                count++
                if (isWin(mon, human)) {
                    human += mon
                    count++
                    break
                }
            }
            if(isWin(mon,human).not()) {
                break
            }
            continue
        }
        if (equip.isNotEmpty()) {
            human *= equip.removeFirst()
            count++
        }
    }
    println(count)
}


private fun isWin(monster: Long, human: Long): Boolean {
    return monster < human
}


// 방의 수 : 100000, 시작 전투력 : 10^9

// 1 : 몬스터
// 2 : 장비

// 몬스터의 전투력과 같거나 작을경우 패배

// 몬스터보다 전투력 크면 승리, 전투력에 몬스터 전투력 추가
// 장비는 전투력에 상관 없이 얻으며, 곱해진다.
// 전투력이 작은 모든 장비를 얻어야만 현 장비 얻을 수 있다.

// 몬스터의 방 순서는 크게 상관 없다.
// 장비의 방 순서는 중요하다.

// 8 3

// 2 4 10 50 264 999
// 5 7

// 5 9 45 55 105 735 999
