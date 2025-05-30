package backjoon.n1707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*

정점을 두 집합으로 구분한다고 할 때, 특별한 조건이 없다.
따라서 어느 A 정점에서 어떠한 정점으로 가는 비용이 2 이상인 경우 무조건 이분 그래프로 만들 수 있다.

-플로이드 워셜(?)
모든 정점을 하나씩 확인해보면서 비용이 2 이상인 경우를 찾는경우
시간 복잡도는 V^2이 될 것이다.
V는 최대 20,000 이므로 최대 800,000,000 번의 연산이 일어난다.


 */

public class Main {
    static int V;
    static int E;
    static List[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int z = 0; z < T; z++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            graph = new List[V + 1];
            for (int i = 1; i <= V; i++) {
                graph[i] = new ArrayList<Integer>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }
            if (getResult()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean getResult() {
        int[] color = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            List list = graph[i];
            if (color[i] == 0) {
                color[i] = 1;
            }
            int curColor = color[i];

            for (int j = 0; j < list.size(); j++) {
                int near = (Integer) list.get(j);
                if (color[near] == curColor) {
                    return false;
                }
                if (color[near] == 0) {
                    color[near] = curColor * -1;
                }
            }
        }
        return true;
    }
}
