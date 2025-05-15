import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class p6068 {

    static List<Node> nodes = new ArrayList<>();
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n= Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int duration = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            nodes.add(new Node(endTime-duration, endTime, duration));
        }

        nodes.sort(Comparator.comparingInt(Node::getEndTime)
                .thenComparingInt(Node::getDuration)
                .reversed()
        );

        nodes.sort(Comparator.comparingInt(Node::getStartTime)
                .thenComparingInt(Node::getDuration)
                .reversed()
        );

        int [] answer = new int [n+1];
        answer[0] = Integer.MAX_VALUE;
        boolean flag = false;

        for (int i = 1; i < n+1; i++) {
            Node node = nodes.get(i - 1);
            answer[i]= Math.min(answer[i-1]- node.duration, node.startTime);
            if(answer[i]<0){
                flag = true;
                break;
            }
        }

        if(flag){
            bw.write("-1");
        }else{
            bw.write(String.valueOf(answer[n]));
        }

        bw.flush();
        bw.close();
    }

    static class Node {
        int startTime;
        int endTime;
        int duration;

        public Node(int startTime, int endTime, int duration) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.duration = duration;
        }

        public int getDuration() {
            return duration;
        }

        public int getEndTime() {
            return endTime;
        }

        public int getStartTime() {
            return startTime;
        }
    }
}
