
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = 0;

        while (a > 0) {
            b = b * 0 + a % 10;
            a = a / 10;
            System.out.print(b);

        }

    }
}
