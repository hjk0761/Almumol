"""
title : Contiguous Array
link  : https://leetcode.com/problems/contiguous-array

description

0과 1로 이루어진 배열 nums가 주어졌을 때, 0과 1의 개수가 같은 contiguous subArray의 최대 길이를 구해야한다.

해결 방안

최대길이를 구하기 위해선 0과 1의 개수를 추적할 수 있어야 한다.

prefix Sum을 응용하면 해결 가능하다.

nums의 원소가 0일 땐 -1, 1일땐 0을 누적해서 더하고, 해당 값을 Key로 갖는다 그리고, Value에 지금까지 탐색한 index값을 저장한다.

또 한번 같은 키가 나올 수 있다. 그러나, 우리의 목표는 제일 길이가 긴 subArray를 구해야 하므로 업데이트하지 않는다.

counter의 초기값은 {0: -1}로 지정한다. 왜냐하면 0이 나타난다면 0의 개수와 1의개수가 동일한 의미이기 때문에 해당 Index에서 -1을 빼면 바로 배열의 길이를 구할 수 있기 때문이다.
"""

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return 0
        counter = { 0 : -1}
        answer = 0
        currentSum = 0
        for right in range(len(nums)):
            currentSum += 1 if nums[right] == 1 else -1
            if currentSum in counter:
                answer = max(answer, right - counter[currentSum])
            else: # not in
                counter[currentSum] = right
        return answer
