# Info
[택배](https://boj.kr/8980)

- 난이도: 골드 1
- 분류: 그리디 알고리즘, 정렬

## 💡 풀이 방법 요약

그리디 문제입니다.

이 문제는 택배를 받는 마을이 낮은 순으로 택배를 먼저 쌓으면 됩니다.

그 이유는, i 마을에서 트럭에 x 만큼의 여유가 있을 때에 j < k 인 두 마을로 택배를 보내야 하는 상황을 가정해 보겠습니다.

이 때 k 마을로 택배를 보내기 위해 x 만큼의 공간을 사용하는 것 보다, j 마을로 택배를 보내기 위해 x 만큼의 공간을 사용하는 것이 j < t < k 인 마을에서 다른 택배를 처리할 수 있으므로 항상 앞선 마을을 향하는 택배를 먼저 담는 것이 같거나 유리합니다.

따라서 도착 마을 기준으로 오름차순으로 정리한 후, 그리디하게 공간이 남으면 택배를 담으면 됩니다.

## 👀 실패 이유

## 🙂 마무리
