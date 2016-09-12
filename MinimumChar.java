package hw;
import java.util.Scanner;

class MinimumChar {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a word: ");
		String str = sc.next();

		System.out.println(minimumIn(str, str.charAt(0)));
	}

	private static char minimumIn(String str, char min) {
		if(str.length() == 1){
			return min;
		}
		else{
			if(str.charAt(1) < min)
				min = str.charAt(1);
		}
		return minimumIn(str.substring(1),min);
	}
}

//SAMPLE  OUTPUT: 
//Enter a word: 
//bimal
//a
