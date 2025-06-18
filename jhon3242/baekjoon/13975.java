package backjoon.n13975;

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

/*
1 2 3
4
6

1 2 3
5
6

1 2 3
3
6


 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0 ) {
            int n = Integer.parseInt(br.readLine());
            List<Long> list = Arrays.stream(br.readLine().split(" "))
                    .map(Long::parseLong)
                    .collect(Collectors.toList());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            pq.addAll(list);
            long result = 0;
            while (pq.size() >= 2) {
                long tmp = pq.poll() + pq.poll();
                result += tmp;
                pq.add(tmp);
            }
            System.out.println(result);
        }
    }
}
