""" 
title: Divide Chocolate
link : https://leetcode.com/problems/divide-chocolate

description

하나의 초콜릿이 있다. 이때 각 초콜릿 조각의 당도인 sweetness가 있다. k명의 친구와 함께 나눠 먹을때 내가 먹을 수 있는 최대 당도를 구한다.

최대 당도는 친구들을 제외한 내 초롴릿의 당도가 최소여야 한다.

예를 들어 초콜릿 당도가 [1,2,3,4,5,6,7,8,9]가 있고 k = 5인 상황에서 가능한 나누기는

1 | 2 | 3 | 4 | 5 | 6,7,8,9가있고 이때 내가 먹을 수 있는 당도는 1이다.
당도를 최대화 한 경우는

1,2,3|4,5|6|7|8|9 이며 이때 먹을 수 있는 최소 당도는 6이며 6이 내가 먹을 수 있는 최대 당도이다.

해결 방안

바이너리 서치 문제는 이미 답임을 가정하고 가능과 불가능의 사이를 찾는 상황을 생각해야한다.

최소 당도는 문제의 제약조건을 살펴봤을 때 1이므로 1이다.

최소 당도를 최소한으로 만족하기 위해 나눌 수 있는 경우는 전부 나누어도 1개로 나누어도 전부 가능하다.

최대 당도는 sum(sweetness)로 표현할 수 있다. k = 0 일 경우 (친구 없이 나 혼자 먹을 경우)만 해당되므로
k = 5를 만족하지 않는다.

이렇게 sweetness가 가능한 범위를 log(sum(sweetness))로 찾다 보면 문제를 최적화로 풀 수 있다.
"""

class Solution:
    def maximizeSweetness(self, sweetness: List[int], k: int) -> int:
        # minsweet가 만족하지 않을 경우 -> 더 작게 만들어야 하지
        # minsweet가 만족할 경우 -> 좀 더 크게 해도 되지
        def ispossible(minsweet):
            totalCut = 0
            currentSum = 0
            for s in sweetness:
                currentSum += s
                if currentSum > minsweet:
                    totalCut += 1
                    currentSum = 0
            return totalCut <= k
        left = 1
        right = sum(sweetness)
        while left < right:
            print(right)
            mid = (left + right) // 2
            if ispossible(mid):
                right = mid
            else:
                left = mid + 1
        return right

