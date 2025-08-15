package STDY;
import java.util.Scanner;

public class AlternateAddSub {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input N
        System.out.print("Enter N: ");
        int N = sc.nextInt();

        int result = 0;

        for (int i = 1; i <= N; i++) {
            if (i % 2 == 0) {
                result -= i; // subtract even numbers
            } else {
                result += i; // add odd numbers
            }
        }

        System.out.println("Result: " + result);

        sc.close();
    }
}


