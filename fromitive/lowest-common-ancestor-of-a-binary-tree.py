"""
title : Lowest Common Ancestor of a Binary Tree
link  : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree

description

root 에 포함되어 있는 노드 p와 q가 주어졌을 때 p와 q의 가장 직속인 조상 노드를 구해야 한다.

해결 방안

재귀 함수로 확실한 결과값을 반환하면 된다.
"""
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root:
            return None
        if root == p or root == q:
            return root
        
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)

        if left and right:
            return root
        if left:
            return left
            
        return right