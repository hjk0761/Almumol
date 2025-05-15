"""
title: Delete the Middle Node of a Linked List
link : https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/

description

ListNode가 주어질때 가운데 노드를 제거하는 코드 작성해봐라

해결 방안

slow, faster 포인터를 사용

쓰는 방법을 잊어버려서 다시 학습해서 적용함
"""
class Solution:
    def deleteMiddle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head.next == None:
            return head.next
        middle = head
        faster = head.next.next
        while faster and faster.next:
            faster = faster.next.next
            middle = middle.next
        middle.next = middle.next.next
        return head

