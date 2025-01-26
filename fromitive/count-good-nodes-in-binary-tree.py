"""
title : Count Good Nodes in Binary Tree
link  : https://leetcode.com/problems/count-good-nodes-in-binary-tree

description
root 와 하위 노드 X가 있을 때 root에서 X로 가는 경로 내의 노드 값들이 X보다 작은 경로의 개수를 구한다.

해결 방안
leaf 노드를 포함하고 중간 Node까지의 경로 개수를 구한다. X의 값을 비교하기 위해 경로 중 최대 값을 기록하며 탐색한다.
현재 노드보다 큰 값이 없으면 추가해야 하므로 크거나 같을 때 개수를 샌다.
"""

class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        def dfs(root, maxNum):
            if not root:
                return 0
            answer = 0
            if root.val >= maxNum:
                answer += 1
            answer += dfs(root.right, max(root.val, maxNum)) + dfs(root.left, max(root.val, maxNum))
            return answer
        return dfs(root, float("-inf"))    def goodNodes(self, root: TreeNode) -> int:
    
    def goodNodesWithStack(self, root: TreeNode) -> int:
        if not root:
            return 0
        answer = 0
        stack = [[root, float("-inf")]]
        while stack:
            node, maxNum = stack.pop()
            if node.val >= maxNum:
                answer += 1
            if node.left:
                stack.append([node.left, max(maxNum, node.val)])
            if node.right:
                stack.append([node.right, max(maxNum, node.val)])
        return answer