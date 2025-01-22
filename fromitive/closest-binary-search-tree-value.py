"""
title : Closest Binary Search Tree Value
link  : https://leetcode.com/problems/closest-binary-search-tree-value

description

BST와 target 값이 주어졌을 때 각 노드별로 target과 근접한 값의 노드 값을 구하라. 값을 비교할 수 없으면 노드 값 중 작은 값을 반환한다.
"""

class Solution:
    def closestValue(self, root: Optional[TreeNode], target: float) -> int:
        def compare(pair1, pair2):
            if pair1[1] < pair2[1]:
                return pair1
            elif pair1[1] > pair2[1]:
                return pair2
            elif pair1[1] == pair2[1] and pair1[0] < pair2[0]:
                return pair1
            elif pair1[1] == pair2[1] and pair1[0] > pair2[0]:
                return pair2

        stack = [root]
        answer = (-1, float('inf')) 
        while stack:
            node = stack.pop()
            answer = compare(answer, (node.val, abs(target - node.val)))
            if target < node.val and node.left:
                stack.append(node.left)
            if target > node.val and node.right:
                stack.append(node.right)
        return answer[0]