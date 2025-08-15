package STDY;
import java.util.*;
public class NambiarNumberGenerator {
	// Generate Nambiar number for a numeric string
    public static String nambiar(String s) {
        StringBuilder res = new StringBuilder();
        int n = s.length();
        int i = 0;

        while (i < n) {
            int first = s.charAt(i) - '0';
            int startParity = first % 2;  // 0 = even, 1 = odd
            int sum = 0;
            int j = i;

            while (j < n) {
                int d = s.charAt(j) - '0';
                sum += d;
                int sumParity = sum % 2;
                if (sumParity != startParity) {
                    break;               // stop when parity flips
                }
                j++;
            }

            res.append(sum);
            i = j + 1;                   // continue after the group
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read as string to preserve leading zeros if any
        System.out.print("Enter number: ");
        String num = sc.next().trim();

        // (Optional) validate digits only
        if (!num.matches("\\d+")) {
            System.out.println("Invalid input: digits only.");
            return;
        }

        String ans = nambiar(num);
        System.out.println("Nambiar Number: " + ans);
        sc.close();
    }
}


