package homework;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;


class Registration {
	int regno; // Registration number
	String cname; // Name of the Course
	String sname; // Name of the student
	String sid; // Student id
	public Registration(int regno, String cname, String sname, String sid) {
		this.regno = regno;
		this.cname = cname;
		this.sname = sname;
		this.sid = sid;
	}
	// Create a constructor to initialize the values
	@Override
	public String toString() {
		return "Registration [regno=" + regno + ", cname=" + cname + ", sname="
				+ sname + ", sid=" + sid + "\n]";
	}
	
	
}

public class PredefinedPriority {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Registration r1 = new Registration(3, "FPP", "Sam", "c123");
		Registration r2 = new Registration(1, "MPP", "Charles", "b312");
		Registration r3 = new Registration(2, "Big DATA", "John", "a234");
		Registration r4 = new Registration(5, "WAP", "Don", "v234");
		Registration r5 = new Registration(4, "EA", "Charlie", "e234");
		
		PriorityQueue<Registration> qobject = new PriorityQueue<Registration>(sidComparator);
		qobject.add(r1);
		qobject.add(r2);
		qobject.add(r3);
		qobject.add(r4);
		qobject.add(r5);
				
		Iterator it = qobject.iterator();
		
		System.out.println("The Peek Object is : "+qobject.peek());
		System.out.println("The size of Queue is: "+qobject.size());
		
		if(qobject.remove(r2))
				System.out.println("The data of "+r2.sname+" with sid "+r2.sid +"is removed");
		System.out.println("------List of Elements by removing-------");
		while(it.hasNext()){
			Registration r = qobject.remove();
			System.out.println(r);
		}	
		if(qobject.isEmpty()){
			System.out.println("The Queue is empty");
		}
		
	}

	public static Comparator<Registration> sidComparator = new Comparator<Registration>() {
		public int compare(Registration ra, Registration rb){
			return (int)((ra.sid).compareTo(rb.sid));
		}
	};
}

/*OUTPUT:
	The Peek Object is : Registration [regno=2, cname=Big DATA, sname=John, sid=a234
	]
	The size of Queue is: 5
	The data of Charles with sid b312is removed
	------List of Elements by removing-------
	Registration [regno=2, cname=Big DATA, sname=John, sid=a234
	]
	Registration [regno=3, cname=FPP, sname=Sam, sid=c123
	]
	Registration [regno=4, cname=EA, sname=Charlie, sid=e234
	]
	Registration [regno=5, cname=WAP, sname=Don, sid=v234
	]
	The Queue is empty
*/
