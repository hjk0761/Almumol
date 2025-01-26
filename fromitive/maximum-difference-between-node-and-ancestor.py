"""
title : Maximum Difference Between Node and Ancestor
link  : https://leetcode.com/problems/maximum-difference-between-node-and-ancestor

description
Tree의 조상과 노드사 절대값 차이의 최대값을 구해야 한다. 

해결 방안
절대값 차이를 순회하며 구하는 핵심 로직은 최대, 최소를 계속 갱신하는 것이다. Node값이 최소 또는 최대일경우 해당 값과 바꿔주면서 알고리즘을 실행시키자.
"""
class Solution:
    def maxAncestorDiff(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        answer = float("-inf")
        stack = [(root, root.val, root.val)]
        
        while stack:
            node, maxval, minval = stack.pop()
            maxval = max(maxval, node.val)
            minval = min(minval, node.val)
            answer = max(answer, maxval - minval)
            if node.left:
                stack.append([node.left, maxval, minval])
            if node.right:
                stack.append([node.right, maxval, minval])
        return answer