"""   
title : Remove Stones to Minimize the Total
link  : https://leetcode.com/problems/remove-stones-to-minimize-the-total

description

piles 배열과 정수 k가 주어진다. piles의 원소는 양의 정수로 이루어져 있으며 k 횟수만큼 piles안에 있는 원소를 꺼내 절반을 제거할 수 있다. 
절반을 제거할 때는 floor(piles[i] / 2)연산을 이용해 제거가능하다.
이때 k 횟수만큼 작업이 끝났을 때 최소 합을 구해야 한다.
"""
import heapq
class Solution:
    def minStoneSum(self, piles: List[int], k: int) -> int:
        heap = [-pile for piles in piles]
        heapq.heapify(heap)
        counter = 0
        while counter < k:
            pile = heapq.heappop(heap)
            heapq.heappush(heap, pile // 2)
            counter += 1
        return -sum(pile)

