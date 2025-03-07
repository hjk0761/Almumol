#include <string>
#include <vector>
#include <queue>
#include <iostream>
using namespace std;

priority_queue<int> pq;

long long solution(int n, vector<int> works) {
    for (int i = 0; i < works.size(); i++) {
        pq.push(works[i]);
    }

    int current, workTime;
    while(n > 0 && !pq.empty()) {
        current = pq.top();
        pq.pop();

        workTime = min(n, current - pq.top() + 1);
        n -= workTime;
        if (current - workTime > 0) {
            pq.push(current - workTime);
        }
    }

    long long answer = 0;
    while(!pq.empty()) {
        current = pq.top();
        pq.pop();
        answer += (long long) current * current;
    }

    return answer;
}
