"""
title : Find Largest Value in Each Tree Row
link  : https://leetcode.com/problems/find-largest-value-in-each-tree-row

description

트리의 각 depth별로 최대 값을 구하자
"""

from collections import deque

class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        queue = deque()
        queue.append(root)
        answer = []
        while queue:
            rows = len(queue)
            maxValue = float('-inf')
            for _ in range(rows):
                node = queue.popleft()
                maxValue = max(maxValue, node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            answer.append(maxValue)
        return answer
