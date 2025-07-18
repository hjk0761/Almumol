# Info
[보석 도둑](https://boj.kr/1202)

- 난이도: 골드 2
- 분류: 자료 구조, 그리디 알고리즘, 정렬, 우선순위 큐

## 💡 풀이 방법 요약

그리디 문제 입니다.

작은 가방부터 그 가방에 들어갈 수 있는 최대 가치의 보석을 넣으면 됩니다.

이를 위해 가방과 보석(입력한 대로 무게, 가치 순)을 모두 오름차순으로 정렬한 후 각 가방을 순회하면서,

가방의 무게보다 작은 보석들을 모두 우선순위 큐에 넣어준 후, 가방에 들어갈 수 있는 보석 모두 큐에 들어갔을 때 큐에서 최대 가치의 보석 하나를 뽑았습니다.

여기서 큐를 다음 가방에서도 재사용해 가령 무게는 낮지만 가치가 더 큰 보석을 다음 가방에서도 고려할 수 있도록 했습니다.

## 👀 실패 이유

처음엔 가방과 보석 모두 정렬된 상태에서, 이전 가방에 들어가지 않은 보석들은 다음 가방에 들어갈 수 없다고 생각했습니다.

그래서 가방과 보석을 정렬한 후, 보석을 하나씩 pop하면서 가방보다 크면 버리고, 작으면 넣고 다음 가방을 확인했습니다.

## 🙂 마무리
