package homework;

public class MyStringLinkedList {
		Node header;
		
		MyStringLinkedList() {
			header = null;
		}
		public void addFront(String item) {
			if (header == null)
				header = new Node(null, item, null);
			else {
				Node n = new Node(null, item, header);
			    	header.previous = n;
			    	header = n;
			}
		}

	// Implement the code
		public void addLast(String item) {
			if(header == null){
				header = new Node(null, item, null);
			}else{
				// know the last element
				Node temp = header;
				while(temp.next != null){
					temp = temp.next;
				}
				Node n = new Node(temp, item, null);
				temp.next = n;
				temp = n;
			}
		}
		// implement the code
		public void postAddNode(Node n, String value){
			Node newNode;
				if(n == null){ // List is emply
					newNode = new Node(null, value, null);
				}else if(n.previous == null){
					// n is first node
					addLast(value);
				}else{
					newNode = new Node(n, value, n.next);
					n.next.previous = newNode;
					n.next = newNode;
				}
		}
	// implement the code

	       public int size(){
	    	   int count = 0;
	    	   Node temp = header;
	    	   while(temp !=null){
	    		   temp = temp.next;
	    		   count++;
	    	   }
	    	   return count;
	       }

	// implement code
	public boolean isEmpty()
	{
    	if(header==null)return true;
    	return false;
	}  
		public void preAddNode(Node n, String value){
			Node newNode;
			if (n == null){
				//List is empty
				newNode = new Node(null, value, null);
			}
			else if (n.next == null) {
				//n is the first node
				addFront(value);
			}
			else {
				newNode = new Node(n.previous, value, n);
				n.previous.next = newNode;
				n.previous = newNode;
			}	
						
		}
		public Node findLast() {
			if (header == null)
				return null;
			else {
				Node temp = header;
				while (temp.next != null)
					temp = temp.next;
				return temp;
			}
		}
		
		public Node getFirst(){
			
			if(header == null){
				return null;
			}
			else{
				return header;
			}
		}
		
		public boolean removeLast(){
			Node temp = findLast();
			deleteNode(temp);
			return true;
		}
		public boolean removeFirst(){
			Node temp = getFirst();
			deleteNode(temp);
			return true;
		}
			public Object getLast(){
				Node temp = header;
				if(temp == null) return null;
				else if(temp.next == null && temp.previous == null)
					return temp; // its only one case
				else{
					while(temp.next != null){
						temp = temp.next;
					}
					return temp;
				}
			}
		public Node findItem(String str) {
			if (header == null)
				return null;
			else {
				Node temp = header;

				while (temp != null){
					if (str.equals(temp.value))
						return temp;
					else
						temp = temp.next;
				}
			}
			return null;
		}

		public void deleteNode(Node n) {
			if (header != null && n != null) {
				if (n.next == null && n.previous == null) {
					// only one node
					header = null;
					n = null;
//					System.out.println("I am here 1");

				} else if (n.previous == null) {
					// remove first node
					n.next.previous = null;
					header = n.next;
					n = null;
//					System.out.println("I am here 2");
				} else if (n.next == null) {
					// remove last node
					n.previous.next = null;
					n = null;
//					System.out.println("I am here 3");
				} else {
					// general case
					n.next.previous = n.previous;
					n.previous.next = n.next;
					n = null;
//					System.out.println("I am here 4");
				}

			}

		}
		
		public void deleteList(){
			Node tempOne = header;
			Node tempTwo = header;
			while (tempOne != null) {
				tempOne = tempOne.next;
				tempTwo = null;
				tempTwo = tempOne;
			}
			header = null;
		}

		public String toString() {
			String str =""; 
			Node temp = header;
			while (temp != null) {
				str = str + "-->[" + temp.value.toString() + "]";
				temp = temp.next;
			}
			str = str + "-->[" + "NULL" + "]";
			return str;
		}

		public void printReverse() {
			String str =""; 
			Node temp = findLast();
			while (temp != null) {
				str = str + "==>[" + temp.value.toString() + "]";
				temp = temp.previous;
			}
			str = str + "==>[" + "NULL" + "]";
			System.out.println(str);
		}
		public Node print(Node n){
			if(n == null)
				return null; 			// base case
			System.out.println(n.value);
			return print(n.next);
			
		}
		
		public class Node {
			String value;
			Node next;
			Node previous;

			Node(Node previous, String value, Node next) {
				this.previous = previous;
				this.value = value;
				this.next = next;
			}

			public String toString() {
				return value;
			}
		}
		public static void main(String[] args) {
			MyStringLinkedList mysll = new MyStringLinkedList();
			mysll.addFront("Bimal");
			
			mysll.addFront("He ");
			mysll.addLast("Parauli");
			
			mysll.addLast(" now");
			mysll.postAddNode(mysll.findItem("ER"), " there");
			System.out.println();
			mysll.preAddNode(mysll.findItem("Bimal"), " is");
			System.out.println("The size is " + mysll.size());
			
			System.out.println(mysll);
			
			System.out.println("First element is - " + mysll.getFirst());
			System.out.println("Last Element is - " + mysll.getLast());
			
			System.out.println("First removed ---"+mysll.removeFirst());
			System.out.println(mysll);
			System.out.println("Last removed ---"+mysll.removeLast());
			System.out.println(mysll);
			
			System.out.println("----Display with recursive----");
			mysll.print(mysll.getFirst());
			}
}

/*OUTPUT:
	The size is 5
	-->[He ]-->[ is]-->[Bimal]-->[Parauli]-->[ now]-->[NULL]
	First element is - He 
	Last Element is -  now
	First removed ---true
	-->[ is]-->[Bimal]-->[Parauli]-->[ now]-->[NULL]
	Last removed ---true
	-->[ is]-->[Bimal]-->[Parauli]-->[NULL]
	----Display with recursive----
	 is
	Bimal
	Parauli*/