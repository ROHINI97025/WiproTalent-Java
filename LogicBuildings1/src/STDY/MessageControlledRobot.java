package STDY;
import java.util.*;
public class MessageControlledRobot {
	 public static class Result {
	        int x, y, steps;
	        Result(int x, int y, int steps) {
	            this.x = x; this.y = y; this.steps = steps;
	        }
	    }

	    // Parse a control message like "U3R2dL10, U" and return final position
	    public static Result simulate(String message) {
	        int x = 0, y = 0, steps = 0;
	        int i = 0, n = message.length();

	        while (i < n) {
	            char c = message.charAt(i);

	            // Accept only UDLR (case-insensitive)
	            if (c == 'U' || c == 'u' || c == 'D' || c == 'd' ||
	                c == 'L' || c == 'l' || c == 'R' || c == 'r') {

	                char dir = Character.toUpperCase(c);
	                i++;

	                // Read optional number after the direction
	                int count = 0;
	                while (i < n && Character.isDigit(message.charAt(i))) {
	                    count = count * 10 + (message.charAt(i) - '0');
	                    i++;
	                }
	                if (count == 0) count = 1; // default one step if no number

	                switch (dir) {
	                    case 'U': y += count; break;
	                    case 'D': y -= count; break;
	                    case 'L': x -= count; break;
	                    case 'R': x += count; break;
	                }
	                steps += count;

	            } else {
	                // ignore any non-command character
	                i++;
	            }
	        }
	        return new Result(x, y, steps);
	    }

	    public static int manhattanDistance(int x, int y) {
	        return Math.abs(x) + Math.abs(y);
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter control message: ");
	        String msg = sc.nextLine();

	        Result res = simulate(msg);
	        System.out.println("Final Position: (" + res.x + ", " + res.y + ")");
	        System.out.println("Total Steps: " + res.steps);
	        System.out.println("Manhattan Distance from Origin: " + manhattanDistance(res.x, res.y));
	        sc.close();
	    }
	}


