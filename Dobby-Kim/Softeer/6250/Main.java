import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int contestCount = 3;
        int[][] contests = new int[contestCount][N];
        int[][] contestRanks = new int[contestCount][N];

        for (int c = 0; c < contestCount; c++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                contests[c][i] = Integer.parseInt(st.nextToken());
            }
            contestRanks[c] = computeRanking(contests[c]);
        }

        int[] finalScores = new int[N];
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int c = 0; c < contestCount; c++) {
                sum += contests[c][i];
            }
            finalScores[i] = sum;
        }
        int[] finalRank = computeRanking(finalScores);

        StringBuilder sb = new StringBuilder();
        for (int c = 0; c < contestCount; c++) {
            for (int i = 0; i < N; i++) {
                sb.append(contestRanks[c][i]).append(i == N - 1 ? "\n" : " ");
            }
        }
        for (int i = 0; i < N; i++) {
            sb.append(finalRank[i]).append(i == N - 1 ? "" : " ");
        }

        System.out.print(sb.toString());
    }

    public static int[] computeRanking(int[] scores) {
        Participant[] arr = new Participant[N];

        for (int i = 0; i < N; i++) {
            arr[i] = new Participant(scores[i], i);
        }

        Arrays.sort(arr);

        int[] rank = new int[N];
        int currentRank = 1;
        rank[arr[0].index] = currentRank;

        for (int i = 1; i < N; i++) {
            if (arr[i].score == arr[i - 1].score) {
                rank[arr[i].index] = currentRank;
            } else {
                currentRank = i + 1;
                rank[arr[i].index] = currentRank;
            }
        }
        return rank;
    }

    static class Participant implements Comparable<Participant> {
        int score;
        int index;

        public Participant(int score, int index) {
            this.score = score;
            this.index = index;
        }

        @Override
        public int compareTo(Participant o) {
            return Integer.compare(o.score, this.score);
        }
    }
}
