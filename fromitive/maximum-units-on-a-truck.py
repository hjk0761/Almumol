""" 
title: Maximum Units on a Truck
link : https://leetcode.com/problems/maximum-units-on-a-truck

description

boxTypes 배열이 주어진다. 각 배열의 원소는 쌍 [x, y]로 이루어져있는데 x는 해당 인덱스의 박스의 개수이고 y는 박스 안에 든 unit의 개수이다.
이때 truckSize만큼 채워서 가져갈 수 있는 최대 unit의 개수를 구한다.

해결 방안
박스 안에 Unit개수를 내림차순으로 정렬하면 최대 unit 개수를 구할 수 있다.
truckSize를 고려하여 중단점을 설정하면 좋다. 
문제를 풀땐 out of range도 신경쓰자.
"""

class Solution:
    def maximumUnits(self, boxTypes: List[List[int]], truckSize: int) -> int:
        # boxTypes : [[number of box, box per unit]]
        boxes = sorted(boxTypes, reverse=True, key=lambda p : p[1])
        
        answer = 0
        i = 0
        while i < len(boxes) and truckSize > 0:
            if truckSize < boxes[i][0]:
                answer += truckSize * boxes[i][1]
                break
            answer += boxes[i][0] * boxes[i][1]
            truckSize -= boxes[i][0]
            i += 1

        return answer