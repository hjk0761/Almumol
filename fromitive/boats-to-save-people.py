""" 
title: Boats to Save People
link : https://leetcode.com/problems/boats-to-save-people

description

보트 한개가 있다. 해당 보트는 최대 두명이 탈 수 있으며 이 보트를 이용해 people 배열에 있는 사람들을 구출해야 한다.

people 배열에는 각 사람들의 몸무게 정보가 있으며 보트는 limit 보다 작거나 같은 사람들만 태울 수 있다.

people에 있는 사람들의 몸무게는 limit보다 작거나 같을 때 최소한으로 보트를 이용할 수 있는 방법의 수를 구하자.

해결 방안

제일 몸무게가 나가는 사람과 몸무게가 가벼운사람을 선택해서 태운다. 이때 두 사람의 몸무게가 최대일 경우 몸무게가 무거운 사람 부터 태운다.

몸무게가 무거운 사람부터 태우게 되면 두번째로 몸무게가 무거운사람과 가벼운사람이 동시에 태워질 확률이 증가하기 때문에 greedy로 해결 가능하다.
"""


class Solution:
    def numRescueBoats(self, people: List[int], limit: int) -> int:
        # 정렬
        people.sort()
        light = 0
        heavy = len(people) - 1
        answer = 0
        while light <= heavy:
            if people[light] + people[heavy] <= limit:
                light += 1
            heavy -= 1 
            answer += 1

        return answer