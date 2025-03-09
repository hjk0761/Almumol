#include <string>
#include <vector>
using namespace std;

int water[101][101] = {0};
int number[101][101] = {0};

int solution(int m, int n, vector<vector<int>> puddles) {
    for (int i = 0; i < puddles.size(); i++) {
        water[puddles[i][0]][puddles[i][1]] = 1;
    }

    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (i == 1 && j == 1) {
                number[i][j] = 1;
            } else if (water[i][j] == 0) {
                number[i][j] = (number[i - 1][j] + number[i][j - 1]) % 1000000007;
            }
        }
    }

    return number[m][n];
}
