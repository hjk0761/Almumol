""" 
title: Koko Eating Bananas
link : https://leetcode.com/problems/koko-eating-bananas/description

description

코코는 바나나를 좋아한다. 배열 piles 안에는 각 pile안에 바나나 개수가 저장되어 있다. 

코코는 1시간 마다 piles안에 있는 k 개의 바나나를 먹을 수 있다. 이때 전체 시간 h가 주어질때 코코가 piles안에 있는 바나나를 전부먹을 수 있는 최소한의 값을 구하자.

해결 방안

1. 단계적 접근

- k의 최소값과 최대값은 무엇인가? 
k는 적어도 1이다. k = 0 일경우 바나나를 어떤 시간을 들여도 먹을 수 없기 때문이다.
k는 최대 max(piles)이다. k가 무한대가 될수도 있지만 max(piles)값만 되어도 충분히 제시간안에 모든 바나나를 먹을 수 있기 때문이다.
제한된 시간 h가 주어졌으므로 각 h 이하의 시간을 유지하면서 바나나를 전부 먹을 수 있어야 한다.
k = 2 pile = 5 일 경우 바나나는 2 + 2 + 1 이므로 3시간이 걸리게 된다. 

k 범위가 1 이상 max(piles)이하인 수에 대해서 각 pile안에 있는 바나나를 먹는데 걸리는 시간이 h이하를 만족하면 탐색범위 절반으로 줄이는식으로 바이너리 서치를 구현하면 되겠다.
"""

class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        def check(k):
            hours = 0
            for pile in piles:
                hours += ceil(pile / k) # k = 2 pile =5 일때 올림(ceil)을 해야 제대로 된 시간이 나오므로
            return hours <= h
        left = 1
        right = max(piles)
        while left < right:
            mid = (left + right) // 2
            if check(mid):
                right = mid
            else:
                left = mid + 1
        return left
