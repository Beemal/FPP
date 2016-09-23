package homework;
class MyQueue{
	private int front;
	private int rear;
	private int size;
	int[] qArr;
	public MyQueue(int length) {
		// TODO Auto-generated constructor stub
		size = 0;
		front = -1;
		rear = -1;
		qArr = new int[length];
	}
	
	public boolean isEmpty(){
		return (rear == -1 && front == -1);
	}
	public void add(int i){
		size++;
		if(isEmpty()) 
		{					// if empty, add single val
			rear = 0;
			front = 0;
			qArr[rear] = i;
		}
		 else if (rear + 1 >= size)
	            return ;
	     else if ( rear + 1 < size)
	            qArr[++rear] = i; 
	}
	public int remove(){
		int val;
		if(isEmpty()) return -1;
		else 
        {
            size-- ;
            val = qArr[front];
            if ( front == rear) 
            {
                front = -1;
                rear = -1;
            }
            else
                front++;        
        } 
		return val;
	}
	public int peek(){
		if(isEmpty()) return 0;
		else{
			return qArr[front];
		}
	}
	public void displayAll() {
		System.out.println("-----Elements in the Array----");
		for(int q: qArr){
			if(q != 0 )
		System.out.println(q);
		}
	}
	public int size(){
		return size;
	}

	@Override
	public String toString() {
		String s = "------The elements are :------\n";
		for(int i = front; i<=rear; i++){
			s = s + qArr[i]+"\n";
		}
		s = s+ "The Peak value now is "+ peek()+"\n";
		s = s +"The size is "+size();
		return s;
	}
	
}
public class QueueArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue mq = new MyQueue(5);
		mq.add(16);
		mq.add(1);
		mq.add(15);
		mq.add(2);
		mq.add(7);
		
		System.out.println("The removed item is "+mq.remove());
		System.out.println(mq);
	}

}

/*OUTPUT:
	The removed item is 16
	------The elements are :------
	1
	15
	2
	7
	The Peak value now is 1
	The size is 4*/
