import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, k;
        n = sc.nextInt();
        k = sc.nextInt();
        int[] score = new int[n + 1];
        int[] scoreSum = new int[n + 1];
        scoreSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            score[i] = sc.nextInt();
            scoreSum[i] = scoreSum[i - 1] + score[i];
        }

        for (int i = 0; i < k; i++) {
            int a, b;
            a = sc.nextInt();
            b = sc.nextInt();
            double average = (double)(scoreSum[b] - scoreSum[a - 1]) / (b - a + 1);
            System.out.printf("%.2f\n", average);
        }
    }
}

// https://softeer.ai/practice/6294

// 학번 순으로 n명의 점수를 입력받아 누적합을 계산한다.
// k번 구간을 입력받고, 구간 끝의 누적합에서 시작의 누적합을 빼서 그 구간의 누적합을 구하고, 인원수로 나눈다.
// 형식에 맞게 출력한다.
