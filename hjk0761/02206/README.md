# Info
[벽 부수고 이동하기](https://boj.kr/2206)

- 난이도: 골드 3
- 분류: 그래프 이론, 그래프 탐색, 너비 우선 탐색

## 💡 풀이 방법 요약

너비 우선 탐색을 통해 최단 거리를 찾았습니다.

벽을 한 번 뚫을 수 있기 때문에 방문 처리 및 최단 거리를 가지는 배열을 기존 2차원 좌표에서 벽을 뚫었는지 여부에 따라 1차원을 더해 주었습니다.

따라서 이동할 좌표가 1인 경우 이전 좌표가 벽을 뚫지 않은 상태에서만 갈 수 있도록 해주었습니다.

## 👀 실패 이유

처음엔 bfs 에서 큐에 3차원의 값을 사용했습니다.

이동할 곳의 y 좌표, x 좌표, 그리고 벽을 뚫었는지 여부를 사용했는데,

이 경우 메모리 초과와 시간 초과 그리고 틀렸습니다 를 모두 봤습니다.

큐에 중복된 값이 들어갈 수 있어서 메모리 초과 한 번, 이로 인해 반복되는 루프가 발생하여 시간 초과 한 번,

벽을 뚫고 간 길이 안 뚫고 간 길보다 짧을 경우 갱신이 되지 않아 틀렸습니다 한 번을 보았습니다.

그래서 아예 방문 처리 및 최단 거리를 가지는 배열을 3차원으로 늘리고 큐에선 2차원 좌표만을 가지도록 바꾸었습니다.

## 🙂 마무리

bfs 도 뇌를 빼고 구현하면 발 걸릴 부분이 많네요.

특히 방문 처리에 따라 큐에 중복된 좌표가 들어가는 부분은 시간 초과를 가져오기 정말 쉬운 부분 같습니다.
