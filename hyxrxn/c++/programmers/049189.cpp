#include <vector>
#include <queue>
using namespace std;

bool visit[20001] = {false};

int solution(int n, vector<vector<int>> edge) {
    vector<vector<int>> info(n + 1);
    queue<int> q;

    for (int i = 0; i < edge.size(); i++) {
        info[edge[i][0]].push_back(edge[i][1]);
        info[edge[i][1]].push_back(edge[i][0]);
    }

    q.push(1);
    visit[1] = true;
    int size, currentCount, currentNode, beforeCount;
    while(!q.empty()) {
        size = q.size();
        beforeCount = currentCount;
        currentCount = 0;
        while(size--) {
            currentNode = q.front();
            q.pop();
            for (int i = 0; i < info[currentNode].size(); i++) {
                if (!visit[info[currentNode][i]]) {
                    q.push(info[currentNode][i]);
                    visit[info[currentNode][i]] = true;
                    currentCount++;
                }
            }
        }
    }

    return beforeCount;
}
