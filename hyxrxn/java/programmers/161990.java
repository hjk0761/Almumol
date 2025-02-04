class Solution {
    public int[] solution(String[] wallpaper) {
        int minX = 100;
        int minY = 100;
        int maxX = 0;
        int maxY = 0;
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                    maxX = Math.max(maxX, i + 1);
                    maxY = Math.max(maxY, j + 1);
                }
            }
        }

        int[] answer = {minX, minY, maxX, maxY};
        return answer;
    }
}

// https://school.programmers.co.kr/learn/courses/30/lessons/161990
// 바탕화면 정리

// wallpaper를 순회하며 '#'이라면(파일이 있다면) 최소, 최대인 x, y값을 모두 갱신한다.
// 이때 최소는 파일이 있는 곳의 왼쪽 위, 최대는 파일이 있는 곳의 오른쪽 아래로 한다.
// 그래서 최소는 i, j를 사용해 갱신하고 최대는 i+1, j+1을 사용해 갱신한다.
