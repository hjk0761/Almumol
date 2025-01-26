"""
title : Diameter of Binary Tree
link  : https://leetcode.com/problems/diameter-of-binary-tree

description
binary tree가 주어졌을때 diameter(지름)을 구해야 한다. 지름이란 특정 노드 X에서 Y까지 의 경로 중 가장 긴 경로이다.

해결 방안

특정 Root 노드에서 diameter를 구하기 위해선, 왼쪽과 오른쪽의 최대 깊이를 더하면 된다. 그러나, root node를 거치지 않고 
자식 노드에서 제일 긴 경로가 나올 수 있으므로 dfs로 접근해야 한다. 

이 문제는 지난 Tree 문제와 다르게, root에서 leaf로 내려가는 top-down이 아닌 Bottom-up 접근 방식이 적용되었다.

max(left, right) + 1 부분의 의미는 자식노드중 제일 깊은 것을 선택하고 부모노드와 연결되는 의미인 것이다. 
"""

class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        answer = 0
        def dfs(node):
            if not node:
                return 0
            nonlocal answer
            left = dfs(node.left)
            right = dfs(node.right)
            answer = max(answer, left + right)
            return max(left, right) + 1
        dfs(root)
        return answer
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        paths = {}
        answer = 0
        stack = [(root, False)]
        while stack:
            node, seen = stack.pop()
            if seen:
                left = paths.get(node.left, 0)
                right = paths.get(node.right, 0)
                answer = max(answer, left + right)
                paths[node] = max(left, right) + 1
            else:
                stack.append([node, True])
                if node.left:
                    stack.append([node.left, False])
                if node.right:
                    stack.append([node.right, False])
                # push: root -> left - > right / pop: right -> left -> root 즉, Bottom-up