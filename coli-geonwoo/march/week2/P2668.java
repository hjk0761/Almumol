import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P2668 {

    static int[] nums2;
    static boolean[] visited;
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        nums2 = new int[n];

        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            nums2[i] = k;
        }

        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            visited[i] = true;
            dfs(i, nums2[i] - 1);
        }

        Collections.sort(answer);
        System.out.println(answer.size());

        for (int num : answer) {
            System.out.println(num);
        }

    }


    private static void dfs(int startIndex, int index) {

        if (startIndex + 1 == nums2[index]) {
            answer.add(startIndex + 1);
            return;
        }

        if (visited[index]) {
            return;
        }

        visited[index] = true;
        dfs(startIndex, nums2[index] - 1);
    }

}
