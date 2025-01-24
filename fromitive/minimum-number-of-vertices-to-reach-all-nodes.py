""" 
title : Minimum Number of Vertices to Reach
link : https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes

description

directed acyclic 그래프가 주어진다. 그래프는 [x,y] 형태의 원소로 이루어져 있는데 x에서 y로가는 간선 정보를 가지고 있다.

모든 노드에 방문하기 위해 처음을 방문해야 할 최소 노드들을 구해야 한다.

해결 방안

처음으로 방문해야할 node는 **[x, y]에서 y로 뻗어지지 않는 node** 여야만 최소 노드를 구할 수 있다.

결론은 시작 노드로부터 뻗어나가는 간선만 가지고 있는 node인 indegree node를 구하는 문제이다.

주의할 점은 dges에 정보가 존재하지 않은 vertice를 포함해서 구해야만 한다.
"""

class Solution:
    def findSmallestSetOfVertices(self, n: int, edges: List[List[int]]) -> List[int]:
        indegree = [0] * n
        for _, y in edges:
            indegree[y] += 1
        return [node for node in range(n) if indegree[node] == 0]

