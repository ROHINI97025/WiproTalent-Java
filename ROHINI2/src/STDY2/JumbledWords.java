package STDY2;
import java.util.*;

public class JumbledWords {
	public static String jumbleWordMethod1(String word) {
        StringBuilder firstPart = new StringBuilder();
        StringBuilder secondPart = new StringBuilder();

        // Forward: pick 1st, 3rd, 5th... letters (indexes 0, 2, 4...)
        for (int i = 0; i < word.length(); i += 2) {
            firstPart.append(word.charAt(i));
        }

        // Backward: pick 2nd, 4th, 6th... letters (indexes 1, 3, 5...) starting from the last such index
        int startIndex = (word.length() % 2 == 0) ? word.length() - 1 : word.length() - 2;
        for (int i = startIndex; i >= 0; i -= 2) {
            secondPart.append(word.charAt(i));
        }

        return firstPart.toString() + secondPart.toString();
    }

    // Method-2: forward (odd positions) + forward (even positions)
    public static String jumbleWordMethod2(String word) {
        StringBuilder firstPart = new StringBuilder();
        StringBuilder secondPart = new StringBuilder();

        // Forward: pick 1st, 3rd, 5th... letters (indexes 0, 2, 4...)
        for (int i = 0; i < word.length(); i += 2) {
            firstPart.append(word.charAt(i));
        }

        // Forward again: pick 2nd, 4th, 6th... letters (indexes 1, 3, 5...)
        for (int i = 1; i < word.length(); i += 2) {
            secondPart.append(word.charAt(i));
        }

        return firstPart.toString() + secondPart.toString();
    }

    // Jumble the full sentence
    public static String jumbleSentence(String sentence, int method) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (method == 1) {
                result.append(jumbleWordMethod1(word));
            } else if (method == 2) {
                result.append(jumbleWordMethod2(word));
            } else {
                return "Invalid method number!";
            }
            result.append(" ");
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input sentence
        String input1 = sc.nextLine().trim();

        // Input method (1 or 2)
        int input2 = sc.nextInt();

        // Output jumbled sentence
        System.out.println(jumbleSentence(input1, input2));

        sc.close();
    }
}

