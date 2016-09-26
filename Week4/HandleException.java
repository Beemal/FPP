package homework12;

class CustomerAccount{
	 String cus_name;
	 String acc_No;
	 Double  balance = 0.0;
	 
	void deposite(double amt){
		 balance = balance + amt;
	 }
	 void withdraw(double amt){
		 try{
		 if(balance >= amt){
			 balance = balance - amt;
		 }else
			 throw new Exception("Sorry, you donot have enough balance");
		 }catch(Exception e){
			 System.out.println(e.getMessage());
		 }
		 finally{
			 System.out.println("------------");
		 }
	 }
}
public class HandleException {
	public static void main(String[] args) {
		CustomerAccount ca = new CustomerAccount();
		ca.deposite(1000);
		ca.withdraw(200);
		System.out.println("Your Current Balance: " +ca.balance);
		
		ca.withdraw(1200);
		System.out.println("Your Current Balance: " +ca.balance);
		
	}
}

/*OUTPUT:
	------------
	Your Current Balance: 800.0
	Sorry, you donot have enough balance
	------------
	Your Current Balance: 800.0
*/
