"""
title : Number of Recent Calls
link  : https://leetcode.com/problems/number-of-recent-calls

description

RecentCounter 클래스를 구현해야 한다. 구현해야 할 메서드 ping은 milliseconds인 t를 받는다.
ping(t)의 결과 값으로 [t - 3000, t] 범위의 통화 개수를 반환해야 한다.
테스트로 주어진 t 의 값은 오름차순으로 정렬되어있다.
"""
from collections import deque

class RecentCounter:
    def __init__(self):
        self.RECENT_PING_RANGE = 3000
        self.queue = deque()

    def ping(self, t: int) -> int:
        while self.queue and self.queue[0] < t - self.RECENT_PING_RANGE:
            self.queue.popleft()
        
        self.queue.append(t)
        return len(self.queue)