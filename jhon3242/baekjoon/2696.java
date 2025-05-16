package backjoon.n2696;

import com.sun.source.tree.Tree;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            List<Integer> tmpList = new ArrayList<>();
            sb.append(N / 2 + 1).append("\n");

            int count = 0;
            for (int j = 0; j < N; j+= 10) {
                int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                        .toArray();

                for (int k = 0; k < array.length; k++) {
                    tmpList.add(array[k]);
                    Collections.sort(tmpList);
                    if (k % 2 == 0) {
                        count++;
                        sb.append(tmpList.get(tmpList.size() / 2)).append(" ");
                        if (count >= 10) {
                            count = 0;
                            sb.append("\n");
                        }
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);



    }
}
