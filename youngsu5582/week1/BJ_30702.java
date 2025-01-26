package week1;

import java.io.*;
import java.util.*;

public class BJ_30702 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int n;
    static int m;

    // 색깔이 다른가? + 이미 방문하지 않았는가?
    // 주변에 색깔이 같은걸 모두 찾는다.
    // B 에서 A에서 찾은 좌표들의 색깔이 모두 동일한지 확인한다.
    // 계속 바꾼다. 다르면 NO

    public static void main(final String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        final int[][] a = setUp(n, m);
        final int[][] b = setUp(n, m);
        final boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!isSameColor(a, b, i, j) && !visited[i][j]) {
                    visited[i][j] = true;
                    Deque<Element> dq = new ArrayDeque<>();
                    dq.add(new Element(i, j));
                    var ary = bfs(a, b, dq, visited);
                    if (isAllSameColor(ary, b)) {
                        change(b[i][j], ary, a);
                    } else {
                        System.out.println("NO");
                        return;
                    }
                }
            }
        }
        if (checkAll(a, b)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean checkAll(final int[][] a, final int[][] b) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void change(final Integer color, final List<Element> elements, final int[][] ary) {
        for (Element element : elements) {
            ary[element.x][element.y] = color;
        }
    }

    private static boolean isAllSameColor(final List<Element> elements, final int[][] ary) {
        Set<Integer> set = new HashSet<>();
        for (Element element : elements) {
            set.add(ary[element.x][element.y]);
        }
        return set.size() == 1;
    }

    private static boolean isSameColor(final int[][] a, final int[][] b, final int x, final int y) {
        return a[x][y] == b[x][y];
    }

    private static List<Element> bfs(final int[][] a, final int[][] b, final Deque<Element> dq, final boolean[][] visited) {

        List<Element> list = new ArrayList<>();
        while (!dq.isEmpty()) {
            var element = dq.poll();
            list.add(element);
            for (final int[] direction : DIRECTIONS) {
                final int next_x = element.x + direction[0];
                final int next_y = element.y + direction[1];
                if (0 <= next_x && next_x < n && 0 <= next_y && next_y < m) {

                    if (a[next_x][next_y] == a[element.x][element.y] && !visited[next_x][next_y]) {
                        final Element next_element = new Element(next_x, next_y);
                        visited[next_x][next_y] = true;
                        dq.add(next_element);
                    }
                }
            }
        }
        return list;
    }

    private static final int[][] DIRECTIONS = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private static int[][] setUp(final int n, final int m) throws IOException {
        final int[][] ary = new int[n][m];
        for (int i = 0; i < n; i++) {
            final String line = br.readLine();
            for (int j = 0; j < m; j++) {
                ary[i][j] = line.charAt(j);
            }
        }
        return ary;
    }

    private static class Element {
        int x;
        int y;

        public Element(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Element x : " + this.x + " y : " + this.y;
        }
    }
}
