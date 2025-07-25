# Info
[와드](https://boj.kr/23747)

- 난이도: 골드 5
- 분류: 구현, 그래프 이론, 그래프 탐색, 시뮬레이션, 너비 우선 탐색, 격자 그래프, 플러드 필

## 💡 풀이 방법 요약

그래프 탐색입니다.

분류에 플러드 필이 처음보는 건데, 연결된 같은 색으로 된 부분을 채우는 문제를 의미합니다.

이 문제는 이동하면서 와드를 놓는 경우 같은 구역의 모든 칸의 시야를 얻는 문제입니다.

따라서 움직이면서 와드를 놓을 때 이미 시야를 얻은 구역이면 넘어가고, 아니라면 bfs를 통해 같은 구역을 찾아 모두 시야를 얻으면 됩니다.

움직이면서 얻게 된 시야는 유지되는 게 아니고 마지막 위치에서 사방의 시야를 가지는 것만 주의하면 됩니다.

## 👀 실패 이유

처음엔 이미 시야가 확보된 구역도 bfs 를 돌아 시간 초과가 발생했습니다.

## 🙂 마무리
