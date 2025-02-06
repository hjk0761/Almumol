"""
title: Path With Minimum Effort
link : https://leetcode.com/problems/path-with-minimum-effort

description

당신은 등산가다 각 산의 높이 정보를 가지고 있는 2차원 배열 matrix가 주어졌을 때 최소 노력으로 마지막 노드에 도달할 수 있는 노력치를 구해야 한다.

노력치는 현재 등반한 높이와 다음으로 이동할 높이의 절대값으로 계산할 수 있고 시작 위치는 (0,0) 에서 시작한다. 

해결 방안

해결방안 1 : BS + DFS
해결방안 2 : 다익스트라 사용
"""

class Solution1:
    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        directions = [(1, 0), (-1 ,0), (0, 1), (0, -1)]
        def isValid(row, col):
            return 0 <= row < len(heights) and 0 <= col < len(heights[0])
        

        def isFinish(effort):
            seen = set()
            seen.add((0, 0))
            stack = [(0, 0)] # start row, start col
            
            while stack:
                row, col = stack.pop()
                if (row, col) == (2, 2):
                    pass
                if (row, col) == (len(heights) - 1, len(heights[0]) - 1):
                    return True 
                for dy, dx in directions:
                    nextRow = row + dy
                    nextCol = col + dx
                    if isValid(nextRow, nextCol):
                        if (nextRow, nextCol) not in seen and abs(heights[row][col] - heights[nextRow][nextCol]) <= effort:
                            seen.add((nextRow, nextCol))
                            stack.append((nextRow, nextCol))
            return False
        left = 0
        right = 10 ** 6 # maxheight
        while left < right:
            mid = (left + right) // 2
            if isFinish(mid):
                right = mid
            else:
                left = mid + 1

        return left 

import heapq
class Solution2:
    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        rowlen = len(heights)
        collen = len(heights[0])

        directions = [(1, 0), (-1 ,0), (0, 1), (0, -1)]
        heap = [(float('inf'), 0, 0)] # efforts, row, col
        seen = set()
        efforts = [[float('inf')] * collen for row in range(rowlen)]
        efforts[0][0] = 0
        def isValid(row, col):
            return 0 <= row < len(heights) and 0 <= col < len(heights[0])

        while heap:
            effort, row, col = heapq.heappop(heap)
            # 중요! : seen은 이미 단계가 확정된 row, col만 방문여부를 체크. 다음에 갈 direction에 바로 체크하게 되면 effort를 비교할 수 없게 됨
            seen.add((row, col)) 
            for dy, dx in directions:
                nextRow = row + dy
                nextCol = col + dx
                if isValid(nextRow, nextCol) and (nextRow, nextCol) not in seen:
                    nextEffort = abs(heights[row][col] - heights[nextRow][nextCol])
                    maxEffort = max(efforts[row][col], nextEffort) # 현제 effort랑 다음 effort비교
                    if efforts[nextRow][nextCol] > maxEffort: # 다음 effort가 maxEffort보다 크면 (측정하지 않았다면)
                        efforts[nextRow][nextCol] = maxEffort
                        heapq.heappush(heap, (nextEffort, nextRow, nextCol))
        return efforts[-1][-1]
