""" 
title : Detonate the Maximum Bombs
link  : https://leetcode.com/problems/detonate-the-maximum-bombs

description

폭탄의 위치 정보와 위력이 담겨있는 bombs 배열이 주어진다. bombs의 각 원소는 [x, y, r]로 되어있으며 각각 x좌표, y좌표, 폭발 범위(반지름)으로 구성되어있다.
bombs안의 폭탄이 최대 연속으로 터질수 있는 횟수를 구해야 한다.
"""
class Solution:
    def maximumDetonation(self, bombs: List[List[int]]) -> int:
        if len(bombs) == 0:
            return 0

        graph = defaultdict(list)

        def isValid(i ,j):
            thisBomb = bombs[i]
            otherBomb = bombs[j]
            return (thisBomb[0] - otherBomb[0]) ** 2 + (thisBomb[1] - otherBomb[1]) ** 2 <= thisBomb[2] ** 2 
        for i in range(len(bombs)):
            for j in range(len(bombs)):
                if i == j:
                    continue
                if isValid(i, j):
                    graph[i].append(j)

        def detonate(start):
            seen = set()
            seen.add(start)
            stack = [start]
            while stack:
                node = stack.pop()
                for neighbor in graph[node]:
                    if neighbor not in seen:
                        stack.append(neighbor)
                        seen.add(neighbor)
            return len(seen)

        answer = 1
        # defaultdict에 값이 없으면 값이 삽입되는 것 조심..!
        for i in range(len(bombs)):
            answer = max(answer, detonate(i))
        return answer


## 오답
class Solution:
    def maximumDetonation(self, bombs: List[List[int]]) -> int:
        def isValid(x, y, r, targetX, targetY):
            return (targetX - x) ** 2 + (targetY - y) ** 2 <= r ** 2
        
        def maxdenoted(start):
            seen = set()
            seen.add((start[0], start[1], start[2]))
            stack = [start]
            answer = 1
            while stack:
                node = stack.pop()
                affected = seen.copy()
                # 이부분은 틀린 코드임. 같은 폭탄이 같이 있으면 검증할 수 없음
                for neighbor in bombs:
                    for affect in affected:
                        if (neighbor[0], neighbor[1], neighbor[2]) not in seen and isValid(affect[0], affect[1], affect[2], neighbor[0], neighbor[1]):
                            seen.add((neighbor[0], neighbor[1], neighbor[2]))
                            stack.append(neighbor)

            # 기억 필수 : 방문 개수 = 폭팔 개수
            return len(seen)
        
        if len(bombs) == 0:
            return 0
        answer = 1
        for bomb in bombs:
            answer = max(answer, maxdenoted(bomb))
        return answer

