package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Marketing {
	private String employeename;
	private String productname;
	private double salesamount;

	public Marketing(String ename, String pname, double amt) {
		employeename = ename;
		productname = pname;
		salesamount = amt;
	}

	public final static Comparator EMPNAME = new Comparator() {
		public int compare(Object o1, Object o2) {
			String e1 = ((Marketing) o1).getEmployeename();
			String e2 = ((Marketing) o2).getEmployeename();

			return e1.compareTo(e2);
		}
	};
	public final static Comparator SALES = new Comparator() {
		public int compare(Object o1, Object o2) {
			Double s1 = ((Marketing) o1).getSalesamount();
			Double s2 = ((Marketing) o2).getSalesamount();

			return s1.compareTo(s2);
		}
	};

	public String getEmployeename() {
		return employeename;
	}

	public double getSalesamount() {
		return salesamount;
	}

	public void setAmt(double amt) {
		this.salesamount = amt;
		System.out.println("Amount of " + this.employeename + " set to " + amt);
	}

	@Override
	public String toString() {
		return "Marketing [employeename=" + employeename + ", productname="
				+ productname + ", salesamount=" + salesamount + "]\n";
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marketing m1 = new Marketing("Tom", "Shampoo", 200.20);
		Marketing m2 = new Marketing("Harry", "Shoes", 100.20);
		Marketing m3 = new Marketing("Charles", "Bags", 800.20);
		Marketing m4 = new Marketing("Bond", "Car", 1221.21);
		Marketing m5 = new Marketing("James", "Airplane", 32112.21);
		Marketing m6 = new Marketing("Ram_Chandra", "Bus", 5676.21);
		
		
		ArrayList<Marketing> mArrList = new ArrayList<Marketing>();   // Arraylist of class Marketing
		mArrList.add(m1);   		 // adding objects to marketing
		mArrList.add(m2);
		mArrList.add(m3);
		mArrList.add(m4);
		mArrList.add(m5);
		
		System.out.println(mArrList);
		mArrList.remove(0); 			// removing object from Marketing
		System.out.println(mArrList);
		
		mArrList.set(0, m6);			// set the object of index 0 with index 4
		System.out.println(mArrList);
		System.out.println("-----------------------Sort with emp name--------------------------");
		Collections.sort(mArrList, Marketing.EMPNAME); // sort According to  employee name
		System.out.println(mArrList);
		
		System.out.println("-----------------------Sort with sales amt-------------------------");
		Collections.sort(mArrList, Marketing.SALES); // sort According to  sales-amt
		System.out.println(mArrList);
		
		System.out.println("Size of the List = "+ mArrList.size());
	}

}

/*OUTPUT
[Marketing [employeename=Tom, productname=Shampoo, salesamount=200.2]
, Marketing [employeename=Harry, productname=Shoes, salesamount=100.2]
, Marketing [employeename=Charles, productname=Bags, salesamount=800.2]
, Marketing [employeename=Bond, productname=Car, salesamount=1221.21]
, Marketing [employeename=James, productname=Airplane, salesamount=32112.21]
]
[Marketing [employeename=Harry, productname=Shoes, salesamount=100.2]
, Marketing [employeename=Charles, productname=Bags, salesamount=800.2]
, Marketing [employeename=Bond, productname=Car, salesamount=1221.21]
, Marketing [employeename=James, productname=Airplane, salesamount=32112.21]
]
[Marketing [employeename=Ram_Chandra, productname=Bus, salesamount=5676.21]
, Marketing [employeename=Charles, productname=Bags, salesamount=800.2]
, Marketing [employeename=Bond, productname=Car, salesamount=1221.21]
, Marketing [employeename=James, productname=Airplane, salesamount=32112.21]
]
-----------------------Sort with emp name--------------------------
[Marketing [employeename=Bond, productname=Car, salesamount=1221.21]
, Marketing [employeename=Charles, productname=Bags, salesamount=800.2]
, Marketing [employeename=James, productname=Airplane, salesamount=32112.21]
, Marketing [employeename=Ram_Chandra, productname=Bus, salesamount=5676.21]
]
-----------------------Sort with sales amt-------------------------
[Marketing [employeename=Charles, productname=Bags, salesamount=800.2]
, Marketing [employeename=Bond, productname=Car, salesamount=1221.21]
, Marketing [employeename=Ram_Chandra, productname=Bus, salesamount=5676.21]
, Marketing [employeename=James, productname=Airplane, salesamount=32112.21]
]
Size of the List = 4

*/
