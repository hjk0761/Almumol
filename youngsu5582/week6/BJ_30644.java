package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 14:37 - 15:10

public class BJ_30644 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        final StringTokenizer st = new StringTokenizer(br.readLine());
        final int[] ary = new int[n];

        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }
        final int[] sorted = Arrays.stream(ary)
                .sorted()
                .toArray();
        final Map<Integer, Cutting> mp = new HashMap<>();

        mp.put(sorted[0], new Cutting(sorted[0], null, null));
        for (int i = 1; i < n; i++) {
            Cutting prev = mp.get(sorted[i - 1]);
            Cutting current = new Cutting(sorted[i], prev, null);
            mp.put(sorted[i], current);
            prev.setNext(current);
        }
        Cutting current = mp.get(ary[0]);
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (!current.isNext(ary[i])) {
                count++;
            }
            current = mp.get(ary[i]);
            System.out.println(current.x+"\t"+ current.prev+"\t"+current.next+"\t"+count);
        }

        System.out.println(count);
    }

    public static class Cutting {
        int x;
        Cutting prev;
        Cutting next;

        public Cutting(int x, Cutting prev, Cutting next) {
            this.x = x;
            this.prev = prev;
            this.next = next;
        }

        public void setPrev(Cutting prev) {
            this.prev = prev;
        }

        public void setNext(Cutting next) {
            this.next = next;
        }

        public boolean isNext(int x) {
            boolean prevIsEqual = prev != null && prev.x == x;
            boolean nextIsEqual = next != null && next.x == x;
            return prevIsEqual || nextIsEqual;
        }
        public String toString(){
            return String.format("Cutting [ x: %d ]",x);
        }
    }
}

// 애초에 자를때 끝날거 같다.
// 순서 변경 및 역순은 카운트 하지 않으므로

// 기존 내려가는 방향이면 쭉 내려가야 함
// 기존 올라가는 방향이면 쭉 올라가야 함
