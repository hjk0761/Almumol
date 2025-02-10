"""
title : Snake and Ladders
link  : https://leetcode.com/problems/snake-and-ladders

"""
from collections import deque
class Solution:
    def snakesAndLadders(self, board: List[List[int]]) -> int:
        def getNext(curr): 
            return [node for node in range(curr + 1, min(curr + 6, len(board) ** 2) + 1)]
        
        reverse = False
        hashTable = {}
        counter = 1
        for i in range(len(board) -1, -1, -1):
            for j in range(len(board)):
                if not reverse:
                    hashTable[counter] = (i, j)
                else:
                    hashTable[counter] = (i, len(board) -1 - j)
                counter += 1
            reverse = not reverse
        
        queue = deque()
        queue.append((1, 0))
        seen = set()
        seen.add(1)
        while queue:
            curr, step = queue.popleft()
            if curr == len(board) ** 2:
                return step
            for nextCur in getNext(curr):
                if nextCur in hashTable:
                    row, col = hashTable[nextCur]
                    destination = board[row][col] if board[row][col] != -1 else nextCur
                    if destination not in seen:
                        queue.append([destination, step + 1])
                        seen.add(destination)
        return -1
