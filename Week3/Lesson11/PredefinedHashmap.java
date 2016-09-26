/** @author bimal
 * @Date 24 sept 2016
 */
import java.util.HashMap;
import java.util.Map;

class Course{
	String c_name;
	String[] faculty;
	public Course(String c_name, String[] faculty) {
		this.c_name = c_name;
		this.faculty = faculty;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String[] getFaculty() {
		return faculty;
	}
	public void setFaculty(String[] faculty) {
		this.faculty = faculty;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder("[ ");
		for(int i=0; i<faculty.length; i++){
		sb.append(" ,"+faculty[i]);
		}
		sb.append("] ");
		return sb.toString();
	}
	
}
public class PredefinedHashmap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String,Course> hm = new HashMap();
		String[] s1 = {"Renuka", "Joe Lerman", "Paul"};
		String[] s2 = {"John", "Peter", "Charles"};
		String[] s3 = {"Andrew", "Marlie", "Hye"};
		
		Course c1 = new Course("FPP", s1);
		Course c2 = new Course("MPP", s2);
		Course c3 = new Course("DATABASE", s3);
		
		hm.put("CS390", c1);
		hm.put("CS490", c2);
		hm.put("CS500", c3);
		
		System.out.println("Exists Course Id in the list -- . ("+ hm.containsKey("CS390")+")");
		
		Course getc1 = hm.get("CS390");
		System.out.println("The faculty members are: -"+getc1);
		
		System.out.println("The key is :"+getKeyFromValue(hm, c1));
		
		System.out.println("-----------All the values-------");
		System.out.println(hm);
		System.out.println("The size of Map is "+hm.size());
		}
	public static Object getKeyFromValue(HashMap hm, Object c){
		for(Object o: hm.keySet()){
			if(hm.get(o).equals(c)){
				return o;
			}
		}
		return null;
	}
}

/*OUTPUT:
	Exists Course Id in the list -- . (true)
	The faculty members are: -[  ,Renuka ,Joe Lerman ,Paul] 
	The key is :CS390
	-----------All the values-------
	{CS500=[  ,Andrew ,Marlie ,Hye] , CS390=[  ,Renuka ,Joe Lerman ,Paul] , CS490=[  ,John ,Peter ,Charles] }
	The size of Map is 3
*/
