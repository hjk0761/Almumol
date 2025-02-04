""" 
title: IPO
link : https://leetcode.com/problems/ipo

description

ipo프로젝트를 수행한다. 각 project마다 profits, capital, 초기자본 w와 투자횟수 k가 주어진다.
처음엔 초기자본 w보다 작거나 같은 captial의 프로젝트만 가능하나, 프로젝트를 하나 완성하면 초기자본 w에 수행한 profits만큼 자본이 증가한다.
이때 초기자본 w에서 시작하여 k번 투자할 때 최대 profit을 구해야 한다.

해결 방안

매 k 번마다 w보다 작거나 같은 project의 최대 이익을 더하면 된다. 매 순간마다 최대 값을 유지하는 자료구조를 사용하면 좋다.

"""
import heapq
class Solution:
    def findMaximizedCapital(self, k: int, w: int, profits: List[int], capital: List[int]) -> int:
        projects = sorted(zip(capital, profits))
        i = 0
        heap = []
        for _ in range(k):
            while i < len(projects) and projects[i][0] <= w:
                heapq.heappush(heap, -projects[i][1])
                i += 1
            if not heap:
                return w
            w -= heapq.heappop(heap)
        return w