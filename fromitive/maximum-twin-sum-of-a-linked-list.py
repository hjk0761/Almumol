"""
title: Maximum Twin Sum of a Linked List
link : https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list

description

길이가 짝수인 linked-list가 주어진다. index가 0 부터 시작할 때 i 번째와  n - 1 -i 번째 인덱스의 합을 twin sum라고 정의한다면, 주어진 linked-list의 twin-sum 최대값을 구한다.

해결 방안

fast, slow 포인터를 이용해 linked-list 절반 포인터를 탐색한다.
해당 포인터의 순서를 뒤집는다.
head와 뒤집은 포인터의 노드 값을 순서대로 비교한다.
"""

class Solution:
    def pairSum(self, head: Optional[ListNode]) -> int:
        slow = head
        fast = head
        ## slow에 전체 linked-list의 중앙 값을 얻을 수 있음
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        ## 중앙 포인터부터 node를 뒤집는다. prev는 뒤집은 linked-list의 head값이 저장된다.
        prev = None
        while slow:
            nextNode = slow.next
            slow.next = prev
            prev = slow 
            slow = nextNode

        answer = prev.val + head.val

        while prev and head:
            answer = max(answer, prev.val + head.val)
            head = head.next 
            prev = prev.next

        return answer    
