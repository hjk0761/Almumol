import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class P_30804 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int max = 0;

        while (end < n) {
            int nowFruit = arr[end];
            set.add(nowFruit);
            while (set.size() >= 3) {
                int removeFruit = arr[start];
                set.remove(removeFruit);
                while (!set.contains(arr[start])) {
                    start++;
                    for (int i = start; i < end; i++) {
                        int now = arr[i];
                        if (!set.contains(now)) {
                            set.add(arr[i]);
                            break;
                        }
                    }
                }

            }
            max = Math.max(max, end - start + 1);
            end++;
        }

        bw.write(max + System.lineSeparator());
        bw.flush();
    }
}
