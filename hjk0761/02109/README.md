# Info
[순회강연](https://boj.kr/2109)

- 난이도: 골드 3
- 분류: 자료 구조, 그리디 알고리즘, 정렬, 우선순위 큐

## 💡 풀이 방법 요약

그리디 문제입니다.

d일 안에 강연을 하면 p만큼의 강연료를 받습니다.

이는 특정 i일에 i일을 포함하여 그 이후의 날에 끝내야 하는 강연 중 가장 강연료가 높은 강연을 선택하는 것이 최선의 선택입니다.

특정 날짜의 최선의 선택은 그 날짜를 포함한 이후의 강연들에 영향을 받으므로 날짜를 뒤에서부터 세서 해당 날짜까지의 강연료를 우선순위 큐에 모두 넣은 후,

최대힙으로 하나를 빼면 그 값이 그 날에 할 수 있는 최대 강연료입니다.

## 👀 실패 이유

96퍼에서 인덱스 에러가 발생했는데, n이 0일 수 있었습니다.

당연히 n이 1부터일줄 알았는데, 문제를 잘 읽어야 하겠네요.

## 🙂 마무리
