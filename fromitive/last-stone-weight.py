"""  
title : Last Stone Weight
link  : https://leetcode.com/problems/last-stone-weight

description

돌맹이들의 무게들이 기록되어 있는 stones배열이 주어진다. 이때 아무 돌맹이 두개를 꺼낼 수 있다.
돌맹이들이 부딧힐때 무게가 같으면 두 돌맹은 사라지고, 무게가 다를 경우 무게가 큰 돌맹이에서 무게가 작은 돌맹이의 무게만큼 없어진 돌맹이가 생긴다.
이때 최종적으로 남은 돌맹이의 무게를 구한다.

해결 방안

무게를 효율적으로 없애려면 힙 자료구조를 사용할 수 있다. 가장 큰 돌맹이 2개를 부딧혀 남은 돌맹이를 다시 넣는 작업을 돌맹이 1개가 남을때까지 반복한다. 
"""

import heapq
class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        # max heap
        stones = [ -stone for stone in stones ]
        heapq.heapify(stones)
        while len(stones) > 1:
            first = - abs(heapq.heappop(stones))
            second = - abs(heapq.heappop(stones))
            if first != second:
                heapq.heappush(stones, - abs(first - second))
            
        return -stones[0] if len(stones) > 0 else 0