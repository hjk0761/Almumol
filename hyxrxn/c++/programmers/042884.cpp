#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<vector<int>> routes) {
    int answer = 0;

    for (int i = 0; i < routes.size(); i++) {
        int dummy = routes[i][0];
        routes[i][0] = routes[i][1];
        routes[i][1] = dummy;
    }
    sort(routes.begin(), routes.end());

    int current = -10000000;
    for (int i = 0; i < routes.size(); i++) {
        if (routes[i][1] > current) {
            current = routes[i][0];
            answer++;
        }
    }

    return answer;
}
