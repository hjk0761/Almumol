"""
title : Daily Temperatures
link  : https://leetcode.com/problems/deepest-leaves-sum

description
tree 가장 깊은 leaves가 있는 depth의 총 합을 구하자
"""

from collections import deque
class Solution:
    def deepestLeavesSum(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        queue = deque()
        queue.append(root)
        answer = 0
        while queue:
            depth = len(queue)
            currentSum = 0
            for _ in range(depth):
                node = queue.popleft()
                currentSum += node.val
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            answer = currentSum
        return answer