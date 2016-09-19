import java.util.Arrays;

public class MyTable {
    private Entry[] entries = new Entry[26];


    //returns the String that is matched with char c in the table
    public String get(char c){
        int position = (int) (Character.toLowerCase(c)) - (int) 'a';
        return  entries[position].toString();
    }
    //adds to the table a pair (c, s) so that s can be looked up using c
    public void add(char c, String s) {
        int position = (int) c- (int) 'a';
        this.entries[position]= new Entry(s,c);

    }
    //returns a String consisting of nicely formatted display
    //of the contents of the table
    public String toString() {
        String s= "";
        for(int i=0;i<entries.length;i++){
            if(entries[i]!=null)
            s+=  "\n" +entries[i].toString();
        }
        return s;
    }


    private class Entry {
        private String str;
        private char ch;

        Entry(String str, char ch){
            this.str = str;
            this.ch = ch;
        }
        //returns a String of the form "ch->str"
        public String toString() {
            return this.ch+"->"+this.str;
        }
    }

    public static  void main(String[] args){
        MyTable t = new MyTable();
        t.add('a', "Andrew");
        t.add('b',"Billy");
        t.add('c',"Charlie");
        String s = t.get('b');
        System.out.println(s);
        System.out.println(t);

    }

}