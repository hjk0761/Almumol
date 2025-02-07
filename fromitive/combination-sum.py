""" 
title: Combination Sum
link : https://leetcode.com/problems/combination-sum

description

target과 canditate가 주어질때 candidate의 중복을 허용하여 target number가 되도록 하는 모든 조합을 출력하자 

해결 방안

중복을 허용하게 만들려면 시작 index와 다음 index의 관계가 중요하다 다음 index가 시작 index + 1이면 절대 돌아가지 않겠다는 의미이고
시작 index와 다음 index가 같다면 중복을 허용하여 백트레킹을 하겠다는 의미이다.
"""

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        def backtrack(current, start, path):
            if current == target:
                answer.append(path[:])
                return 
            for i in range(start, len(candidates)):
                num = candidates[i]
                if current + num <= target:
                    path.append(num)
                    backtrack(current + num, i, path)
                    path.pop()
        answer = []
        backtrack(0, 0, [])

        return answer