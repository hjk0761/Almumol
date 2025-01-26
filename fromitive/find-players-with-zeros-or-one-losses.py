
"""
title : Find Players With Zero or One Losses
link  : https://leetcode.com/problems/find-players-with-zero-or-one-losses

description

각 원소가 (승자, 패자)로 구성되어 있는 matches 배열이 주어진다. 이때 지지 않거나, 1번 진 player 목록을 오름차순 순으로 정렬된 배열을 구해야 한다. 
즉, 결과 값은 [[하나도 안 진 플레이어들],[1번 진 플레이어들]]로 반환한다.

"""

class Solution:
    def findWinners(self, matches: List[List[int]]) -> List[List[int]]:
        counter = {}
        for winner, loser in matches:
            counter[loser] = counter.get(loser, 0) + 1
            counter[winner] = counter.get(winner, 0)

        zeroLoser = []
        oneLoser = []
        
        for player, loseCount in counter.items():
            if loseCount == 0:
                zeroLoser.append(player)
            if loseCount == 1:
                oneLoser.append(player)
        return [sorted(zeroLoser), sorted(oneLoser)]