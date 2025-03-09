import java.util.*;
import java.io.*;


public class Main {

    private static int BASE = 6;
    private static Set<Character> MO = new HashSet<>();
    static int L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] line = br.readLine().split(" ");
            L = Integer.parseInt(line[0]);
            int C = Integer.parseInt(line[1]);

            String alphabets = br.readLine().replace(" ", "");
            char[] alphas = alphabets.toCharArray();

            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(line[i + 1]);
            }
            choose(0, 0, new ArrayList<>());
            System.out.println();
        }
    }

    private static void choose(int idx, int count, List<Integer> picked) {
        if (idx >= N || N - idx < BASE - count) {
            return;
        }
        if (count == BASE) {
            printList(picked);
            return;
        }

        picked.add(nums[idx]);
        choose(idx + 1, count + 1, picked);
        picked.remove(picked.size() - 1);
        choose(idx + 1, count, picked);
    }

    private static void printList(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}
