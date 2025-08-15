package STDY;
import java.util.Scanner;

public class StableUnstablePassword {
	// Function to check if number is stable
    public static boolean isStable(int num) {
        String s = String.valueOf(num);
        int[] freq = new int[10];

        // Count digit frequencies
        for (char c : s.toCharArray()) {
            freq[c - '0']++;
        }

        int firstFreq = 0;
        for (int f : freq) {
            if (f > 0) {
                if (firstFreq == 0) {
                    firstFreq = f; // set reference frequency
                } else if (f != firstFreq) {
                    return false; // mismatch → unstable
                }
            }
        }
        return true; // all same frequency → stable
    }

    // Function to find password
    public static int findPassword(int num) {
        if (isStable(num)) {
            // Stable → sum of digits
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            return sum;
        } else {
            // Unstable → product of digits
            int product = 1;
            while (num > 0) {
                product *= num % 10;
                num /= 10;
            }
            return product;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int num = sc.nextInt();

        int password = findPassword(num);

        if (isStable(num)) {
            System.out.println("Number is Stable");
        } else {
            System.out.println("Number is Unstable");
        }
        System.out.println("Password: " + password);

        sc.close();
    }
}

