package homework12;


import javax.swing.JOptionPane;

public class AvoidNegative {
	public static void main(String[] args) throws Exception {
		int intMarks;
		// TODO Auto-generated method stub

		String marks = JOptionPane.showInputDialog("Enter marks in Integer (0 to 100)");
		try{
			intMarks = Integer.parseInt(marks);
			 if(intMarks < 0 || intMarks >100 )
	            {
	                throw new Exception("Marks should be between 0 and 100");
	            }
	          
		}catch(NumberFormatException e){
			System.out.println(e.getMessage()+" is not integer");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		finally{
			System.out.println("-------------");
		}
	}
}

/*OUTPUT:
	Marks should be between 0 and 100
	-------------
	For input string: "as" is not integer
-------------

*/