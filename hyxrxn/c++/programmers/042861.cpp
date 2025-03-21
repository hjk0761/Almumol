#include <vector>
#include <algorithm>
using namespace std;

int parent[100];

int find(int n) {
    if (parent[n] == n) {
        return n;
    }
    return find(parent[n]);
}

int solution(int n, vector<vector<int>> costs) {
    int answer = 0;

    for (int i = 0; i < costs.size(); i++) {
        int dummy = costs[i][2];
        costs[i][2] = costs[i][0];
        costs[i][0] = dummy;
    }
    sort(costs.begin(), costs.end()); // 건설 비용이 적은 순으로 정렬

    for (int i = 0; i < n; i++) {
        parent[i] = i;
    }

    int count = 1;
    for (int i = 0; i < costs.size(); i++) {
        if (find(costs[i][1]) != find(costs[i][2])) {
            answer += costs[i][0];
            parent[find(costs[i][1])] = parent[find(costs[i][2])];
            count++;
        }

        if (count == n) {
            break;
        }
    }

    return answer;
}
