package backjoon.n1202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main2 {
    static int N;
    static int K;
    static List<Jeweler> jewelers;
    static List<Integer> bags = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        jewelers = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewelers.add(new Jeweler(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        bags = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            bags.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(jewelers, (a, b) -> {
            if (a.weight == b.weight) {
                return b.value - a.value;
            }
            return a.weight - b.weight;
        });
        Collections.sort(bags);

        System.out.println(getResult());
    }

    private static long getResult() {
        long result = 0;
        PriorityQueue<Jeweler> pq = new PriorityQueue<>();
        int j = 0;
        for (int i = 0; i < bags.size(); i++) {
            int bag = bags.get(i);

            while (j < N) {
                Jeweler e = jewelers.get(j);
                if (e.weight > bag) {
                    break;
                }
                j++;
                pq.add(e);
            }
            if (pq.isEmpty()) {
                continue;
            }
            Jeweler poll = pq.poll();
            result += poll.value;
        }
        return result;
    }

    static class Jeweler implements Comparable<Jeweler>{
        int weight;
        int value;

        public Jeweler(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Jeweler o) {
            return o.value - this.value;
        }
    }
}
