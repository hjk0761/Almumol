""" 
title : Open Lock
link  : https://leetcode.com/problems/open-lock

description
'0000' 부터 '9999'까지 회전할 수 있는 자물쇠가 주어진다.

target number까지 갈 수 있는 최소한의 시도 횟수를 구해야 한다.

단 deadends 배열도 주어지는데 해당 원소의 번호로 자물쇠를 맞추면 다시는 자물쇠를 맞출 수 없게 된다.
"""

from collections import deque
class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        if "0000" in deadends:
            return -1
        def getNeighbor(node):
            answer = []
            for i in range(4):
                x = int(node[i])
                for dx in [-1, 1]:
                    nextX = x + dx
                    if nextX < 0:
                        nextX = 9
                    if nextX > 9:
                        nextX = 0 
                    answer.append(node[:i] + str(nextX) + node[i + 1: ])
            return answer
        queue = deque()
        queue.append(["0000", 0])
        seen = set(deadends)
        while queue:
            node, step = queue.popleft()
            if node == target:
                return step
            for neighbor in getNeighbor(node):
                if neighbor not in seen:
                    seen.add(neighbor)
                    queue.append([neighbor, step + 1])
        return -1
