"""
title : Insert into a Binary Search Tree
link  : https://leetcode.com/problems/insert-into-a-binary-search-tree

description
val이 주어졌을 때 BST에 삽입하는 로직을 작성한다.
"""

class Solution:
    def insertIntoBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        if not root:
            return TreeNode(val)
        stack = [root]
        while stack:
            node = stack.pop()
            if val > node.val and not node.right:
                node.right = TreeNode(val)
                break
            if val < node.val and not node.left:
                node.left = TreeNode(val)
                break
            if val < node.val and node.left:
                stack.append(node.left)
            if val > node.val and node.right:
                stack.append(node.right)
        return root
            