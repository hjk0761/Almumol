"""
title : Largest Unique Number
link  : https://leetcode.com/problems/linked.list-cycle

description

Linked-List가 cycle이 있으면 True 없으면 False를 반환하게 만들자.

"""

class ListNode:
    def __init__(self,val):
        self.val = val
        self.next = None

class Solution:
    def hasCycleWithFastAndSlow(self, head: Optional[ListNode]) -> bool:
        slow = head
        fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if fast == slow:
                return True

        return False         
    def hasCycleWithVisited(self, head: Optional[ListNode]) -> bool:
        dummy = head
        visited = set()
        while dummy:
            if dummy in visited:
                return True
            visited.add(dummy)
            dummy = dummy.next

        return False         