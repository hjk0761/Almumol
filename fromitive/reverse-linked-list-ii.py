"""
title : Reverse Linked List II
link  : https://leetcode.com/problems/reverse-linked-list-ii

description
길이가 n 인 linked-list와 1 <= left < = right <= n를 만족하는 left, right가 주어진다.
이때, left 번째 node 부터 right 번째 node까지 뒤집는 알고리즘을 작성해야 한다.

해결 방안

1. 시작지점 찾기

left 번째 node를 찾는다. 이 node는 reverse Node의 tail이자 reversing의 시작 지점이다. 이 두개의 의미를 저장하고자 tail 변수로 별도로 저장한다.
또한 left 번째 이전 node인 before 찾는다.reverse하는 과정이 끝난 후 연결할 지점이다.

2. 시작지점 부터 끝 지점가지 뒤집기

left 번째부터 right 지점까지 뒤집으려면 right - left + 1 번 뒤집어야 한다.

3. 연결하기

전부 뒤집었으면 leftBefore.next 가 reverse한 linked-list의 시작점이 되야하고
tail.next는 reverse한 반복문의 끝지점에 연결한다.
"""

class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        current = head
        prev = None
        for _ in range(left - 1):
            prev = current
            current = current.next

        before = prev
        tail = current

        for _ in range(right - left + 1):
            nextNode = current.next
            current.next = prev
            prev = current
            current = nextNode

        if before:
            before.next = prev
        else:
            head = prev
        tail.next = current
        return head
