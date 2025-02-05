"""
title: Search a 2D Matrix
link : https://leetcode.com/problems/search-a-2d-matrix/description/

description

2차원 배열 Matrix가 주어진다. 이때 각 row는 내림차순으로 정렬되어 있는 리스트이며 row의 마지막 원소는 다음 Row의 Element보다 무조건 작다

이때 정수 target이 Matrix에 있을 경우 True 그렇지 않으면 False를 출력하자.

해결 방안.

target이 row안에 있는 배열 범위에 포함되었는지 확인하는 코드를 작성한 후 binary_search를 이용해서 해당 배열안에 Target이 있는지 확인한다.

그렇게 하면 O(len(row) * log len(col)) 의 시간복잡도로 target을 찾을 수 있다.

또한 2D matrix를 1d로 바꿀 수 있는데 len(col) * len(row) - 1 이 matrix의 끝 Index로 지정하고 row 는 // len(col) col 은  % len(col)해주면 이 차원 좌표를 구할 수 있다.
"""

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        def binary_search(target, arr):
            left = 0
            right = len(arr) - 1
            while left <= right:
                mid = (left + right) // 2
                if arr[mid] == target:
                    return mid
                if target > arr[mid]:
                    left = mid + 1
                elif target < arr[mid]:
                    right = mid - 1
            return -1
        for r in range(len(matrix)):
            if matrix[r][0] <= target <= matrix[r][-1]:
                if binary_search(target, matrix[r]) == -1:
                    return False
                return True
        return False
    
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])                   
        left = 0
        right = m * n - 1
        while left <= right:
            mid = (left + right) // 2
            row = mid // n
            col = mid % n
            num = matrix[row][col]
            if target == num:
                return True
            if target < num:
                right = mid - 1
            elif target > num:
                left = mid + 1
        return False