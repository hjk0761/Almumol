import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class P1953 {

    static Map<Integer, List<Integer>> edges = new HashMap<>();
    static int[] data;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        data = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            edges.put(i, new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= k; j++) {
                int k2 = Integer.parseInt(st.nextToken());
                edges.get(i).add(k2);
                edges.get(k2).add(i);
            }
        }

        for (int i = 1; i <= n; i++) {
            if(data[i] ==0) {
                data[i] =1;

                Deque<Integer> q = new ArrayDeque<>();
                q.add(i);

                while(!q.isEmpty()) {
                    int curr = q.poll();
                    List<Integer> next = edges.get(curr);
                    for (int node : next) {
                        if (data[node] == 0) {
                            if (data[curr] == 1) {
                                data[node] = 2;
                            } else {
                                data[node] = 1;
                            }
                            q.add(node);
                        }
                    }
                }
            }
        }

        List<Integer> one = new ArrayList<>();
        List<Integer> two = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            if (data[i] == 1) {
                one.add(i);
            }
            if (data[i] == 2) {
                two.add(i);
            }
        }

        System.out.println(one.size());
        for (int i = 0; i < one.size(); i++) {
            System.out.print(one.get(i) + " ");
        }
        System.out.println();
        System.out.println(two.size());

        for (int i = 0; i < two.size(); i++) {
            System.out.print(two.get(i) + " ");
        }
    }
}
