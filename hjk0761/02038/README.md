# Info
[골롱 수열](https://boj.kr/2038)

- 난이도: 골드 1
- 분류: 수학, 다이나믹 프로그래밍

## 💡 풀이 방법 요약

dp 문제 입니다.

골롱 수열은 점화식이 이미 잘 알려진 수열입니다.

따라서 이를 이용해 풀었습니다.

다만, n의 제한이 너무 커서 그냥 구하게 되면 분명 메모리 초과 혹은 재귀 초과가 발생합니다.

따라서 골롱 수열의 특징을 좀 더 살펴봐야 합니다.

골롱 수열은 1, 2, 2, 3, 3, 4, 4, 4, 로 정해지는데, 이 때 각 숫자를 숫자가 나타나는 횟수로 묶게 되면 1*1, 2*2, 3*2, 4*3, 5*3, 가 되고, 여기서 같은 횟수만큼 나타나는 숫자를 잘 살펴보면 1번 나타나는 숫자는 1개, 2번 나타나는 숫자는 2개, 3번 나타나는 숫자는 2개, 4번 나타나는 숫자는 3개, 가 되어 골롱 수열이 다시 한 번 나타남을 알 수 있습니다.

즉, 골롱 수열에서 n은 1부터 f(n)까지의 골롱 수열의 값을 더한 값보다 작거나 같게 됩니다.

여기서 힌트를 얻어 점화식을 통해 적당한 값까지 골롱 수열을 구해준 후, 이를 더해가면서 n보다 합이 같거나 커지는 순간에 인덱스를 반환했습니다.

## 👀 실패 이유

n이 2,000,000,000인걸 알고 있었어도 그냥 그대로 구현을 해봤습니다.

메모리 초과가 발생하는게 당연했죠.

이후로 풀이 방법을 바꾸고 dp의 범위를 늘려가면서 제출했습니다.

## 🙂 마무리

점화식이 알려져 있음에도 다른 풀이를 살펴보니 점화식을 사용하지 않고도 푸는걸 봤습니다.

다른 풀이를 떠올릴 수 있는게 중요할 것 같습니다.

실전에선 점화식을 찾아볼 수 없을테니까요.
