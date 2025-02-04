""" 
title: Maximum Ascending Subarray Sum
link : https://leetcode.com/problems/maximum-ascending-subarray-sum

description

nums가 주어질 때 오름차순을 만족하는 subArray의 최대 합을 구한다.

해결 방안

stack을 사용하면 가독성 있게 해결할 수 있다. 현재 검사하고 있는 num 값이 stack보다 작으면 stack을초기화 하고 새로 쌓는다.
이렇게 새로 쌓는 stack마다 answer를 구한다.
"""

class Solution:
    def maxAscendingSum(self, nums: List[int]) -> int:
        localMax = 0
        answer = 0
        for num in nums:
            if stack and stack[-1] >= num:
                stack = []
            stack.append(num)
            answer = max(answer, sum(stack))
        return answer