"""
title : All Nodes Distance K in Binary Tree
link  : https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree

description

바이너리 트리의 root와 서브 트리인 target 그리고 k 값이 주어질 때 target으로 하여금 k만큼 떨어져 있는 노드들을 찾아서 반환해야한다.

해결 방안
바이너리 트리를 그래프로 바꿔서 풀어보자
"""

from collections import deque
class Solution:
    def distanceK(self, root: TreeNode, target: TreeNode, k: int) -> List[int]:
        parents = {root: None}
        # build parent
        stack = [root]
        while stack:
            node = stack.pop()
            if node.left:
                parents[node.left] = node
                stack.append(node.left)
            if node.right:
                parents[node.right] = node
                stack.append(node.right)
        
        queue = deque()
        queue.append(target)
        destination = 0
        seen = set()
        seen.add(target)
        while queue and destination < k:
            depth = len(queue)
            for _ in range(depth):
                node = queue.popleft()
                for neighbor in [node.left, node.right, parents.get(node, None)]:
                    if neighbor and neighbor not in seen:
                        seen.add(neighbor)
                        queue.append(neighbor)
            destination += 1
        return [node.val for node in queue]
                    