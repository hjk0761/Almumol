"""
title: Path Crossing
link : https://leetcode.com/problems/path-crossing

description

path 문자열이 주어진다. 각 문자는 (N,S,E,W)중 하나로 동서남북 방향을 의미한다.

path대로 이동할 때 이동했던 경로를 지나치는 여부를 판단하는 코드를 작성하자.

해결 방안

처음 시작 지점을 0,0으로 설정하고, 각 방향별로 이동 값을 정의한다. 그리고 지나온 경로를 저장하여 이전에 지나쳤던 좌표라먼 True 
모든 path를 이동했음에도 지나치지 않으면 False를 반환한다. 그렇게하면 O(path)의 알고리즘을 완성할 수 있다.
"""

class Solution:
    def isPathCrossing(self, path: str) -> bool:
        seen = set()
        seen.add((0,0))
        directions= {'N':(0,1),'E':(1,0),'W':(-1,0),'S':(0,-1)}
        x = 0
        y = 0
        for d in path:
            dx = directions[d][0]
            dy = directions[d][1]
            x += dx
            y += dy
            if (x, y) in seen:
                return True
            seen.add((x, y))
        return False
