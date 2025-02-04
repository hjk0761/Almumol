""" 
title : Minimum Operations to Halve Array Sum
link  : https://leetcode.com/problems/minimum-operations-to-halve-array-sum

description

숫자 배열 nums가 있다. nums에 있는 숫자를 아무거나 선택할 수 있고 해당 숫자를 절반으로 만들 수 있다.

nums에 있는 숫자를 전부 더한 합이 절반이 될 때까지 nums에 있는 숫자를 뽑아 절반으로 만들어야 하는 최소 횟수를 구하라.

해결 방안

최소 횟수를 구하기 위해서는 매번 가장 큰 횟수를 절반으로 만들어야 한다. 이때 힙을 사용할 수 있으며, 삽입, 탐색이 O(logN)의 시간복잡도를 만족한다.
"""
import heapq
class Solution:
    def halveArray(self, nums: List[int]) -> int:
        target = sum(nums) / 2
        heap = [-num for num in nums]
        heapq.heapify(heap)

        answer = 0
        while target > 0:
            answer += 1
            num = heapq.heappop(heap) / 2
            target += num
            heapq.heappush(heap, num)
        
        return answer