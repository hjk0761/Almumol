import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int m = sc.nextInt();

        int currentStress = 0;
        int total = 0;

        for (int i = 0; i < 24; i++) {
            if (currentStress + a <= m) {
                currentStress += a;
                total += b;
            } else {
                currentStress = Math.max(currentStress - c, 0);
            }
        }

        System.out.println(total);
    }
}
