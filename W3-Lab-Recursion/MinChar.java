package recursive;

import java.util.Scanner;

public class MinChar {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a word: ");
		String input = sc.next();
		
		System.out.println(minimumIn(input, input.length()));
	}

	private static String minimumIn(String s, int n) {
		String min;
		String lString = s.substring(n-1,n);
		String slString = s.substring(n-2,n-1);
		int a = lString.compareTo(slString);
		if(a < 0){
			min = lString;
		}else{
			min = slString;
		}
		minimumIn(s.substring(s.length()-1), s.length());
		return min;		
	}
}
