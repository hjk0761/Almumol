#include <string>
#include <vector>
#include <queue>
using namespace std;

priority_queue<pair<int, int>> pq; // {값, 인덱스}

int solution(vector<int> stones, int k) { // 모든 연속한 k개 중에 가장 큰 값만큼 건널 수 있음. 그 중 가장 작은 값이 답.
    int answer = 200000001;

    for (int i = 0; i < k; i++) {
        pq.push({stones[i], i});
    }
    answer = min(answer, pq.top().first);

    for (int i = k; i < stones.size(); i++) {
        while(!pq.empty() && pq.top().second <= i - k) {
            pq.pop();
        }

        pq.push({stones[i], i});

        answer = min(answer, pq.top().first);
    }

    return answer;
}
