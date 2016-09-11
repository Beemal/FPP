package recursive;

public class MergeStrings {
	public static void main(String args[]){
		String str1 = "ace";
		String str2 = "bdf";

		String str = str1+str2;
		System.out.println(sort(str.toCharArray()));
	}
	static char[] sort(char[] a){
		char temp =0 ;
		int i;
		for(i = 0; i < a.length; i++){
			if(i < a.length - 1 && (int)a[i]>(int)a[i+1]){
				temp = a[i+1];
				a[i+1] = a[i];
				a[i] = temp;
				return sort(a);
			}
		}
		return a;
	}
		
}
