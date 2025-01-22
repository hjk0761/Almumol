""" 
title : Number of Provinces
link  : https://leetcode.com/problems/number-of-provinces

description

n 개의 도시가 있다. 도시의 연결 정보를 담은 2차원 배열인 isConnected가 주어진다. 
isConnected[i][j] 에는 i 번째 도시와 j 번째 도시의 연결 정보가 들어있다. 0이면 i와 j는 연결되어 있지 않은 것이고 1이면 연결 되어 있는 것이다.

이때 도시들이 서로 연결된 군집을 province라고 할때 isConnected안의 province의 개수를 구해야 한다.

해결 방안

각 도시별로 연결 정보를 담은 그래프를 구현한다.
도시별 연결 도시를 탐색하고 같은 도시를 방문하지 않기 위해 seen에 저장한다.
각 도시를 순회 할 때마다 도달할 수 없는 도시들의 개수를 더하면 province의 개수가 나온다.

그래프를 만들 때 hashmap을 이용한다. 해시맵은 {도시: 연결된 도시}로 생성한다.
isConnected[i][i] 정보는 항상 1 이다 (1번째 도시와 1번째 도시는 연결되어 있다.), isConnected[i][j] == isConnected[j][i] 이므로 도시를 순회할 때마다 시작 index를 + 1 늘린다.

그래프를 탐색하기 위한 dfs 함수를 만든다. (bfs, dfs 상관 없다. 그러나 bfs가 더 빠르다) 
함수의 매개변수는 순회할 도시의 시작점으로 설정한다. 
다음 도시로 이동하기 전 이미 방문한 도시는 방문하지 않기 위해 seen에 해당 도시가 있는지 확인한다.

마지막으로 위의 함수를 이용해 각 도시별로 방문하여 연결되어 있지 않아 방문하지 않은 도시들의 개수를 새면 정답이 나타난다. 
"""
from collections import defaultdict, deque
class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        def buildGraph(isConnected):
            graph = defaultdict(list) # {city : [nextcities]}
            for row in range(len(isConnected)):
                for column in range(row + 1, len(isConnected)):
                    if isConnected[row][column] == 1:
                        graph[row].append(column)
                        graph[column].append(row)
            return graph
        graph = buildGraph(isConnected)
        seen = set()
        def bfs(start, graph):
            queue = deque()
            queue.append(start)
            nonlocal seen
            while queue:
                vertex = queue.popleft()
                for neighbor in graph[vertex]:
                    if neighbor not in seen:
                        seen.add(neighbor)
                        queue.append(neighbor)

        province = 0
        for city in range(len(isConnected)):
            if city not in seen:
                province += 1
                bfs(city, graph)

        return province