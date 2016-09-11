package recursive;

public class BinarySearch {

	public static void main(String args[])
	{
		int[] haystack = {2,4,5,7,8,10,15,18,20,23,42,54};
		int needle = 7;
		int found_index = sort(haystack, needle, 0, haystack.length);
		System.out.println(found_index);
	}

	private static int sort(int[] haystack, int needle, int start, int end) {
		
		int mid_index = start + ((end - start)/2);
		
		if(haystack[mid_index] == needle)
			return mid_index;
		
		if(start + 1 == end)
			return -1;
		
		if(haystack[mid_index] > needle)
			return sort(haystack, needle, start, mid_index);
		else
			return sort(haystack, needle, mid_index, end);
	}
}
