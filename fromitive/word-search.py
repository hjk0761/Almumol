""" 
title: Word Search
link : https://leetcode.com/problems/word-search

description

matrix안에 주어진 word가 있으면 true 그렇지 않으면 false를 반환한다. matrix탐색 방향은 상하좌우이며 지나온 문자는 탐색할 수 없다.

메모 

BFS로 시도해봤으나 실패했다. 
시도해 본 이유는 탐색해야 할 (word index, row, col)를 seen에 등록하여 상태 자체를 저장하는 것으로 충분했기 때문이나..
word index 상태를 저장하는 것 뿐만 아니라 지금까지 걸어온 path도 저장해야 하기 때문에 BFS로 구현하기엔 어려움이 있었다..
"""
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        def isValid(row, col):
            return 0 <= row < len(board) and 0 <= col < len(board[row])
        def backtrack(row, col, seen, current):
            if current == len(word) - 1:
                return True 
            
            for dy, dx in directions:
                nextRow = row + dy
                nextCol = col + dx
                if isValid(nextRow, nextCol) and (nextRow, nextCol) not in seen:
                    if board[nextRow][nextCol] == word[current + 1]:
                        seen.add((nextRow, nextCol))
                        if backtrack(nextRow, nextCol, seen, current + 1):
                            return True
                        seen.remove((nextRow, nextCol))
            return False
        for r in range(len(board)):
            for c in range(len(board[r])):
                if board[r][c] == word[0] and backtrack(r, c, {(r,c)}, 0):
                    return True

        return False