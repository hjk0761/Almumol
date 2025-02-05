""" 
title: Partition Array Such That Maximum Difference Is k
link : https://leetcode.com/problems/partition-array-such-that-maximum-difference-is-k

description

정부 배열 nums와 음이 아닌 정수 k가 주어질 때 최소한의 subsequence 개수를 구한다. 
subsequence는 최대 값과 최소값의 차이가 주어진 수 k 보다 작거나 같아야 한다.

subsequence는 배열안에 있는 원소가 순서에 상관없이 포함되어 있는 하위 배열이다.

해결 방안

이전의 선택이 다음의 결과에 영향을 미치지 않으니, 최대값을 늘리면서 k 보다 커지는 시점에 나누면 된다. 
"""

class Solution:
    def partitionArray(self, nums: List[int], k: int) -> int:
        nums.sort()
        left = 0
        right = 0
        answer = 1
        while right < len(nums):
            if nums[right] - nums[left] > k:
                left = right
                answer += 1
            right += 1
        return answer 
