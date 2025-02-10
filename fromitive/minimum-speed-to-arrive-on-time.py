""" 
title: Minimum Speed to Arrive on Time
link : https://leetcode.com/problems/minimum-speed-to-arrive-on-time

description

당신은 n개의 기차를 순서대로 타서 회사에 도착해야한다. n개의 각 기차가 가는 거리 배열 dist와 hours 가 주어질때 회사에 도착하기 위한 최소 속도를 구해야한다.
dist의 각 정보의 단위는 km이며 있고 속도의 단위는 km/h 이다 (속도와 속력 햇갈리네) 

만일 속도가 3이고 dist가 1일경우 걸리는 시간은 0.3333.. 이지만, 다음 기차를 타기 위해 최소 1시간 은 대기하는 시간이 있기 때문에 1시간이 소요된다.
따라서 hours시간안에 도착할 수 없는 상황이 있을 수 있기 때문에 그 경우는 -1을 반환한다.

해결 방안

"""

class Solution:
    def minSpeedOnTime(self, dist: List[int], hour: float) -> int:
        def check(speed):
            takesHour = 0
            for d in dist:
                takesHour = ceil(takesHour) # 시간을 올릴 때 (d / speed) 자체를 올려버린다면 맨 마지막 열차도 아무리 빠르게 도착해도 1시간으로 처주니까 계산하기 전에 ceil(올림)을 해주자
                takesHour += d / speed
            return takesHour <= hour
        if len(dist) > ceil(hour):
            return - 1
        left = 1
        right = 10 ** 7
        while left <= right:
            mid = (left + right) // 2
            if check(mid):
                right = mid - 1
            else:
                left = mid + 1
        return left
