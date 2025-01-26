import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class P_1759 {

    static final Set<String> VOWELS = Set.of(
            "a", "e", "i", "o", "u"
    );
    static int l;
    static boolean[] visited;
    static Set<String> result = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        String[] arr = new String[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = st.nextToken();
        }
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            backTracking(i, new ArrayList<>(), arr);
        }
        List<String> passwords = result.stream()
                .sorted()
                .collect(Collectors.toList());

        for (String now : passwords) {
            bw.write(now + System.lineSeparator());
        }
        bw.flush();
    }

    private static void backTracking(int index, List<String> cur, String[] arr) {
        if (cur.size() == l && checkVowels(cur)) {
            StringBuilder sb = new StringBuilder();
            for (String c : cur) {
                sb.append(c);
            }
            result.add(sb.toString());
            return;
        }

        for (int i = index; i < arr.length; i++) {
            String now = arr[index];
            cur.add(now);
            backTracking(i + 1, cur, arr);
            cur.remove(now);
        }
    }

    private static boolean checkVowels(List<String> cur) {
        int count = 0;
        for (String s : cur) {
            if (VOWELS.contains(s)) {
                count++;
            }
        }
        return count >= 1 && (cur.size() - count >= 2);
    }
}
