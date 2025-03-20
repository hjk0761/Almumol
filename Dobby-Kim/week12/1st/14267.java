import java.util.*;
import java.io.*;

public class Main {

    private static int N, M, R;
    private static Worker[] workers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        workers = new Worker[N + 1];
        for (int i = 1; i < N + 1; i++) {
            workers[i] = new Worker(i);
        }

        String[] bosses = br.readLine().split(" ");
        for (int i = 1; i < N + 1; i++) {
            int boss = Integer.parseInt(bosses[i - 1]);
            if (boss == -1) {
                R = i;
                continue;
            }
            workers[boss].addUnderling(workers[i]);
        }

        for (int i = 0; i < M; i++) {
            String[] IW = br.readLine().split(" ");
            int I = Integer.parseInt(IW[0]);
            int W = Integer.parseInt(IW[1]);
            workers[I].savePoint(W);
        }

        workers[R].givePoint();

        for (int i = 1; i < N + 1; i++) {
            System.out.print(workers[i].point);
            if (i != N) {
                System.out.print(" ");
            }
        }
    }

    private static class Worker {

        int num;
        Set<Worker> underlings = new HashSet<>();
        int point = 0;

        public Worker(int num) {
            this.num = num;
        }

        public void addUnderling(Worker underling) {
            underlings.add(underling);
        }

        public void savePoint(int point) {
            this.point += point;
        }

        public void givePoint() {
            for (Worker underling : underlings) {
                underling.savePoint(point);
                underling.givePoint();
            }
        }
    }
}
