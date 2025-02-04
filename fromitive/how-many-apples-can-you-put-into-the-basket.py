""" 
title: How Many Apples Can You Put into the Basket
link : https://leetcode.com/problems/how-many-apples-can-you-put-into-the-basket

description

사과 무게 정보가 들어있는 배열 weight가 주어진다. 이때 무게가 5000 안으로 최대로 담을 수 있는 사과의 개수를 구한다.
"""

class Solution:
    def maxNumberOfApples(self, weight: List[int]) -> int:
        weight.sort()
        answer = 0
        totalWeight = 5000
        i = 0
        while i < len(weight) and totalWeight > 0:
            if totalWeight < weight[i]:
                break
            totalWeight -= weight[i]
            answer += 1
            i += 1
        return answer
