"""
title: Solving Questions With Brainpower
link : https://leetcode.com/problems/solving-questions-with-brainpower

description

원소가 페어인 배열 questions가 주어질 때 최대로 얻을 수 있는 점수 계산해서 반환해야 한다.

question은 0번부터 순차적으로 풀어야 하며 각 원소의 값은 [점수, 브레인파워]로 구성되어 있다.

포인트는 현재 문제를 풀어서 획득할 수 있는 점수이며, 문제를 풀 경우 앞의 브레인파워 만큼의 문제를 풀 수 없게 된다. 

문제를 푸는 참가자는 현재 문제를 풀거나 건너뛸 수 있다. 

해결 방안

문제는 0번부터 풀어야 하므로 정렬 후 큰 점수를 얻는 순서대로 풀 수 없다. 또한 브레인파워에 따라 문제를 생략하므로 문제 선택도 여러가지 경우의 수를 고려해야 한다.

참여자는 1. 현재 문제를 풀거나, 2. 건너뛸 수 있으므로 이에 대한 점화식을 작성하여 구현한다.

현재의 최선 = max(현재 문제 풀기 + dp(현재 index + 브래인파워), dp(현재 index + 1))
"""

class Solution:
    def mostPoints(self, questions: List[List[int]]) -> int:
        if len(questions) == 1:
            return questions[0][0]

        dp = dict()

        def dfs(i):
            if i >= len(questions):
                return 0

            if i in dp:
                return dp[i]
            dp[i] = max(questions[i][0] + dfs(i + questions[i][1] + 1), dfs(i + 1))
            return dp[i]

        return dfs(0)