#include <iostream>
using namespace std;

int n;
long long r, c;
long long nowSize = 1;
long long answer = 0;

void cal() {
    if (nowSize == 1) {
        return;
    }

    nowSize /= 2;
    if (0 <= r && r < nowSize) {
        if (0 <= c && c < nowSize) { // 왼쪽위
        } else { // 오른쪽위
            answer += nowSize * nowSize;
            c -= nowSize;
        }
    } else {
        if (0 <= c && c < nowSize) { // 왼쪽아래
            answer += nowSize * nowSize * 2;
            r -= nowSize;
        } else { // 오른쪽아래
            answer += nowSize * nowSize * 3;
            r -= nowSize;
            c -= nowSize;
        }
    }
    cal();
}

int main() {
    cin >> n >> r >> c;
    for (int i = 0; i < n; i++) {
        nowSize *= 2;
    }

    cal();

    cout << answer;
    return 0;
}

// https://www.acmicpc.net/problem/1074

// 사등분해서 각 위치별로 더해지는 양을 찾았습니다.
// 해당 양을 더한 다음, 한 변의 길이가 절반인 작은 사각형으로 모양을 바꿉니다!
// 그러기 위해서 r과 c를 조작합니다.
// 계속 작게 작게 만들다가 한 변의 길이가 1인 정사각형이 되면 그만둡니다.
// 예를 들어, 3 3 5 라면
// 처음 사각형을 4개로 나누면 오른쪽 위에 3행 5열이 존재합니다.
// 답에 4*4 인 16을 더하고, 해당 칸이 있는 사각형만 봅니다.
// 그렇다면 한 변의 길이가 4인 사각형에서 3행 1열의 위치를 찾아야 하네요.
// 사각형을 4개로 나누면 왼쪽 아래에 3행 1열이 존재합니다.
// 답에 2*2*2 인 8을 더하고, 또다시 해당 칸이 있는 사각형을 봅니다.
// 한 변의 길이가 2인 사각형에서 1행 1열의 위치를 찾아야 합니다.
// 사각형을 4개로 나누면 오른쪽 아래에 1행 1열이 존재합니다.
// 답에 1*1*3 인 3을 더합니다.
// 해당 칸이 있는 사각형의 크기가 1이 되었으므로 멈춥니다.
// 답은 27이 되겠네용!
