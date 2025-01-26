"""
title : Same Tree
link  : https://leetcode.com/problems/same-tree

description

두 Tree p와 q가 동일한 Tree인지 검증해야 한다.

해결 방안

더이상 탐색할 필요가 없을 때 어떤 탈출조건으로 나가야하는지 고민해봐야 한다.

p와 q가 leaf노드이고 p.val == q.val이면 null 과 null을 비교하는 순간이 온다. 이때 스택으로 구현할 땐 어떻게 해야하는지, 재귀로는 어떻게 해야하는지 고민하자.
"""
class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        if not p and not q:
            return True
        if not p or not q:
            return False
        if p.val != q.val:
            return False
        return self.isSameTree(p.right, q.right) and self.isSameTree(p.left, q.left)
    
    def isSameTreeWithStack(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        if not p and not q:
            return True
        if not p or not q:
            return False
        stack = [(p, q)]
        while stack:
            p, q = stack.pop()
            if not p and not q:
                continue
            if not p or not q:
                return False
            if p.val != q.val:
                return False
            stack.append([p.left, q.left])
            stack.append([p.right, q.right])
        return True