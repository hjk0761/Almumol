package programmers;

/*
DP
아래부터 최적의 상황을 선택해 차례로 올라온다.
 */
class P43105 {

    public int solution(int[][] triangle) {
        for (int x = triangle.length - 2; x >= 0; x--) {
            for (int y = 0; y <= x; y++) {
                triangle[x][y] += Math.max(triangle[x+1][y], triangle[x+1][y+1]);
            }
        }
        return triangle[0][0];
    }
}
