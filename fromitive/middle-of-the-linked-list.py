"""  
title : Middle of the linked-list
link  : https://leetcode.com/problems/middle-of-the-linked-list

description
링크드 리스트가 주어질 때 해당 리스트의 중간 pointer를 반환하는 코드를 작성하자.
"""

class Solution:
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        slow = head
        fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        return slow

