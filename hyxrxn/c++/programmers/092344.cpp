#include <vector>
using namespace std;

int arr[1001][1001] = {0};

int solution(vector<vector<int>> board, vector<vector<int>> skill) {
    int r = board.size();
    int c = board[0].size();

    int r1, c1, r2, c2, degree;
    for (int i = 0; i < skill.size(); i++) {
        r1 = skill[i][1];
        c1 = skill[i][2];
        r2 = skill[i][3];
        c2 = skill[i][4];
        degree = skill[i][5];
        if (skill[i][0] == 1) { // 적
            arr[r1][c1] -= degree;
            arr[r1][c2 + 1] += degree;
            arr[r2 + 1][c1] += degree;
            arr[r2 + 1][c2 + 1] -= degree;
        } else { // 아군
            arr[r1][c1] += degree;
            arr[r1][c2 + 1] -= degree;
            arr[r2 + 1][c1] -= degree;
            arr[r2 + 1][c2 + 1] += degree;
        }
    }

    for (int i = 0; i < r; i++) {
        for (int j = 1; j < c; j++) {
            arr[i][j] += arr[i][j - 1];
        }
    }

    for (int i = 0; i < c; i++) {
        for (int j = 1; j < r; j++) {
            arr[j][i] += arr[j - 1][i];
        }
    }

    int answer = 0;
    for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
            if (board[i][j] + arr[i][j] > 0) {
                answer++;
            }
        }
    }

    return answer;
}
