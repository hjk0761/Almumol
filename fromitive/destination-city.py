"""
title: Destination City
link : https://leetcode.com/problems/destination-city/

description

여행 경로 paths 배열이 주어진다. paths의 원소는 [cityA, cityB]로 주어지며 cityA에서 cityB로 이동가능함을 의미한다.

이 때 paths의 최종 목적지를 구해야 한다.

해결 방안

hashMap을 사용하면 O(paths)의 시간복잡도를 유지하며 해결 가능하다.
"""

class Solution:
    def destCity(self, paths: List[List[str]]) -> str:
        hashMap = {}
        for path in paths:
            hashMap[path[0]] = path[1]

        for value in hashMap.values():
            if value not in hashMap:
                return value
        return ""