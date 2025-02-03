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