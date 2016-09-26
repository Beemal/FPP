import java.io.*;
import java.util.Scanner;
////////////////////////////////////////////////////////////////
class DataItem
{                                // (could have more data)
private String email_id;               // data item (key)
private String name;
//--------------------------------------------------------------
public DataItem(String ii, String v)          // constructor
   { email_id = ii;
     name = v;
   }
//--------------------------------------------------------------
public String getKey()
   { return email_id; }
public String getValue()
{ return name; }
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((email_id == null) ? 0 : email_id.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	DataItem other = (DataItem) obj;
	if (email_id == null) {
		if (other.email_id != null)
			return false;
	} else if (!email_id.equals(other.email_id))
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	return true;
}

//--------------------------------------------------------------
}  // end class DataItem
////////////////////////////////////////////////////////////////
class HashTable
{
private DataItem[] hashArray;    // array holds hash table
private int arraySize;
private DataItem nonItem;        // for deleted items
//-------------------------------------------------------------
public HashTable(int size)       // constructor
   {
   arraySize = size;
   hashArray = new DataItem[arraySize];
   nonItem = new DataItem("-1","null");   // deleted item key is -1
   }
//-------------------------------------------------------------

public void displayTable()
   {
   System.out.println("Table: ");
   for(int j=0; j<arraySize; j++)
      {
      if(hashArray[j] != null)
         System.out.println("Index : " + j + " " + hashArray[j].getKey() + " " + hashArray[j].getValue());
      else
         System.out.println("Index : " + j + " " + "**");
      }
   System.out.println("");
   }
//-------------------------------------------------------------
public int hashFunc(String key)
   {
	int temp=key.hashCode();
	temp = Math.abs(temp);
   return temp % arraySize;       // hash function
   }
//-------------------------------------------------------------
public void insert(String key, String v) // insert a DataItem
// (assumes table not full)
   {
        // extract key
   int hashVal = hashFunc(key);  // hash the key
                                 // until empty cell 
// an index have some data and not match with existing key, it find next vacant position 
   while(hashArray[hashVal] != null &&
                   hashArray[hashVal].getKey() != key) 
      {
      ++hashVal;                 // go to next cell
      hashVal %= arraySize;      // wraparound if necessary
      }
   DataItem obj = new DataItem(key,v);
   hashArray[hashVal] = obj;    // insert item
   }  // end insert()
//-------------------------------------------------------------
public DataItem delete(String key)  // delete a DataItem
   {
   int hashVal = hashFunc(key);  // hash the key

   while(hashArray[hashVal] != null)  // until empty cell,
      {                               // found the key?
      if(hashArray[hashVal].getKey().equals(key))
         {
         DataItem temp = hashArray[hashVal]; // save item
         hashArray[hashVal] = nonItem;       // delete item
         return temp;                        // return item
         }
      ++hashVal;                 // go to next cell
      hashVal %= arraySize;      // wraparound if necessary
      }
   return null;                  // can't find item
   }  // end delete()
//-------------------------------------------------------------
public boolean find(String key)    // find item with key
   {
   int hashVal = hashFunc(key);  // hash the key

   while(hashArray[hashVal] != null)  // until empty cell,
      {                               // found the key?
      if(hashArray[hashVal].getKey().equals(key))
         return true;   // yes, return item
      ++hashVal;                 // go to next cell
      hashVal %= arraySize;      // wraparound if necessary
      }
   return false;                  // can't find item
   }
//-------------------------------------------------------------
}  // end class HashTable
////////////////////////////////////////////////////////////////
class HashTableApp
{
public static void main(String[] args) throws IOException
   {
   String mail;
   String name;
                               
   Scanner in = new Scanner(System.in);
   System.out.print("Enter size of hash table: ");
   int size = in.nextInt();
                             
   HashTable theHashTable = new HashTable(size);
  
   theHashTable.insert("rmohanraj@mum.edu","Renuka Mohanraj");
   theHashTable.insert("pcorraza@mum.edu","Paul Corraza");
   theHashTable.insert("joelermon@mum.edu","Joe Lermon");
   theHashTable.insert("bimalparajulise@gmail.com","Bimal");
   
     while(true)                   // interact with user
      {
      System.out.print("Enter first letter of ");
      System.out.print("show, insert, delete, or find: ");
      char choice = in.next().charAt(0); //Read a Char from the console
      switch(choice)
         {
         case 's':
            theHashTable.displayTable();
            break;
         case 'i':
         System.out.print("Enter key and value to insert: ");
            mail = in.next();
            name = in.next();
            theHashTable.insert(mail,name);
            break;
         case 'd':
            System.out.print("Enter key value to delete: ");
            mail = in.next();
            theHashTable.delete(mail);
            break;
         case 'f':
            System.out.print("Enter key value to find: ");
            mail = in.next();
            System.out.println("Key Found status" + theHashTable.find(mail));
            break;
         default:
            System.out.print("Invalid entry\n");
         }  // end switch
      }  // end while
   }  // end main()

//--------------------------------------------------------------
}