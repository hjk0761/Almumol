#include <vector>
using namespace std;

int solution(int n, vector<int> stations, int w)
{
    vector<pair<int, int>> v;
    v.push_back({0, 0});
    int start = max(stations[0] - w, 1);
    int end = min(stations[0] + w, n);
    for (int i = 1; i < stations.size(); i++) {
        if (max(stations[i] - w, 1) <= end) {
            end = min(stations[i] + w, n);
        } else {
            v.push_back({start, end});
            start = max(stations[i] - w, 1);
            end = min(stations[i] + w, n);
        }
    }
    v.push_back({start, end});
    v.push_back({n + 1, n + 1});

    int answer = 0;
    for (int i = 1; i < v.size(); i++) {
        answer += (v[i].first - v[i - 1].second - 1 + w * 2) / (w * 2 + 1);
    }

    return answer;
}
