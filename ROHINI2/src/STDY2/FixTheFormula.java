package STDY2;

public class FixTheFormula {
	public static int fixTheFormula(String input1) {
        // Lists to store numbers and operators
        java.util.List<Integer> numbers = new java.util.ArrayList<>();
        java.util.List<Character> operators = new java.util.ArrayList<>();

        // Separate digits and operators from the string
        for (char ch : input1.toCharArray()) {
            if (Character.isDigit(ch)) {
                numbers.add(ch - '0'); // Convert char digit to int
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                operators.add(ch);
            }
        }

        // Start with the first number
        int result = numbers.get(0);

        // Apply each operator in order
        for (int i = 0; i < operators.size(); i++) {
            char op = operators.get(i);
            int nextNum = numbers.get(i + 1);

            switch (op) {
                case '+':
                    result += nextNum;
                    break;
                case '-':
                    result -= nextNum;
                    break;
                case '*':
                    result *= nextNum;
                    break;
                case '/':
                    result /= nextNum; // integer division
                    break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(fixTheFormula("Fo+23the3*like2+")); // 17
        System.out.println(fixTheFormula("we8+you2-7to/*32")); // 2
        System.out.println(fixTheFormula("i*-t5s-t8h1e4birds")); // 35
    }
}

