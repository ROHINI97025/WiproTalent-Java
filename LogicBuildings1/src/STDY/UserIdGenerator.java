package STDY;
import java.util.*;

public class UserIdGenerator {

    public static String generateUserId(String firstName, String lastName, String pin, int n) {
        // Step 1: Decide longer name
        String longer, shorter;
        if (firstName.length() == lastName.length()) {
            // If same length, use lexicographical order
            if (firstName.compareToIgnoreCase(lastName) > 0) {
                longer = firstName;
                shorter = lastName;
            } else {
                longer = lastName;
                shorter = firstName;
            }
        } else if (firstName.length() > lastName.length()) {
            longer = firstName;
            shorter = lastName;
        } else {
            longer = lastName;
            shorter = firstName;
        }

        // Step 2: Take first char of longer name + shorter name
        String base = longer.charAt(0) + shorter;

        // Step 3: Append nth digit from PIN (left and right)
        char nthFromLeft = pin.charAt(n - 1);
        char nthFromRight = pin.charAt(pin.length() - n);

        base = base + nthFromLeft + nthFromRight;

        // Step 4: Reverse and swap case
        StringBuilder reversed = new StringBuilder();
        for (int i = base.length() - 1; i >= 0; i--) {
            char ch = base.charAt(i);
            if (Character.isUpperCase(ch))
                reversed.append(Character.toLowerCase(ch));
            else if (Character.isLowerCase(ch))
                reversed.append(Character.toUpperCase(ch));
            else
                reversed.append(ch); // for digits
        }

        return reversed.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first name: ");
        String firstName = sc.next();

        System.out.print("Enter last name: ");
        String lastName = sc.next();

        System.out.print("Enter PIN: ");
        String pin = sc.next();

        System.out.print("Enter N: ");
        int n = sc.nextInt();

        String userId = generateUserId(firstName, lastName, pin, n);
        System.out.println("Generated User ID: " + userId);

        sc.close();
    }
}