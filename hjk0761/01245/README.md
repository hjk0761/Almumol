# Info
[농장 관리](https://boj.kr/1245)

- 난이도: 골드 5
- 분류: 그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색

## 💡 풀이 방법 요약

DFS 를 통해 풀 수 있었습니다.

모든 좌표를 탐색하면서 주변 좌표에서 더 높은 좌표가 있으면 false, 없으면 true 로 확인하여 봉우리인지를 확인합니다.

또한 같은 높이의 좌표들을 모두 방문처리하면서 봉우리를 중복으로 탐색하지 않도록 해주었습니다.

## 👀 실패 이유

깊이 우선 탐색을 수행할 때에 반복 시작 시에 방문 처리를 하는 것과, 새로운 좌표로 재귀를 돌기 전에 방문 처리를 하는 것에 차이가 있더라고요.

## 🙂 마무리
