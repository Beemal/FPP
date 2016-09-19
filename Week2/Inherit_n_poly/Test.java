/*@author- bimal Parajuli
 * @date - 09/12/16
 */
package inheritance;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.Stack;

class DeptEmployee{
	private String name;
	private double salary;
	private LocalDate date;
	public DeptEmployee(String name, double salary, int year, int month, int day) {
		this.name = name;
		this.salary = salary;
		this.date = LocalDate.of(year, month, day);
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getHire_date() {
		return date;
	}
	public void setHire_date(int year, int month, int day) {
		this.date = LocalDate.of(year, month, day);
	}
	public double computeSalary(){
		return this.salary;
	}
}
class Professor extends DeptEmployee{
	public Professor(String name, double salary, int year, int month, int day) {
		super(name, salary, year, month, day);
		// TODO Auto-generated constructor stub
		this.noOfPublications = 0;
	}

	private int noOfPublications;

	public int getNoOfPublications() {
		return noOfPublications;
	}

	public void setNoOfPublications(int noOfPublications) {
		this.noOfPublications = noOfPublications;
	}
}
class Secretary extends DeptEmployee{
	public Secretary(String name, double salary, int year, int month, int day) {
		super(name, salary, year, month, day);
		// TODO Auto-generated constructor stub
		this.overTimeHrs = 0;
	}

	private double overTimeHrs;

	public double getOverTimeHrs() {
		return overTimeHrs;
	}

	public void setOverTimeHrs(double overTimeHrs) {
		this.overTimeHrs = overTimeHrs;
	}
	@Override
	public double computeSalary(){
		return (super.computeSalary() + (12*overTimeHrs));
	}
}
public class Test {

	public static void main(String[] args) {
		DeptEmployee[] de = new DeptEmployee[5];
		Professor p1 = new Professor("A", 10000, 1980, 10, 12);
		p1.setNoOfPublications(10);
		
		Professor p2 = new Professor("B", 20000, 1980, 02, 10);
		p2.setNoOfPublications(12);
		
		Professor p3 = new Professor("C", 30000, 1981, 11, 10);
		p3.setNoOfPublications(15);
		
		de[0] = p1;
		de[1] = p2;
		de[2] = p3;
		
		Secretary s1 = new Secretary("D", 5000, 1990, 10, 03);
		s1.setOverTimeHrs(20);
		
		Secretary s2 = new Secretary("E", 7000, 1992, 07, 12);
		s2.setOverTimeHrs(22);
		
		de[3] = s1;
		de[4] = s2;
		
		// Populate created Array
	for(DeptEmployee d : de){
		System.out.println(d.getClass().getSimpleName()+"-- Name "+d.getName()+" Hire_Date "+d.getHire_date()+" Salary "+d.computeSalary());
	}
	System.out.println("Want to See Sum of All Employee ");
	Scanner sc = new Scanner(System.in);
	String c = sc.next();
	if(c.equals("y") || c.equals("Y")){
		double sum1 = 0;
		double sum2 =0;
		for(DeptEmployee d : de){
		if(d.getClass().getSimpleName().equals("Secretary"))
			sum1 += d.computeSalary();
		else
			sum2 += d.computeSalary();
		}
		System.out.println("The sum of Secretaries Salary = "+sum1);
		System.out.println("The sum of Professors Salary = "+sum2);
		System.out.println("The sum of All Employees Salary = "+(sum1+sum2));
		
	}
	}

}

/*OUTPUT
Professor-- Name A Hire_Date 1980-10-12 Salary 10000.0
Professor-- Name B Hire_Date 1980-02-10 Salary 20000.0
Professor-- Name C Hire_Date 1981-11-10 Salary 30000.0
Secretary-- Name D Hire_Date 1990-10-03 Salary 5240.0
Secretary-- Name E Hire_Date 1992-07-12 Salary 7264.0
Want to See Sum of All Employee 
Y
The sum of Secretaries Salary = 12504.0
The sum of Professors Salary = 60000.0
The sum of All Employees Salary = 72504.0
*/


