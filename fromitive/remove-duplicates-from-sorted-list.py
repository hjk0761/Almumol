"""
title : Remove duplicates from sorted list
link  : https://leetcode.com/problems/remove-duplicates-from-sorted-list

description
정렬된 linked-list의 중복 값일 제거하는 코드를 작성해야 한다.
"""

class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy = head
        while dummy and dummy.next:
            if dummy.val == dummy.next.val:
                dummy.next = dummy.next.next
            else:
                dummy = dummy.next
        return head