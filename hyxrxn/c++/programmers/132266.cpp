#include <vector>
#include <queue>
using namespace std;

vector<vector<int>> info(101010);
bool visit[101010] = {false};
int time[101010];
queue<int> q;

vector<int> solution(int n, vector<vector<int>> roads, vector<int> sources, int destination) {
    for (int i = 1; i <= n; i++) {
        time[i] = -1;
    }

    for (int i = 0; i < roads.size(); i++) {
        info[roads[i][0]].push_back(roads[i][1]);
        info[roads[i][1]].push_back(roads[i][0]);
    }

    q.push(destination);
    visit[destination] = true;
    int count = 0;
    int current, size, next;
    while(!q.empty()) {
        size = q.size();
        while(size--) {
            current = q.front();
            q.pop();
            time[current] = count;
            for (int i = 0; i < info[current].size(); i++) {
                next = info[current][i];
                if (!visit[next]) {
                    q.push(next);
                    visit[next] = true;
                }
            }
        }
        count++;
    }

    vector<int> answer;
    for (int i = 0; i < sources.size(); i++) {
        answer.push_back(time[sources[i]]);
    }
    return answer;
}
