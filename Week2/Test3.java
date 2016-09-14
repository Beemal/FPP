package inheritance;

interface Payable{
	double getPaymentAmount();
}
abstract class Employee1{
	private String firstName;
	private String lastName;
	private String socialSecurityNumber;
	public Employee1(String firstName, String lastName,
			String socialSecurityNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
	}
	public double getPaymentAmount() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String toString() {
		return "Employee1 [firstName=" + firstName + ", lastName=" + lastName
				+ ", socialSecurityNumber=" + socialSecurityNumber + "]";
	}
	
	
}
class Invoice implements Payable
{
	private int quantity;
	private String partNumber;
	private String partDescription;
	private double pricePerItem;
	
	public Invoice(int quantity, String partNumber, String partDescription,
			double pricePerItem) {
		this.quantity = quantity;
		this.partNumber = partNumber;
		this.partDescription = partDescription;
		this.pricePerItem = pricePerItem;
	}
	public double getPaymentAmount() {
		// TODO Auto-generated method stub
		return quantity * pricePerItem;
	}
	@Override
	public String toString() {
		return "Invoice [quantity=" + quantity + ", partNumber=" + partNumber
				+ ", partDescription=" + partDescription + ", pricePerItem="
				+ pricePerItem + "]";
	}

	
}
class CommissionEmployee extends Employee1{
	public CommissionEmployee(String firstName, String lastName,
			String socialSecurityNumber) {
		super(firstName, lastName, socialSecurityNumber);
		// TODO Auto-generated constructor stub
		this.commissionrate = 0;
		this.grossSales = 0;
	}

	public double getCommissionrate() {
		return commissionrate;
	}

	public void setCommissionrate(double commissionrate) {
		this.commissionrate = commissionrate;
	}

	public void setGrossSales(double grossSales) {
		this.grossSales = grossSales;
	}

	public double grossSales;
	public double commissionrate;
	
	public double getGrossSales() {
		return grossSales;
	}

	@Override
	public String toString() {
		return "CommissionEmployee [grossSales=" + grossSales
				+ ", commissionrate=" + commissionrate + "]";
	}
	@Override
	public double getPaymentAmount() {
		// TODO Auto-generated method stub
		return grossSales * commissionrate;
	}

}
class HourlyEmployee extends Employee1{
	public HourlyEmployee(String firstName, String lastName,
			String socialSecurityNumber) {
		super(firstName, lastName, socialSecurityNumber);
		// TODO Auto-generated constructor stub
		this.hours = 0;
		this.wage = 0;
	}
	
	public double getWage() {
		return wage;
	}
	public void setWage(double wage) {
		this.wage = wage;
	}
	public double getHours() {
		return hours;
	}
	public void setHours(double hours) {
		this.hours = hours;
	}

	private double wage;
	private double hours;
	@Override
	public String toString() {
		return "HourlyEmployee [wage=" + wage + ", hours=" + hours + "]";
	}
	@Override
	public double getPaymentAmount() {
		// TODO Auto-generated method stub
		return wage * hours;
	}
}
class SalariedEmployed extends Employee1{
	public SalariedEmployed(String firstName, String lastName,
			String socialSecurityNumber) {
		super(firstName, lastName, socialSecurityNumber);
		// TODO Auto-generated constructor stub
		this.weeklySalary = 0;
	}

	public double getWeeklySalary() {
		return weeklySalary;
	}

	public void setWeeklySalary(double weeklySalary) {
		this.weeklySalary = weeklySalary;
	}

	private double weeklySalary;

	@Override
	public String toString() {
		return "SalariedEmployed [weeklySalary=" + weeklySalary + "]";
	}
	@Override
	public double getPaymentAmount() {
		// TODO Auto-generated method stub
		return weeklySalary;
	}
}

class BasePlusCommisionEmployee extends CommissionEmployee{

	public BasePlusCommisionEmployee(String firstName, String lastName,
			String socialSecurityNumber) {
		super(firstName, lastName, socialSecurityNumber);
		// TODO Auto-generated constructor stub
		this.baseSalary = 0;
	}
	public double getBaseSalary() {
		return baseSalary;
	}
	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}
	private double baseSalary;
	
	@Override
	public String toString() {
		return "BasePlusCommisionEmployee [baseSalary=" + baseSalary + "]";
	}
	@Override
	public double getPaymentAmount() {
		// TODO Auto-generated method stub
		return baseSalary + (grossSales * commissionrate);
	}
}

public class Test3 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CommissionEmployee ce = new CommissionEmployee("A", "Z", "1234");
		ce.setCommissionrate(20);
		ce.setGrossSales(30);
		
		HourlyEmployee he = new HourlyEmployee("B", "Y", "2345");
		he.setHours(20);
		he.setWage(200);

		SalariedEmployed se = new SalariedEmployed("C", "X", "3456");
		se.setWeeklySalary(500);
		
		BasePlusCommisionEmployee bce = new BasePlusCommisionEmployee("D", "W", "4567");
		bce.setBaseSalary(1000);
		
		Payable i = new Invoice(1, "One", "Description", 100);
		
//		Employee1[] e = {ce, he, se, bce, (Employee1)i}; // runtime error
		
		Employee1[] e = {ce, he, se, bce};
		
		for(Employee1 emp : e)
		{
			System.out.println(emp.getClass().getSimpleName() + " -------Payment---  " +emp.getPaymentAmount());
		}
	}

}

/*OUTPUT
CommissionEmployee -------Payment---  600.0
HourlyEmployee -------Payment---  4000.0
SalariedEmployed -------Payment---  500.0
BasePlusCommisionEmployee -------Payment---  1000.0*/

