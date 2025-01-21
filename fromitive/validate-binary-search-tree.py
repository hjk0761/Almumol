"""
title : Valid Parenthesis
link  : https://leetcode.com/problems/validate-binary-search-tree

description
해당 트리가 BST인지 검증하는 로직을 작성해야 한다.

해결 방안
BST는 root보다 작은 node들이 왼쪽에 있고, root보다 큰 node들이 오른쪽에 있다.
"""

class Solution:
    def isValidBSTwithDFS(self, root: Optional[TreeNode]) -> bool:
        def dfs(node, smallest, largest):
            if not node:
                return True
            if not smallest < node.val < largest:
                return False
            left = dfs(node.left, smallest, node.val)
            right = dfs(node.right, node.val, largest)
            return left and right
        return dfs(root, float("-inf"), float("inf"))
        
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True
        stack = [(root, float('-inf'), float('inf'))]
        while stack:
            node, smallest, largest = stack.pop()
            if not smallest < node.val < largest:
                return False
            if node.left:
                stack.append([node.left, smallest, node.val])
            if node.right:
                stack.append([node.right,node.val, largest])
        return True

