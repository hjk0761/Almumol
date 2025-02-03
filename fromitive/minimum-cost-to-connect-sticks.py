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