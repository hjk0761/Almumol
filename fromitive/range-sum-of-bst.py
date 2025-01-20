"""
title : Range Sum of BST
link  : https://leetcode.com/problems/range-sum-of-bst

description
*이진탐색트리 가 주어지고 low, high값이 주어졌을 때, 해당 트리의 [low, high] 범위의 합을 구해야 한다.

이진탐색트리 : root를 기점으로 root보다 작은 수는 left node에 root보다 큰 수는 right node에 저장하고 있는 트리를 말한다.

해결 방안
high가 기준값 보다 작으면 left에 있다는 말이 되므로 node.right 탐색 조건은 node.val < right를 만족해야 한다.
low가 기준값 보다 크면 left에 없다는 말이 되므로 node.left 탐색 조건은 low < node.val를 만족해야 한다.
"""

class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        if not root:
            return 0
        answer = 0
        if low <= root.val <= high:
            answer += root.val
        if low < root.val:
            answer += self.rangeSumBST(root.left, low, high)
        if root.val < high:
            answer += self.rangeSumBST(root.right, low, high)
        return answer
    def rangeSumBSTWithStack(self, root: Optional[TreeNode], low: int, high: int) -> int:
        if not root:
            return 0
        answer = 0
        stack = [root]
        while stack:
            node = stack.pop()
            if low <= node.val <= high:
                answer += node.val
            if node.left and low < node.val:
                stack.append(node.left)
            if node.right and node.val < high:
                stack.append(node.right)
        return answer