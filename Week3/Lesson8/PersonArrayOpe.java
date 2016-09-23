package homework;

class Person {
	private String lastName;
	private String firstName;
	private int age;

	 public Person(String last, String first, int a)
	 { // constructor to initialize the values
		 lastName = last;
		 firstName = first;
		 age = a;
	 }
	@Override
	public String toString() {
		return "Person [lastName=" + lastName + ", firstName=" + firstName
				+ ", age=" + age + "]";
	}
	 public String getLastName() // get only the last name
	 {
		 return lastName;
	 }
} // end class Person

class PersonArrayOpe {
	 private Person[] a; // reference to array
	 private int size; // No. of elements currently hold
	 int count = 0;
	 public PersonArrayOpe(int max) // constructor to initialize person array
	 {
		 size = 0;
		 a = new Person[max]; 
	 }
	 public Person find(String searchName) // Pass Lastname as an argument
	 {
		 for(Person p: a)
		 {
			 if(searchName.equals(p.getLastName())) return p;
		 }
		 return null;
	 }
	 public void insert(String last, String first, int age)// Insert at last // once we insert a, stop looping
	 {
		 for(int i=0;i<a.length;i++){
			 if(size >= a.length) resize();
			 if(a[i] == null){
				 a[i] = new Person(last, first, age);
				 size++;
				 break;
			 }
			 }
	 }
	 public boolean delete(String searchName) // Shift down the elements. Argument should be lastname
	 {
		 int index = -1; 
		 for(int i = 0; i < a.length; i++)
		 {
			 if(a[i] != null){
			 if(searchName.equals(a[i].getLastName()))
				 	index = i;
			 }
		 }

		 if(index == -1) return false;
		 a[index] = null;             // to delete make it null
		 
		 //	now we shift the position
			 for(int i = index; i < a.length;i++){
				 if(a[i] != null){
				 a[index] = a[index+1];
				 index++;
				 }
			 }
				 // make the last value also null after shifting
			a[index] = null; 
			 size--;
		 return true;
	 }
	 public void displayAll(){ // displays array contents
		 for(int i = 0; i < a.length; i++){
			 if(a[i] != null)
			 System.out.println("Array - "+i+" ="+a[i]+" Size = "+size());
		 }
	 }
	 public int size() // Return the number of persons stored in the array
	 {
		 return size;
	 }
	 private void resize(){
		 int len = a.length;
		 int newlen = a.length * 2;
		 Person[] temp = new Person[newlen];
		 System.arraycopy(a, 0, temp, 0, len);
		 a = temp;
	 }
	 
	 public static void main(String[] args) {
			PersonArrayOpe pArr = new PersonArrayOpe(10);
			pArr.insert("Parajuli", "Bimal", 25);
			pArr.insert("Pun", "Ram", 26);
			pArr.insert("Poudel", "Bishal", 28);
			pArr.insert("Regmi", "Bimesh", 24);
			pArr.insert("Sai", "Bijay", 25);
			pArr.insert("Gurung", "Amit", 12);
			pArr.delete("Poudel");
	
			System.out.println(pArr.find("Parajuli"));
			pArr.displayAll();
		}
}


/*OUTPUT
Person [lastName=Parajuli, firstName=Bimal, age=25]
Array - 0 =Person [lastName=Parajuli, firstName=Bimal, age=25] Size = 5
Array - 1 =Person [lastName=Pun, firstName=Ram, age=26] Size = 5
Array - 2 =Person [lastName=Regmi, firstName=Bimesh, age=24] Size = 5
Array - 3 =Person [lastName=Sai, firstName=Bijay, age=25] Size = 5
Array - 4 =Person [lastName=Gurung, firstName=Amit, age=12] Size = 5
*/
