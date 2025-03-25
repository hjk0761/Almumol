#include <tuple>
#include <vector>
#include <queue>
#include <iostream>
using namespace std;

priority_queue<tuple<int, int, int>> pq; // {-소요시간, -요청시각, -번호}
priority_queue<tuple<int, int, int>> jobInfo; // {-요청시각, -소요시간, -번호}

int solution(vector<vector<int>> jobs) {
    int answer = 0;

    for (int i = 0; i < jobs.size(); i++) {
        jobInfo.push({-jobs[i][0], -jobs[i][1], -i});
    }

    int currentTime = -get<0>(jobInfo.top());
    pq.push({get<1>(jobInfo.top()), get<0>(jobInfo.top()), get<2>(jobInfo.top())});
    jobInfo.pop();

    while(!jobInfo.empty() || !pq.empty()) {
        while(!jobInfo.empty() && -get<0>(jobInfo.top()) <= currentTime) {
            pq.push({get<1>(jobInfo.top()), get<0>(jobInfo.top()), get<2>(jobInfo.top())});
            jobInfo.pop();
        }

        if (pq.empty() && !jobInfo.empty()) {
            currentTime = -get<0>(jobInfo.top());
            pq.push({get<1>(jobInfo.top()), get<0>(jobInfo.top()), get<2>(jobInfo.top())});
            jobInfo.pop();
        }

        currentTime += -get<0>(pq.top());
        answer += currentTime - (-get<1>(pq.top()));

        cout << currentTime << " " << currentTime - (-get<1>(pq.top())) << endl;

        pq.pop();
    }

    return answer / jobs.size();
}
