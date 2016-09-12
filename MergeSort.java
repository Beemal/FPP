package hw;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter two Strings: ");
		String str1 = sc.next();
		String str2 = sc.next();
		String str3 = str1+str2;
		ch = new char[str3.length()];
		System.out.println(sort(str3));
	}
	static int i = 0;
	static char[] ch;
	private static char[] sort(String str) {
		
			if(str==null||str =="") 
				return null;
			else if(str.length()==1) {
				Arrays.sort(ch);
				return ch;
			}
			else {
				ch[i] = str.charAt(0);
				i++;
				return sort(str.substring(1));
			}
		}
}

//SAMPLE OUTPUT
//enter two Strings: 
//bja
//dada
//aaabdj

