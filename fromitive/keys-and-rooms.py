"""
title : Keys and Rooms
link  : https://leetcode.com/problems/keys-and-rooms

description

rooms 배열은 0 부터 n - 1 번 방을 방문할 수 있는 열쇠(keys)가 주어진다. 각 열쇠로 해당 방은 방문할 수 있는데
이때 모든 방을 방문 가능여부를 반환하도록 작성한다.

해결 방안

seen으로 방문한 방을 기록하고 seen이 방의 개수만큼 방문했는지 확인하면 된다. 
"""

class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        seen = set()
        stack = [0]
        seen.add(0)
        while stack:
            node = stack.pop()
            for neighbor in rooms[node]:
                if neighbor not in seen:
                    seen.add(neighbor)
                    stack.append(neighbor)
        return len(seen) == len(rooms)
