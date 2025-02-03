""" 
title : Minimum Depth of Binary Tree
link : https://leetcode.com/problems/minimum-depth-of-binary-tree

description

root 노드의 최소 depth를 구한다.

"""
from collections import deque
class Solution:
    def minDepthWithDFS(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        answer = float('inf')
        stack = [(root, 1)]
        while stack:
            node, depth = stack.pop()
            if not node.right and not node.left:
                answer = min(answer, depth)
            if node.right:
                stack.append([node.right, depth + 1])
            if node.left:
                stack.append([node.left, depth + 1])
        return answer

    def minDepthWithBFS(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        queue = deque()
        queue.append(root)
        level = 1
        while queue:
            depth = len(queue)
            for _ in range(depth):
                node = queue.popleft()
                if not node.left and not node.right:
                    return level
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            level += 1
        return answer