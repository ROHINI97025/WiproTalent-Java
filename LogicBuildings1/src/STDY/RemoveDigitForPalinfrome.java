package STDY;
import java.util.Scanner;

public class RemoveDigitForPalinfrome {
	 // Function to check palindrome
    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        String num = sc.next();

        if (isPalindrome(num)) {
            System.out.println("Already a palindrome");
            return;
        }

        boolean found = false;

        for (int i = 0; i < num.length(); i++) {
            String modified = num.substring(0, i) + num.substring(i + 1);
            if (isPalindrome(modified)) {
                System.out.println("Remove digit: " + num.charAt(i));
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Not possible by removing one digit");
        }

        sc.close();
    }
}


