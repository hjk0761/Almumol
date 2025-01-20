"""
title : Binary Tree Zigzag Level Order Traversal
link  : https://leetcode.com/problems/binary-tree-right-side-view

description
트리의 각 level 별 node 값을 탐색하는 알고리즘을 작성한다. 단, 짝수 번째 depth는 역으로 수집해야 한다.

해결 방안
queue는 appendleft가 제공된다. java는? Deque 자료구조를 제공한다.
"""

from collections import deque
class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        queue = deque()
        queue.append(root)
        answer = []
        reverse = False
        while queue:
            depth = len(queue)
            currentTraversal = deque()
            for _ in range(depth):
                node = queue.popleft()
                if reverse:
                    currentTraversal.appendleft(node.val)
                else:
                    currentTraversal.append(node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            answer.append(list(currentTraversal))
            reverse = not reverse 
        return answer
                