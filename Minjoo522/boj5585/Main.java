import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] changes = {500, 100, 50, 10, 5, 1};
        int money = 1000 - sc.nextInt();
        int result = 0;

        for (int i = 0; i < changes.length; i++) {
            if (money == 0) {
                break;
            }
            result += money / changes[i];
            money = money % changes[i];
        }

        System.out.println(result);
    }
}
