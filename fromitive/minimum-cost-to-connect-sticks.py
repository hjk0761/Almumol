""" 
title : Minimum Cost to Connect Sticks
link  : https://leetcode.com/problems/minimum-cost-to-connect-sticks

description

막대기들의 길이 정보들을 담고 있는 sticks배열이 주어진다.
이때 sticks에 있는 아무 막대기 2개를 골라 합칠 수 있다.
막대기를 합칠 땐 합친 막대기 개수만큼 비용이 들며
막대기를 하나로 만들기 위한 최소 비용을 구해야 한다.
"""
import heapq
class Solution:
    def connectSticks(self, sticks: List[int]) -> int:
        if len(sticks) < 2:
            return 0
        cost = 0
        heapq.heapify(sticks)
        while len(sticks) > 1:
            first = heapq.heappop(sticks)
            second = heapq.heappop(sticks)
            cost += first + second
            heapq.heappush(sticks, first + second)
        return cost