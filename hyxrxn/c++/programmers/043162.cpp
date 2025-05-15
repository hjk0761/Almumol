#include <string>
#include <vector>

using namespace std;

int visit[200] = {0};
vector<vector<int>> computers2;

void go(int current, int n) {
    visit[current] = 1;
    for (int i = 0; i < n; i++) {
        if (visit[i] == 0 && computers2[current][i] == 1) {
            go(i, n);
        }
    }
}

int solution(int n, vector<vector<int>> computers) {
    computers2 = computers;
    int answer = 0;
    for(int i = 0; i < n; i++) {
        if (visit[i] == 0) {
            answer++;
            go(i, n);
        }
    }

    return answer;
}
