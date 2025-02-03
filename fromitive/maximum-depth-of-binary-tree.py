"""
title : Maximum Depth of Binary Tree
link  : https://leetcode.com/problems/maximum-depth-of-binary-tree

description
Binary Tree의 최대 깊이를 구하자

해결 방안
재귀를 이용해 푸는 방식과 stack을 이용해 푸는 방식이 있다.

root가 존재하지 않을 경우 깊이가 0이고 root Node가 1개라도 존재하면 깊이는 1로 설정한다. 
재귀에서 탈출 조건을 주목하자. 최종적으로 내려간 깊이를 반환하고 초기 값을 0으로 설정했다.

stack에는 재귀함수 argument형태를 똑같이 넣어준다.
하나 다른 점은 최대값을 매 순간 비교하는 것이다.
"""


class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        def dfs(root, depth):
            if not root:
                return depth
            return max(dfs(root.left, depth + 1), dfs(root.right, depth + 1))
        return dfs(root, 0)
    
    def maxDepthTwo(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        left = self.maxDepthTwo(root.left)
        right = self.maxDepthTwo(root.right)
        return max(left, right) + 1

    def maxDepthStack(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        stack = [(root, 1)]
        answer = 1
        while stack:
            node, depth = stack.pop()
            answer = max(answer, depth)
            if node.left:
                stack.append([node.left, depth + 1])
            if node.right:
                stack.append([node.right, depth + 1])
        return answer