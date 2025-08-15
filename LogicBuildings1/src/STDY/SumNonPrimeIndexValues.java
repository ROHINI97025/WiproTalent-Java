package STDY;
import java.util.Scanner;
public class SumNonPrimeIndexValues {
	// Function to check if index is prime
    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter array size: ");
        int size = sc.nextInt();

        int[] arr = new int[size];

        // Input array elements
        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = 0;
        for (int i = 0; i < size; i++) {
            if (!isPrime(i)) { // Non-prime index
                sum += arr[i];
            }
        }

        System.out.println("Sum of non-prime index values: " + sum);
        sc.close();
    }
}

	


