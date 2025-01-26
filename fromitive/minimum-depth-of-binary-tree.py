""" 
title : Minimum Depth of Binary Tree
link : https://leetcode.com/problems/minimum-depth-of-binary-tree

description

root 노드의 최소 depth를 구한다.

"""

class Solution:
    def minDepth(self, root: Optional[TreeNode]) -> int:
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