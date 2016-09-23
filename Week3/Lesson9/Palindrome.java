package homework;

import java.util.Scanner;
import java.util.Stack;

public class Palindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a String");

		String input = sc.next();

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < input.length(); i++) {
			stack.push(input.charAt(i));
		}

		String output = "";

		while (!stack.isEmpty()) {
			output += stack.pop();
		}

		if (input.equals(output))
			System.out.println("PALINDROME");
		else
			System.out.println("NOT PALINDROME");
	}

}

/*OUTPUT:
	Enter a String
	madam
	PALINDROME
	
	Enter a String
bimal
NOT PALINDROME

*/
	