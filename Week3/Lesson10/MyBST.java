
package homework;

import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;
// Demo code for the user implemenation of Binary search tree
public class MyBST {
	/** The tree root. */
	private BinaryNode root;

	public MyBST() {
		root = null;
	}
	
	/**
	* Prints the values in the nodes of the tree
	* in sorted order. Inorder Traversal
	*/
	public void printTree() {
		if( root == null )
			System.out.println( "Empty tree" );
		else
			printTree(root);
	}
	
	public BinaryNode getRoot(){return root;}
	public int leafNodes(BinaryNode t)
	{//implement
		return 0;
		
	}
	
	// Inorder Traversal to print the nodes in Ascending order
	public boolean contains(int key)
	{//implement
		if (root == null) {
			//root = new BinaryNode(x);
			return false;
		}
		else { 
			BinaryNode n = root;
			
			boolean checked = false;
			
			while(!checked)//true
				{
				if(((Integer)key).compareTo(n.element)<0) {
					//space found on the left
					if(n.left == null){
						checked=false;
						break;
					}
					//keep looking for a place to insert (a null)
					else {
						n = n.left;
					}
				}				
				else if(((Integer)key).compareTo(n.element)>0){ 
					//space found on the right					
					if(n.right==null){
					checked=false;
					break;
					}
						//keep looking for a place to insert (a null)
					else {
							n = n.right;
					}
										
				}
				// if a node already exists
				else if(((Integer)key).compareTo(n.element)==0){
					checked = true;
				}

				}
			return checked;
		}

		
	}
	private void printTree( BinaryNode t ){
		if( t != null ){
			printTree( t.left );
		    System.out.print(t.element+",");
		    printTree( t.right );
		} 
	}
	public void preOrder() {
		if( root == null )
			System.out.println( "Empty tree" );
		else
			preOrder(root);
	}
	public int size()
	{
		if(root==null)return 0 ;
		else
		return sizeOf(root)-1;
	}
	public int leafNode()
	{
		if(root==null)return 0 ;
		else
		return leafNode(root);
	}
	
	private int leafNode(BinaryNode t)
	{
		int count=0;
		if(t!=null)
		{
			if(t.left==null&&t.right==null)return 1;
			else count= count+leafNode(t.left)+leafNode(t.right);
		}
		
		return count;
	}
	
	private int sizeOf (BinaryNode t)
	{
		int count=1;
		if(t!=null)
		{
			
			count=sizeOf(t.left)+sizeOf(t.right);
		}
		//else return 0;
		
		return count;
	}
	private void preOrder(BinaryNode t)
	{
		if( t != null ){
			 System.out.print(t.element+",");
			 preOrder( t.left );
			 preOrder( t.right );
		} 
		
	}
	public boolean isEmpty()
	{
		if (root==null)return true;
		else return false;
	}
	public void postOrder() {
		if( root == null )
			System.out.println( "Empty tree" );
		else
			postOrder(root);
	}
	private void postOrder(BinaryNode t)
	{
		if( t != null ){
			 
			postOrder( t.left );
			postOrder( t.right );
		    System.out.print(t.element+",");
		} 
		
	}
		 
	//Assume the data in the Node is an Integer.	

	public void insert(Integer x) {
		if (root == null) {
			root = new BinaryNode(x);
			return;
		}
		else { 
			BinaryNode n = root;
			boolean inserted = false;

			while(!inserted)//true
				{
				if(x.compareTo(n.element)<0) {
					//space found on the left
					if(n.left == null){
						n.left = new BinaryNode(x,null,null);
						inserted = true;
					}
					//keep looking for a place to insert (a null)
					else {
						n = n.left;
					}
				}				
				else if(x.compareTo(n.element)>0){ 
					//space found on the right					
					if(n.right==null){
					n.right = new BinaryNode(x,null,null);
					inserted = true;
					}
						//keep looking for a place to insert (a null)
					else {
							n = n.right;
					}
										
				}
				// if a node already exists
				else {
					inserted = true;
				}

			}

		}
	}
	private class BinaryNode {

		private Integer element;// The data in the node
		private BinaryNode left;      // Left child
		private BinaryNode right;     // Right child	  
		// Constructors 
		
		BinaryNode( Integer theElement ){
			this( theElement, null, null );
		}	

		BinaryNode( Integer element, BinaryNode left, BinaryNode right ){
			this.element = element;
			this.left = left;
			this.right = right;
		}
		
	}
		

	public static void main(String[] args) {
		
		MyBST mybst = new MyBST();
		
		int [] a = {15, 12, 9, 56, 1, 16, 19, 22, 3, 100, 2, 25};
	
		for (int j = 0; j < a.length; j++ ) {
			mybst.insert(a[j]);
					
		}
		mybst.insert(12);
		System.out.println("IN Order");
		mybst.printTree();
		System.out.println("Post Order");
		
		mybst.postOrder();
		System.out.println("Preorder");
		mybst.preOrder();
		
		System.out.println("It contains 25:"+mybst.contains(25));
		System.out.println("It contains 200:"+mybst.contains(200));
		System.out.println("It contains "+mybst.size()+" No of ELements");
		System.out.println("No of Leaf elements in this binary tree is "+mybst.leafNode());
		
	}
}