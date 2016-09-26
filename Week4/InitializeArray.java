package homework12;

public class InitializeArray {
	public static void main(String[] args) {
		int numer[] = { 4, 8, 16, 32, 64, 128, 256, 512 };
		int denom[] = { 2, 0, 4, 4, 0, 8 };
		int solution;
	try{
		for(int i=0; i < numer.length; i++){
			 try{
				 System.out.println("index"+i);
				 solution = numer[i] / denom[i];
				 System.out.println("Solution is : "+solution);
		
			 }
		catch(ArrayIndexOutOfBoundsException | ArithmeticException e ){
			System.out.println(e.getMessage());
		}
	
		}
	}finally{
		System.out.println("------Program Ended------");
	}
}
}

/*OUTPUT:
	index0
	Solution is : 2
	index1
	/ by zero
	index2
	Solution is : 4
	index3
	Solution is : 8
	index4
	/ by zero
	index5
	Solution is : 16
	index6
	6
	index7
	7
	------Program Ended------*/
