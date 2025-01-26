"""
title : Next Greater Element I
link  : https://leetcode.com/problems/next-greater-element-i

description

num1 은 num2의 subArray이다. 

num1의 각 원소들 다음으로 큰 원소를 num2에서 찾아서 반환해야한다. 다음으로 큰 원소가 없으면 -1을 대신 넣는다.

얘를들어 nums1 = [4, 1, 2] , nums2 = [1, 3, 4, 2] 일때 [-1, 3, -1]을 출력해야 한다.
nums1[0] = 4이고 nums2에서의 Index는 2이다. nums2 에서 4 이후 4 다음으로 큰 원소는 존재하지 않기 때문에 -1을 기입한다.
nums1[1] = 1이고 nums2에서의 Index는 0이다. nums2 에서 1 이후 1 다음으로 큰 원소는 3이므로 3을 기입한다. 
nums1[2] = 2이고 nums2에서의 Index는 3이다. nums2 에서 2 이후 2 다음으로 큰 원소는 존재하지 않기 때문에 -1을 기입한다.

해결 방안
1. nums2의 각 원소들의 nextGreater를 찾을 수 있는 방법이 있다.
2. nums2의 각 원소들의 index를 저장하는 방법이 있다.
"""
class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        stack = []
        priority = [-1] * len(nums2)
        mapper = {}

        for i in range(len(nums2)):
            while stack and nums2[stack[-1]] < nums2[i]:
                j = stack.pop()
                priority[j] = i
            stack.append(i)
            mapper[nums2[i]] = i

        answer = []
        for num in nums1:
            nextGreaterIndex = priority[mapper[num]]
            answer.append(-1 if nextGreaterIndex == -1 else nums2[nextGreaterIndex])
        
        return answer
