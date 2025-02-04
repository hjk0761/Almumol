""" 
title: Least Number of Unique Integers after K Removals
link : https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals

description

정수 배열 arr와 양의 정수 k가 주어졌을 때 arr의 원소를 k 번 제거했을 때 남는 최소의 고유 정수 원소 게수를 구해야 한다.

에를들어 arr = [5, 5, 4] / k = 1이면 5를 제거한다면 고유 정수 원소 개수는 [5, 4] = 2 이지만, 4를 제거한다면 5만 남게 되므로 1이며 정답은 1이다.

해결 방안

counter로 원소별 개수를 구한 후 고유 원소 개수가 제일 작은 순으로 제거하는 것이 최소 고유 정수 원소 개수를 구할 수 있다.
"""

from collections import Counter
class Solution:
    def findLeastNumOfUniqueInts(self, arr: List[int], k: int) -> int: 
        counter = Counter(arr)
        ordered = sorted(counter.values(), reverse=True)

        while k:
            val = ordered[-1]
            if val <= k:
                k -= val
                ordered.pop()
            else:
                break
        return len(ordered)
