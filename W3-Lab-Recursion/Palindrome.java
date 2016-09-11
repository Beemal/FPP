package recursive;

import java.util.Scanner;

public class Palindrome {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a word: ");
		String input = sc.next();
		System.out.println(palindrome(input));
		sc.close();
	}

	private static boolean palindrome(String str) {
		if(str.length() == 0 || str.length() == 1)
			return true;
		if(str.charAt(0) == str.charAt(str.length() - 1 ))
			return palindrome(str.substring(1,str.length() - 1));
		return false;
	}
	
}
