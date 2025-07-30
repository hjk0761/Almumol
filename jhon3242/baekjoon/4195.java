package backjoon.n4195;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<String, Integer> indexMap;
    static Map<Integer, Integer> parents;
    static Map<Integer, Integer> countMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int F = Integer.parseInt(br.readLine());
            indexMap = new HashMap<>();
            parents = new HashMap<>();
            countMap = new HashMap<>();

            for (int i = 0; i < F; i++) {
                String[] split = br.readLine().split(" ");
                String a = split[0];
                String b = split[1];

                int aIndex = indexMap.computeIfAbsent(a, (none) -> indexMap.size());
                int bIndex = indexMap.computeIfAbsent(b, (none) -> indexMap.size());
                parents.putIfAbsent(aIndex, parents.size());
                parents.putIfAbsent(bIndex, parents.size());
                countMap.putIfAbsent(aIndex, 1);
                countMap.putIfAbsent(bIndex, 1);

                union(aIndex, bIndex);
                int target = find(aIndex);
                sb.append(getSameCount(target)).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) {
            parents.put(b, a);
        } else {
            parents.put(a, b);
        }
        int sum = countMap.get(a) + countMap.get(b);
        if (a == b){
            sum = countMap.get(a);
        }
        countMap.put(a, sum);
        countMap.put(b, sum);
    }

    private static int find(int x) {
        if (parents.get(x) != x) {
            parents.put(x, find(parents.get(x)));
        }
        return parents.get(x);
    }

    private static int getSameCount(int a) {
        return countMap.get(a);
    }
}
