"""  
title: Longest Increasing Subsequence
link : https://leetcode.com/problems/longest-increasing-subsequence/

description

배열 Nums가 있을 때 가장 긴 subsequence의 길이를 구하자.

해결 방안

array의 subsequence란 array안의 원소로 이루어져 있으나 순서가 보장되어 있고 일부 원소가 생략 되어있는 subset이다.

예를 들어 [1,2,3,4,5] array가 있을때 subSequence는 [1,2,4], [1,2,5] 처럼 순서가 보장되고 원소가 생략되어있는 상태이다.

subsequence의 최대 길이를 구하기 위해선 몇가지 방법이 있는데, 그 중 다이나믹 프로그래밍을 이용해서 해결 가능하다.

현재 탐색하는 원소 뒤의 원소들을 비교하며 뒤에 있는 원소 보다 현재 있는 원소가 크면 현재 원소 + 1의 길이가 되는 것이므로 이를 누적해서 구한 후 최대 값을 구하면 된다.
"""

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        dp = [1] * len(nums) # base case 원소가 1개만 허용되는 경우
        for i in range(len(nums)):
            for j in range(i): # i 번째 보다 이전 원소 탐색
                if nums[j] < nums[i]:
                    dp[i] = max(dp[i], dp[j] + 1) # 항상 최대값을 유지
        
        return max(dp) #최대 길이 반환