"""
title : Reverse Linked List
link  : https://leetcode.com/problems/reverse-linked-list

description
ListNode 순서를 뒤집는 코드를 작성한다.
"""

class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        current = head
        prev = None
        nextnode = None
        while current:
            nextnode = current.next
            current.next = prev
            prev = current
            current = nextnode
        return prev