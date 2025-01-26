"""
title : Binary Tree Right Side view
link  : https://leetcode.com/problems/binary-tree-right-side-view

description
트리의 각 depth별로 맨 오른쪽에 있는 node들을 반환하는 알고리즘을 작성한다.
"""

from collections import deque

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        queue = deque()
        queue.append(root)
        answer = []
        while queue:
            rows = len(queue)
            answer.append(queue[-1].val)
            for _ in range(rows):
                node = queue.popleft()
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
        return answer