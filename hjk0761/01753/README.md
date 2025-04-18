# Info
[최단경로](https://boj.kr/1753)

- 난이도: 골드 4
- 분류: 그래프 이론, 최단 경로, 데이크스트라

## 💡 풀이 방법 요약

음의 간선이 없는 그래프에서 최소 비용 = 다익스트라 입니다.

일반적인 다익스트라 구현인데, 조금 다른 점은 같은 시작점과 끝점을 가진 간선이 여러 개 들어올 수 있다는 점인데,

이는 그래프에서 정점에서 간선을 탐색할 때에 가중치가 작은 간선먼저 확인하도록 하면 됩니다.

같은 정점으로의 간선을 여러 번 확인할 순 있겠지만, 최단거리 갱신이 되지 않아 우선순위 큐에 삽입되지 않기 때문입니다.

## 👀 실패 이유

다익스트라를 수행하면서 다음 탐색 노드를 찾을 때에 우선순위 큐를 통해서 제일 비용이 적은 노드부터 탐색해야 했는데, 이를 지키지 않아 틀렸습니다.

## 🙂 마무리
