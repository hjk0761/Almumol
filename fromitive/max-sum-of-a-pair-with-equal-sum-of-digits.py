"""
title : Max Sum of a Pair With Equal Sum of Digit
link  : https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits

description

양의 정수 배열 nums에 자릿수의 합이 같은 두 수 nums[i],nums[j]를 선택하고 nums[i] + nums[j]의 최대값을 구한다. 
자릿수의 합이 같은 두 수가 없을 경우 -1 을 반환한다.

해결 방안

nums를 시작지점 부터 탐색하여 자릿수 별 최대값을 저장하는 해시맵을 사용한다.
"""

class Solution:
    def maximumSum(self, nums: List[int]) -> int:
        def getSumOfDigit(num):
            result = 0
            while num != 0:
                result += num % 10
                num = num // 10
            return result
        hashTable = {}
        answer = -1
        for num in nums:
            s = getSumOfDigit(num)
            if s in hashTable:
                answer = max(answer, hashTable[s] + num)
            hashTable[s] = max(hashTable.get(s, 0), num)
        return answer
    # 반복문 한번에 계산하는것 보다 sort하는게 더 빠름. 왜????
    def maximumSum(self, nums: List[int]) -> int:
        def getSumOfDigit(num):
            result = 0
            while num != 0:
                result += num % 10
                num = num // 10
            return result
        hashTable = defaultdict(list)
        answer = -1
        for num in nums:
            s = getSumOfDigit(num)
            hashTable[s].append(num)
        for s in hashTable:
            nums = sorted(hashTable[s], reverse = True)
            if len(nums) > 1:
                answer = max(answer, nums[0] + nums[1])
        return answer
            