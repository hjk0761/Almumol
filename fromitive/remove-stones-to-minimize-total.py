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

