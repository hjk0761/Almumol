"""  
title : Minimum Absolute Difference in BST
link  : https://leetcode.com/problems/minimum-absolute-difference-in-bst

description
BST가 주어질 때 각 노드끼리의 최소 절대값을 구한다.

해결방안

BST는 이미 정렬되어 있으므로 O(n)으로 sorted array를 만들 수 있다. 이를 활용하자.
"""

class Solution:
    def getMinimumDifference(self, root: Optional[TreeNode]) -> int:
        values = []
        def dfs(node):
            if not node:
                return
            nonlocal values
            left = dfs(node.left)
            values.append(node.val)
            right = dfs(node.right)
        dfs(root)
        answer = float("inf")
        for i in range(1, len(values)):
            answer = min(answer, values[i] - values[i - 1])
        return answer

    def getMinimumDifference(self, root: Optional[TreeNode]) -> int:
        def iterativeInorder(node):
            values = []
            stack = []
            current = root
            while stack or current:
                if current:
                    stack.append(current)
                    current = current.left
                else:
                    current = stack.pop()
                    values.append(current.val)
                    current = current.right
            return values
        values = iterativeInorder(root)
        answer = float("inf")
        for i in range(1, len(values)):
            answer = min(answer, values[i] - values[i - 1])
        return answer