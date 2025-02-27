#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;


int solution(vector<int> queue1, vector<int> queue2) {
    int answer = 0;
   	queue<long long> q1;
    queue<long long> q2;
    
    long long total1 = 0;
    long long total2 = 0;
    for (int i = 0; i < queue1.size(); ++i) {
        q1.push(queue1[i]);
        q2.push(queue2[i]);
        total1 += queue1[i];
        total2 += queue2[i];
    }
    
    while (true) {
        if (total1 == total2) return answer;
        if (answer >= 3*queue1.size() + 1) return -1;
        if (total1 > total2) {
            total1 -= q1.front();
            total2 += q1.front();
            q2.push(q1.front());
            q1.pop();
            answer++;
        }
        else {
            total1 += q2.front();
            total2 -= q2.front();
            q1.push(q2.front());
            q2.pop();
            answer++;
        }
    }
}
