package STDY;
import java.util.Scanner;

public class seriesN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input N
        System.out.print("Enter the value of N: ");
        int N = sc.nextInt();

        // Generate and print series
        System.out.print("Series: ");
        for (int i = 1; i <= N; i++) {
            int term = i * i; // Formula for series (n²) - change if needed
            System.out.print(term + " ");
        }

        // Find Nth term
        int nthTerm = N * N; // formula for nth term
        System.out.println("\nNth term is: " + nthTerm);

        sc.close();
    }
}