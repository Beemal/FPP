package recursive;

import java.util.Scanner;

public class SumOfItems{
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array");
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			System.out.println("Array "+(i+1)+" =");
			arr[i] = sc.nextInt();
		}
		System.out.println("The Sum is = "+findSum(arr, arr.length));
		
	}

	static int findSum(int[] arr, int n){
		int sum = 0;
		if(n == 0){
			return 0;    
		}
		sum = arr[n-1] + findSum(arr, n-1);
		return sum;
	}
}
