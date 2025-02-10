""" 
title: Successful Pairs of Spells and Potions
link : https://leetcode.com/problems/successful-pairs-of-spells-and-potions

description

spells와 potions가 주어진다. 이때 spells안에 있는 주문 세기를 각 potions 원소를 곱하여 success기준이 넘는 각 Spell마다 potion 개수를 구한다.

spells가 [5,1,3] Potions가 [1,2,3,4,5]가 주어지면 
Spell = 5일 때 각 포션의 효과는 [5, 10, 15, 20, 25, 30] 이다. 이때 success가 15면 4개의 포션만이 성공한 것이다.
Spell = 1일 때 각 포션의 효과는 [1, 2, 3, 4, 5] 이다. 이때 success가 15면 0개의 포션만이 성공한 것이다.
Spell = 3일 때 각 포션의 효과는 [3, 6, 9, 12, 15] 이다. 이때 success가 15면 1개의 포션만이 성공한 것이다.

따라서 해답은 [4, 0, 1]이 나타나게 된다.
"""

class Solution:
    def successfulPairs(self, spells: List[int], potions: List[int], success: int) -> List[int]:
        potions.sort()
        answer = []
        def findSuccessfulSpell(potions, success):
            left = 0
            right = len(potions)
            while left < right:
                mid = (left + right) // 2
                if success <= potions[mid]:
                    right = mid
                else:
                    left = mid + 1
            return len(potions) - left
        for spell in spells:
            answer.append(findSuccessfulSpell(potions,  success / spell))
        return answer
