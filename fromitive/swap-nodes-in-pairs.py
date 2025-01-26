"""
title : Swap Nodes in Pairs
link  : https://leetcode.com/problems/swap-nodes-in-pairs

description

1 -> 2 -> 3 -> 4 linked list가 있을 때 2 -> 1 -> 4 -> 3 으로 변환하는 코드를 작성해야 한다.

해결 방안

1. nextNode = head.next

            v
> 1 -> 2 -> 3 -> 4

2. head.next.next = head
             v
> 1 <-> 2 3 -> 4

3. head.next = nextNode
  |------v
> 1 <- 2 3 -> 4

4. head = nextNode
         v
  |------v
> 1 <- 2 3 -> 4
------- 한 페어의 swap이 끝남, 다음 swap은 지금 swap에 영향을 끼치지 못해야 함 -------

swap의 조건 : head and head.next (한 페어가 있을 경우)
** 5. prev.next = head.next **
  |-----------v
> 1 <- 2 3 -> 4
"""

class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head == None or head.next == None:
            return head
        prev = None
        dummy = head.next
        while head and head.next:
            if prev:
                prev.next = head.next
            prev = head
            nextNode = head.next.next
            head.next.next = prev
            head.next = nextNode
            head = nextNode
        return dummy