""" 
title: Destroying Asteroids
link : https://leetcode.com/problems/destroying-asteroids

description

위성들의 질량정보를 담고 있는 asteroids 와 행성의 질량정보 mess가 있다.
이때 asteroids안에 있는 위성들을 파괴하여 다음의 규칙에 따라 행성이 파괴되거나 질량을 늘릴 수 있다.
1. 위성의 질량이 행성의 질량보다 클 경우 행성은 파괴된다.
2. 행성의 질량이 위성의 질량보다 작거나 같을 경우 행성은 위성의 질량을 흡수할 수 있다.

파괴하는 위성은 선택할 수 있으며 이때 asteroids의 위성 전체들을 전부 파괴 가능한지 검증하는 코드를 작성한다.

해결 방안 

작은 위성부터 파괴하면 나중에 질량이 가장 큰 위성을 파괴할 수 있다. 
이때 그리디 알고리즘이 활용되며, 작은 위성부터 파괴하는 알고리즘을 작성한다.
"""

class Solution:
    def asteroidsDestroyed(self, mass: int, asteroids: List[int]) -> bool:
        asteroids.sort()
        for asteroid in asteroids:
            if mass < asteroid:
                return False
            mass += asteroid
        return True 