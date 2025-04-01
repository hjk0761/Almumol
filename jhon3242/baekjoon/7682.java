import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*

XOX
OXO
XOX

.XX
X.X
OOO

X.O
O..
X..

OOX
XXO
OXO


1. X가 O보다 하나 많거나 같다
2. 완성된 상태에서 추가로 놓은 경우가 있는가
    완성된 상태가 X와 O 둘다 있는 경우 invalid
    X가 완성된 상태: O의 개수가 X와 같은 경우는 invalid
    O가 완성된 상태: X의 개수와 같지 않는 경우는 invalid
3. 완성되지 않았는데 끝났는가
    완성된 상태가 없는데 빈 공간이 있는 경우

 */


public class Main {

    static char[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = br.readLine();
            if (line.equals("end")) break;
            graph = toGraph(line);
            if (isValid()) {
                sb.append("valid");
            } else {
                sb.append("invalid");
            }
            sb.append("\n");
//            System.out.println(Arrays.toString(isWin()));
//            printG();
//            System.out.println();
        }
        System.out.println(sb);

//        graph = toGraph("XO.OX...X");
//        System.out.println(Arrays.toString(isWin()));
//        printG();
    }

    private static boolean isValid() {
        int countX = getCount('X');
        int countO = getCount('O');

        if (countX - countO != 0 && countX - countO != 1) {
            return false;
        }
        int[] winCount = isWin();
        if (winCount[0] > 0 && winCount[1] > 0) {
            return false;
        }
        if (winCount[0] > 0 && countX == countO) {
            return false;
        }
        if (winCount[1] > 0 && countX != countO) {
            return false;
        }
        if (winCount[0] == 0 && winCount[1] == 0 && countX + countO != 9) {
            return false;
        }
        return true;
    }

    private static int getCount(char o) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (graph[i][j] == o) {
                    count++;
                }
            }
        }
        return count;
    }

    private static char[][] toGraph(String line) {
        char[][] result = new char[3][3];
        for (int i = 0; i < 3; i++) {
            result[i] = line.substring(i * 3, i * 3 + 3).toCharArray();
        }
        return result;
    }

    private static int[] isWin() {
        // [X 완성 개수, O 완성 개수]
        int[] result = new int[]{0, 0};

        // 세로 체크
        for (int i = 0; i < 3; i++) {
            boolean isWin = true;
            char target = graph[0][i];
            if (target == '.') {
                continue;
            }
            for (int j = 1; j < 3; j++) {
                if (graph[j][i] != target) {
                    isWin = false;
                    break;
                }
            }
            if (isWin) {
                if (target == 'X') {
                    result[0]++;
                } else {
                    result[1]++;
                }
            }
        }

        // 가로 체크
        for (int i = 0; i < 3; i++) {
            boolean isWin = true;
            char target = graph[i][0];
            if (target == '.') {
                continue;
            }
            for (int j = 1; j < 3; j++) {
                if (graph[i][j] != target) {
                    isWin = false;
                    break;
                }
            }
            if (isWin) {
                if (target == 'X') {
                    result[0]++;
                } else {
                    result[1]++;
                }
            }
        }

        // 대각선 A 체크
        boolean isWin = true;
        for (int i = 1; i < 3; i++) {
            char target = graph[0][0];
            if (target == '.') {
                isWin = false;
                break;
            }
            if (graph[i][i] != target) {
                isWin = false;
                break;
            }
        }
        if (isWin) {
            if (graph[0][0] == 'X') {
                result[0]++;
            } else {
                result[1]++;
            }
        }
        // 대각선 B 체크
        isWin = true;
        for (int i = 1; i < 3; i++) {
            char target = graph[2][0];
            if (target == '.') {
                isWin = false;
                break;
            }
            if (graph[2 - i][i] != target) {
                isWin = false;
                break;
            }
        }
        if (isWin) {
            if (graph[2][0] == 'X') {
                result[0]++;
            } else {
                result[1]++;
            }
        }

        return result;
    }

    private static void printG() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Arrays.toString(graph[i]));
        }
    }
}
