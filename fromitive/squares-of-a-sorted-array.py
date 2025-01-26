"""
title : Squares of a sorted array
link  : https://leetcode.com/problems/squares-of-a-sorted-array

description

`nums`는 오름차순으로 정렬된 정수 배열이다.

`nums`의 각 요소의 제곱을 가진 array를 오름차순 형태로 반환한다.  

example : 

input = [-4, -1, 0, 2, 3]

output = [0, 1, 4, 9, 16]

해설 : 인풋의 각 제곱의 배열은 [16, 1, 0, 4, 9] 이고 이를 정렬하면 [0, 1, 4, 9, 16]가 나온다.

해결 방안

각 요소를 제곱하고 정렬하면 O(n) + O(nlogn) 이 나온다. 이를 어떻게 최적화 할 수 있을까?

힌트는 nums가 정렬되어있음을 이용하는 것이다. 

정렬되어 있다는 것은 배열의 처음과 끝의 값의 절대값이 제일 큰 상태를 의미한다.

가운데로 갈 수록 절대값의 크기는 작아지므로 이러한 성질을 이용하여 two-pointer를 쓸 수 있다.

two-pointer로 양 끝의 숫자를 비교하여 크기가 큰 배열을 "뒤에서 부터 채워나간다"

앞 부터 채워나가지 못하는 이유는 절대값의 가장 작은 값이 가운데에 있기 때문이다. 

[-1, 0, 2] 를 예를 들자면 처음엔 1 과 2를 비교하여 1을 앞에서 채워넣으면 그 이후 비교할 대상이 0이 나오게 된다.

0은 예제에서 절대값 중 가장 작은 값이며 맨 처음 넣었던 1 보다 앞에 채워져야 한다. 

작은 값 기준으로 넣게 되면 작은값이 어느 위치에 넣어야 할 지 판단을 할 수 없게 된다.
"""  
from typing import List

class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        left = 0
        right = len(nums) - 1
        result = list()
        while left < right:
            squareLeft = nums[left] ** 2
            squareRight = nums[right] ** 2
            if max(squareLeft, squareRight) == squareLeft:
                result.append(squareLeft)
                left += 1
                continue
            if max(squareLeft, squareRight) == squareRight:
                result.append(squareRight)
                right -= 1
                continue
            if squareLeft == squareRight and left != right:
                result.append(squareLeft)
                result.append(squareRight)
                continue    
        result.append(nums[left] ** 2) # left == right
        return result[::-1]

    def editorialsortedSquares(self, nums: List[int]) -> List[int]:
        left = 0
        right = len(nums) - 1
        result = [0] * len(nums)

        for index in range(len(nums) -1 , -1, -1):
            if abs(nums[left]) < abs(nums[right]):
                result[index] = nums[right]
                right -= 1
            else: # nums[left] >= nums[right]
                result[index] = nums[left]
                left += 1
            result[index] = result[index] ** 2
        return result
