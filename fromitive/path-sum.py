"""
title : Path Sum
link  : https://leetcode.com/problems/path-sum

description
root부터 leaf 노드까지의 합이 targetSum을 만족하는 경로가 존재하면 참을 반환한다.
그렇지 않으면 False를 반환한다.

해결 방안
재귀 탈출 조건과 다음 단계를 적절히 설정했는가를 고민해봐야 한다.

탈출 조건 : leaf 노드이면서 현재 값을 더했을 때 targetSum을 만족하는지 확인
다음 조건 : left 혹은 right 노드에서 값을 만족하는지 찾기
"""
class Solution:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        def dfs(root, currentSum):
            if not root:
                return False
            if not root.right and not root.left and currentSum + root.val == targetSum:
                return True
            return dfs(root.left, currentSum + root.val) or dfs(root.right, currentSum + root.val)
        return dfs(root, 0)

    def hashPathSumWithStack(self, root: Optional[TreeNode], targetSum: int) -> bool:
        if not root:
            return False
        stack = [(root, 0)]
        
        while stack:
            node, currentSum = stack.pop()
            if not node.left and not node.right and node.val + currentSum == targetSum:
                return True
            if node.left:
                stack.append([node.left, currentSum + node.val])
            if node.right:
                stack.append([node.right, currentSum + node.val])
        
        return False