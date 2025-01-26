"""
title : Daily Temperatures
link  : https://leetcode.com/problems/daily-temperatures

description
날짜별 기온을 기록한 배열 temperatures가 주어진다. 기간은 오름차순으로 기록되어 있다.
temperatures안의 각 일일 기온보다 높아지는 최초 기간을 구해야 한다. 만약 해당 기온보다 높은 날이 없다면 0을 대신 넣는다.

예를 들어 temperatures가 = [73,74,75,71,69,72,76,73] 이면 temperatures[2]보다 커지는 날은  temperatures[6] 이므로
answer[2]에는 4가 들어가야 한다.

해결 방안
순차적 temperatures 안의 기온들을 검사해야 하는 문제이며, 현재 인덱스 이전 값들의 상대 값을 비교하는 유형이다.
이때 단조 스택을 사용할 수 있다. 기온 값을 내림차순으로 쌓다가 마지막으로 넣은 원소가 현재 원소보다 작을 때 전부 스택에서 빼면서 상대 값을 구한다. 
"""


class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        answer = [0] * len(temperatures)
        stack = []
        for i in range(len(temperatures)):
            while stack and temperatures[stack[-1]] < temperatures[i]:
                j = stack.pop()
                answer[j] = i - j
            stack.append(i)
        return answer