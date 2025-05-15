#include <string>
#include <vector>
#include <tuple>
#include <algorithm>
#include <map>
using namespace std;

vector<int> solution(vector<string> genres, vector<int> plays) {
    map<string, int> m;
    for (int i = 0; i < genres.size(); i++) {
        m[genres[i]] += plays[i];
    }

    vector<pair<int, string>> sV;
    for (pair<string, int> p : m) {
        sV.push_back({-p.second, p.first});
    }
    sort(sV.begin(), sV.end());

    vector<tuple<string, int, int>> v;
    for (int i = 0; i < genres.size(); i++) {
        v.push_back({genres[i], -plays[i], i});
    }
    sort(v.begin(), v.end());

    vector<int> answer;
    for (int i = 0; i < sV.size(); i++) {
        for (int j = 0; j < v.size(); j++) {
            if (get<0>(v[j]) == sV[i].second) {
                answer.push_back(get<2>(v[j]));
                if (j + 1 < v.size() && get<0>(v[j + 1]) == sV[i].second) {
                    answer.push_back(get<2>(v[j + 1]));
                }
                break;
            }
        }
    }

    return answer;
}
