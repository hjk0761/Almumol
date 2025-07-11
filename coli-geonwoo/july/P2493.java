package stack;

import java.util.*;
import java.io.*;

public class P2493 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Deque<Long> q = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            q.add(Long.parseLong(st.nextToken()));
        }

        Deque<Integer> answers = new ArrayDeque<>();

        Deque<Node> dq = new ArrayDeque<>();
        //내 왼쪽에 있는 것 중에 나보다 큰게 나올때까지 pop
        for (int i = 0; i < n; i++) {
            long cur = q.pollFirst();

            while(!dq.isEmpty() && dq.peekLast().num < cur){
                dq.pollLast();
            }

            if(dq.isEmpty()){
                answers.add(0);
                dq.addLast(new Node(i+1, cur));
                continue;
            }
            answers.add(dq.peekLast().idx);
            dq.addLast(new Node(i+1, cur));
        }

        for(int an : answers) {
            bw.write(an + " ");
        }
        bw.flush();
        bw.close();
    }

    static class Node {
        int idx;
        long num;

        public Node(int idx, long num) {
            this.idx = idx;
            this.num = num;
        }
    }
}
