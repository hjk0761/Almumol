"""
title: Jump Game III
link : https://leetcode.com/problems/jump-game-iii

description

arr 배열과 start index가 주어진다. index는 arr범위를 넘을 수 없으며 start index에서 arr값이 0인 값에 도달 가능한지 검증하는 코드를 작성해야 한다.
start index의 다음 index는 index + arr[index] 혹은 index - arr[index]로만 움직일 수 있다.

"""

from collections import deque
class Solution:
    def canReach(self, arr: List[int], start: int) -> bool:
        queue = deque()
        queue.append(start)
        seen = set()
        seen.add(start)
        def isValid(index):
            return 0 <= index < len(arr) 
        while queue:
            index = queue.popleft()
            if arr[index] == 0:
                return True
            for neighbor in [index + arr[index], index - arr[index]]:
                if isValid(neighbor) and neighbor not in seen:
                    seen.add(neighbor)
                    queue.append(neighbor)
        return False
