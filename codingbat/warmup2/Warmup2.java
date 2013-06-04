package codingbat.warmup2;

public class Warmup2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Warmup2 w = new Warmup2();
		w.s("======Output=======");
		w.s(w.has271(new int[]{2, 7, 3}));
		w.s(w.has271(new int[]{2, 7, -1}));
		w.s(w.has271(new int[]{4, 5, 3, 8, 0}));
		w.s("======false=======");
		w.s(w.has271(new int[]{2, 7, 4}));
		w.s(w.has271(new int[]{2, 7, -2}));
		w.s(w.has271(new int[]{2, 7, 5, 10, 1}));
		
		w.s("======End=======");
	}
	/*
	 * Given an array of ints, return true 
	 * if it contains a 2, 7, 1 pattern -- a value, 
	 * followed by the value plus 5, 
	 * followed by the value minus 1. 
	 * Additionally the 271 counts 
	 * even if the "1" differs by 2 or less from the correct value. 
	 * 
	 * has271({1, 2, 7, 1}) → true
	 * has271({1, 2, 8, 1}) → false
	 * has271({2, 7, 1}) → true
	 * 
	 * has271({2, 7, 3}) → true
	 * has271({2, 7, -1}) → true
	 * has271({4, 5, 3, 8, 0}) → true
	 * 
	 * has271({2, 7, 4}) → false
	 * has271({2, 7, -2}) → false
	 * has271({2, 7, 5, 10, 1}) → false
	 * has271({2, 7, -2, 4, 10, 2}) → false
	 */
	public boolean has271(int[] nums) {
		// Iterate < length-2, so can use i+1 and i+2 in the loop.
		  // Return true immediately when seeing 271.
		  for (int i=0; i < (nums.length-2); i++) {
		    int val = nums[i];
		    if (nums[i+1] == (val + 5) &&
		      Math.abs(nums[i+2] - (val-1)) <= 2)  return true;
		  }
		  
		  // If we get here ... none found.
		  return false;
	}
	
	/*
	 * Given an array of ints, 
	 * we'll say that a triple is a value appearing 3 times 
	 * in a row in the array. Return true 
	 * if the array does not contain any triples.
	 * 
	 * noTriples({1, 1, 2, 2, 1}) → true
	 * noTriples({1, 1, 2, 2, 2, 1}) → false
	 * noTriples({1, 1, 1, 2, 2, 2, 1}) → false
	 * 
	 * noTriples({1, 1, 1}) → false
	 */
	public boolean noTriples(int[] nums) {
		if(nums.length<3) return true;
		Boolean ans = true;
		for(int i=0; i<nums.length;i++){
			if(i+2<nums.length){
				if(nums[i+1]==nums[i] && nums[i+2]==nums[i]){
					ans = false;
				}
			}
		}
		return ans;
		
		/*
		 * Solution
		  
		  // Iterate < length-2, so can use i+1 and i+2 in the loop.
		  // Return false immediately if every seeing a triple.
		  for (int i=0; i < (nums.length-2); i++) {
		    int first = nums[i];
		    if (nums[i+1]==first && nums[i+2]==first) return false;
		  }
		  
		  // If we get here ... no triples.
		  return true;
		 
		 */
	}
	
	/*
	 * Given an array of ints, 
	 * return the number of times 
	 * that two 6's are next to each other in the array. 
	 * Also count instances where the second "6" is actually a 7. 
	 * 
	 * array667({6, 6, 2}) → 1
	 * array667({6, 6, 2, 6}) → 1
	 * array667({6, 7, 2, 6}) → 1
	 */
	public int array667(int[] nums) {
		int count=0;
		for(int i=0;i<nums.length;i++){
			if(i < nums.length-1 && nums[i] == 6){
				int nextNum = nums[i+1];
				if(nextNum == 6 || nextNum == 7) count++;
			}
		}
		
		return count;
	}
	/*
	 * Suppose the string "yak" is unlucky. Given a string, 
	 * return a version where all the "yak" are removed, 
	 * but the "a" can be any char. The "yak" strings will not overlap.
	 * stringYak("yakpak") → "pak"
	 * stringYak("pakyak") → "pak"
	 * stringYak("yak123ya") → "123ya" 
	 */
	public String stringYak(String str) {
		String result = "";
		for (int i=0; i<str.length(); i++) {
		    // Look for i starting a "yak" -- advance i in that case
			if (i+2<str.length() && str.charAt(i)=='y' && str.charAt(i+2)=='k') {
			  i =  i + 2;
			} else { // Otherwise do the normal append
			      result = result + str.charAt(i);
			}
		}	  
	  	return result;
	}
	
	
	/*
	 * Given a string,
	 *  return a string made of the chars at indexes 0,1, 4,5, 8,9 ... 
	 *  so "kittens" yields "kien". 
	 *  
	 * altPairs("kitten") → "kien"
	 * altPairs("Chocolate") → "Chole"
	 * altPairs("CodingHorror") → "Congrr"
	 * 
	 * altPairs("Chocolate") → "Chole"
	 * altPairs("y") → "y"
	 */
	public String altPairs(String str) {
		String altString="";
		for(int i=0;i<str.length();i++){
			if(i%4==0){
				if(i==str.length()-1){
					altString += str.substring(i, i+1);
				}else{
					altString += str.substring(i, i+2);
				}
				
			}
			
		}
		return altString;
		/*
		 * Solution
		 * 
			  String result = "";
	  
			  // Run i by 4 to hit 0, 4, 8, ...
			  for (int i=0; i<str.length(); i += 4) {
			    // Append the chars between i and i+2
			    int end = i + 2;
			    if (end > str.length()) {
			      end = str.length();
			    }
			    result = result + str.substring(i, end);
			  }
			  
			  return result;
		 * 
		 */
	}
	/*
	 * Given a string, 
	 * return a version where all the "x" have been removed. 
	 * Except an "x" at the very start or end should not be removed. 
	 * 
	 * stringX("xxHxix") → "xHix"
	 * stringX("abxxxcd") → "abcd"
	 * stringX("xabxxxcdx") → "xabcdx"
	 * 
	 * stringX("xxHxix") → "xHix"
	 * stringX("xabxxxcdx") → "xabcdx"
	 * stringX("xKittenx") → "xKittenx"
	 * stringX("xx") → "xx"
	 */
	public String stringX(String str) {
		String newString="";
		for(int i=0;i<str.length();i++){
			String s = str.substring(i,i+1);
			if(!s.equals("x")) {
				newString += s;
			}
			
			if(i==0 || i==str.length()-1){
				if(s.equals("x")){
					newString += s;
				}
			}
		}
		return newString;
		
		/*
		 * Solution
		 
		  String result = "";
		  for (int i=0; i<str.length(); i++) {
		    // Only append the char if it is not the "x" case
		    if (!(i > 0 && i < (str.length()-1) && str.substring(i, i+1).equals("x"))) {
		      result = result + str.substring(i, i+1); // Could use str.charAt(i) here
		    }
		  }
		  return result;
				 */
		
	}
	
	/*
	 * Given 2 strings, a and b, return the number of the positions 
	 * where they contain the same length 2 substring. 
	 * So "xxcaazz" and "xxbaaz" yields 3, 
	 * since the "xx", "aa", and "az" substrings appear 
	 * in the same place in both strings. 
	 * stringMatch("xxcaazz", "xxbaaz") → 3
	 * stringMatch("abc", "abc") → 2
	 * stringMatch("abc", "axc") → 0
	 * stringMatch("he", "hello") → 1
	 * stringMatch("h", "hello") → 0
	 * stringMatch("", "hello") → 0
	 * 
	 */
	public int stringMatch(String a, String b) {
		if(a.length()<1 || b.length()< 1) return 0;
		int matched = 0;
		int iterate = Math.min(a.length(), b.length());
		for(int i=0;i<iterate-1;i++){
//			s(a.substring(i, i+2));
			if(a.substring(i, i+2).equals(b.substring(i, i+2))) matched++;
		}
		return matched;
		
		/*
		 * Solution
		 *   // Figure which string is shorter.
			  int len = Math.min(a.length(), b.length());
			  int count = 0;
			  
			  // Look at both substrings starting at i
			  for (int i=0; i<len-1; i++) {
			    String aSub = a.substring(i, i+2);
			    String bSub = b.substring(i, i+2);
			    if (aSub.equals(bSub)) {  // Use .equals() with strings
			      count++;
			    }
			  }
			
			  return count;
		 */
	}
	/*
	 * Given an array of ints, return true if .. 1, 2, 3, 
	 * .. appears in the array somewhere. 
	 * array123({1, 1, 2, 3, 1}) → true
	 * array123({1, 1, 2, 4, 1}) → false
	 * array123({1, 1, 2, 1, 2, 3}) → true
	 */
	public boolean array123(int[] nums) {
		Boolean ans = false;
		for(int i=0;i<nums.length;i++){
			if(i<nums.length-2){
				if(nums[i]==1 && nums[i+1]==2 && nums[i+2]==3){
					ans=true;
					break;
				}
			}
			
		}
		return ans;
		/*
		 * Solution
		 * 
		 * // Note: iterate < length-2, so can use i+1 and i+2 in the loop
		  for (int i=0; i < (nums.length-2); i++) {
		    if (nums[i]==1 && nums[i+1]==2 && nums[i+2]==3) return true;
		  }
		  return false;
		 */
	}
	
	/*
	 * Given an array of ints, return true 
	 * if one of the first 4 elements in the array is a 9.  
	 * The array length may be less than 4. 
	 * 
	 *arrayFront9(new int[]{1, 2, 9, 3, 4}) → true
	 *arrayFront9(new int[]{1, 2, 3, 4, 9}) → false
	 *arrayFront9(new int[]{1, 2, 3, 4, 5}) → false
	 *arrayFront9({1, 2, 3}) → false
	 *arrayFront9({5, 5}) → false
	 *arrayFront9({2}) → false
	 *arrayFront9({}) → false
	 * 
	 */
	public boolean arrayFront9(int[] nums) {
		int loop = nums.length<4? nums.length:4;	
		Boolean ans = false;
		for(int i=0;i<loop;i++){
			if(nums[i]==9){
				ans = true;
				break;
			}
		}
		return ans;
	}
	
	/*
	 * Given an array of ints, return the number of 9's in the array.  
	 * that a substring length 2 appears in the string 
	 * and also as the last 2 chars of the string,
	 * so "hixxxhi" yields 1 (we won't count the end substring). 
	 * 
	 *arrayCount9(new int[]{1, 2, 9}) → 1
	 *arrayCount9(new int[]{1, 9, 9}) → 2
	 *arrayCount9(new int[]{1, 9, 9, 3, 9}) → 3
	 * 
	 */
	public int arrayCount9(int[] nums) {
		int count=0;
		for(int i=0; i<nums.length;i++){
			if(nums[i]==9) count++;
		}
		return count;
	}
	
	/*
	 * Given a string, return the count of the number of times 
	 * that a substring length 2 appears in the string 
	 * and also as the last 2 chars of the string,
	 * so "hixxxhi" yields 1 (we won't count the end substring). 
	 * 
	 * last2("hixxhi") → 1
	 * last2("xaxxaxaxx") → 1
	 * last2("axxxaaxx") → 2
	 * last2("h") → 0
	 * last2("") → 0
	 * 
	 */
	public int last2(String str) {
		int total=0;
		if(str.length()<2) return total;
		
		String last2 = str.substring(str.length()-2,str.length());
		for(int i=0;i<str.length();i++){
			if(i<str.length()-2){
				if(str.substring(i, i+2).equals(last2)){
					total++;
				}
			}else{
				break;
			}
			
		}
		return total;
	}
	/*
	 * Given a non-empty string like "Code" return a string 
	 * like "CCoCodCode".
	 * 
	 * stringSplosion("Code") → "CCoCodCode"
	 * stringSplosion("abc") → "aababc"
	 * stringSplosion("ab") → "aab"
	 * 
	 */
	public String stringSplosion(String str) {
		String newString = "";
		for(int i=0;i<str.length();i++){
			newString += str.substring(0,i+1);
		}
		return newString;
	}
	
	/*
	 * Given a string, 
	 * return a new string made of 
	 * every other char starting with the first, 
	 * so "Hello" yields "Hlo". 
	 * stringBits("Hello") → "Hlo"
	 * stringBits("Hi") → "H"
	 * stringBits("Heeololeo") → "Hello"
	 */
	public String stringBits(String str) {
		String newString = "";
		for(int i=0; i<str.length();i++){
			if(i%2==0){
				newString += str.charAt(i);
			}
		}
		return newString;
		/*
		 * Solution
		 * 
		  String result = "";
		  // Note: the loop increments i by 2
		  for (int i=0; i<str.length(); i+=2) {
		    result = result + str.substring(i, i+1);
		    // Alternately could use str.charAt(i)
		  }
		  return result;
		 */
	}
	/*
	 * Given a string, return true if the first instance of "x" 
	 * in the string is immediately followed by another "x".
	 * doubleX("axxbb") → true
	 * doubleX("axaxax") → false
	 * doubleX("xxxxx") → true
	 * Hint: Use the indexOf() method to find the first "x" in the string.
	 */
	boolean doubleX(String str) {
		 int i = str.indexOf("x");
		 if (i == -1) return false; // no "x" at all

		  // Is char at i+1 also an "x"?
		  if (i+1 >= str.length()) return false; // check i+1 in bounds?
		  return str.substring(i+1, i+2).equals("x");
		  
		  // Another approach -- .startsWith() simplifies the logic
		  // String x = str.substring(i);
		  // return x.startsWith("xx");
		  
//		try{
//			int firstX = str.indexOf("x");
//			
//			if(str.substring(firstX,firstX+2).equals("xx")){
//				return true;
//			}else{
//				return false;
//			}
//			
//		}catch(Exception e){
//			return false;
//		}
		
		
	}
	/*
	 * Count the number of "xx" in the given string. 
	 * We'll say that overlapping is allowed,
	 * so "xxx" contains 2 "xx".
	 * countXX("abcxx") → 1
	 * countXX("xxx") → 2
	 * countXX("xxxx") → 3
	 */
	int countXX(String str) {
		int total = 0;
		for(int i=0; i<str.length();i++){
			if(i<str.length()-1){
				if(str.substring(i,i+2).equals("xx")) ++total;
			}else{
				break;
			}
		}
		return total;
		/*
		 * Solution
		  int count = 0;
		  for (int i = 0; i < str.length()-1; i++) {
		    if (str.substring(i, i+2).equals("xx")) count++;
		  }
		  return count;
		 */
	}
	/*
	 * Given a string and a non-negative int n,
	 * we'll say that the front of the string is the first 3 chars,
	 * or whatever is there if the string is less than length 3.
	 * Return n copies of the front;
	 * frontTimes("Chocolate", 2) → "ChoCho"
	 * frontTimes("Chocolate", 3) → "ChoChoCho"
	 * frontTimes("Abc", 3) → "AbcAbcAbc"
	 */
	public String frontTimes(String str, int n) {
		String ans = "";
		String front = "";
		if(str.length()<3){
			front = str;
		}else{
			front = str.substring(0,3);
		}
		for(int i=0; i < n; i++){
			ans += front;
		}
		return ans;
	}
	/*
	 * Given a string and a non-negative int n, 
	 * return a larger string that is n copies of the original string. 
	 * stringTimes("Hi", 2) → "HiHi"
	 * stringTimes("Hi", 3) → "HiHiHi"
	 * stringTimes("Hi", 1) → "Hi"
	 */
	public String stringTimes(String str, int n) {
		String ans = "";
		for(int i=0; i<n;i++){
			ans += str;
		}
		return ans;
	}
	private void s(Object o){
		System.out.println((String)o.toString());
	}
}
