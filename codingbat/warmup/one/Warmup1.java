package codingbat.warmup.one;

public class Warmup1 {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Warmup1 w = new Warmup1();
		w.s("======Output=======");
		w.s(w.everyNth("Miracle", 2));
		w.s(w.everyNth("abcdefg", 2));
		w.s(w.everyNth("Chocolate", 3));
		w.s("======End=======");
	}
	/*
	 * Given a non-empty string and an int N, 
	 * return the string made starting with char 0, 
	 * and then every Nth char of the string. So if N is 3, 
	 * use char 0, 3, 6, ... and so on. N is 1 or more. 
	 * 
	 * everyNth("Miracle", 2) → "Mrce"
	 * everyNth("abcdefg", 2) → "aceg"
	 * everyNth("abcdefg", 3) → "adg"
	 * everyNth("Chocolate", 3) → "Cca"
	 */
	public String everyNth(String str, int n) {
		String answer = "";
		for(int i=0; i<str.length(); i++){
			//s(n*i);
			if((n*i) < str.length()){
				answer += str.charAt(n*i);
			}
		}
		return answer;
	}
	/*
	 * Given a string, return a new string where the last 3 chars are now in upper case.
	 * If the string has less than 3 chars, uppercase whatever is there. 
	 * Note that str.toUpperCase() returns the uppercase version of a string. 
	 * endUp("Hello") → "HeLLO"
	 * endUp("hi there") → "hi thERE"
	 * endUp("hi") → "HI"
	 */
	public String endUp(String str) {
		if(str.length()<3){
			return str.toUpperCase();
		}else{
			return str.substring(0,str.length()-3) + str.substring(str.length()-3, str.length()).toUpperCase();
		}
		/*
		 * Solution
		  if (str.length() <= 3) return str.toUpperCase();
		  int cut = str.length() - 3;
		  String front = str.substring(0, cut);
		  String back  = str.substring(cut);  // this takes from cut to the end
		  
		  return front + back.toUpperCase();
		 */
	}
	/*
	 * Given two non-negative int values,
	 * return true if they have the same last digit, such as with 27 and 57. 
	 * Note that the % "mod" operator computes remainders, so 17 % 10 is 7. 
	 * 
	 * lastDigit(7, 17) → true
	 * lastDigit(6, 17) → false
	 * lastDigit(3, 113) → true
	 * 
	 */
	public boolean lastDigit(int a, int b) {
		return(a % 10 == b % 10);
	}
	
	/*
	 * Return true if the given string contains between 1 and 3 'e' chars. 
	 * stringE("Hello") → true
	 * stringE("Heelle") → true
	 * stringE("Heelele") → false
	 */
	public boolean stringE(String str) {
		int countE = 0;
		for(int i=0; i<str.length();i++){
			if(str.substring(i,i+1).equals("e")) countE += 1;
		}
		return (countE>=1 && countE <=3);
	}
	
	/*
	 * Given 2 positive int values, 
	 * return the larger value that is in the range 10..20 inclusive,
	 * or return 0 if neither is in that range. 
	 * max1020(11, 19) → 19
	 * max1020(19, 11) → 19
	 * max1020(11, 9) → 11
	 * max1020(10, 21) → 10
	 * max1020(21, 10) → 10
	 * max1020(23, 10) → 10
	 */
	public int max1020(int a, int b) {
		Boolean boolA = (a>=10 && a<= 20);
		Boolean boolB = (b>=10 && b<= 20);
		if(boolA && boolB){
			return Math.max(a, b);
		}else{
			if(boolA) return a;
			else if(boolB) return b;
			return 0;
		}
		
		/*
		 * Solution
		 // First make it so the bigger value is in a
		  if (b > a) {
		    int temp = a;
		    a = b;
		    b = temp;
		  }
		  
		  // Knowing a is bigger, just check a first
		  if (a >= 10 && a <= 20) return a;
		  if (b >= 10 && b <= 20) return b;
		  return 0;
		 */
	}
	
	/*
	 * Given 2 int values, return true if they are both in the range 30..40 inclusive,
	 * or they are both in the range 40..50 inclusive. 
	 * in3050(30, 31) → true
	 * in3050(30, 41) → false
	 * in3050(40, 50) → true
	 */
	public boolean in3050(int a, int b) {
		return ((a>=30 && a <= 40) && (b>=30 && b <= 40)) ||
				((a>=40 && a <= 50) && (b>=40 && b <= 50));
	}
	
	/*
	 * Given 2 int values, return whichever value is nearest to the value 10,
	 * or return 0 in the event of a tie. 
	 * Note that Math.abs(n) returns the absolute value of a number. 
	 * 
	 * close10(8, 13) → 8
	 * close10(13, 8) → 8
	 * close10(13, 7) → 0
	 */
	public int close10(int a, int b) {
		int diffA = Math.abs(10 - a);
		int diffB = Math.abs(10 - b);
		
		if(diffA == diffB) return 0;
		if(diffA<diffB) return a;
		else return b;
		
		/*
		 * Solution
		 *  
		 	  int aDiff = Math.abs(a - 10);
			  int bDiff = Math.abs(b - 10);
			  
			  if (aDiff < bDiff) {
			    return a;
			  }
			  if (bDiff < aDiff) {
			    return b;
			  }
			  return 0;  // i.e. aDiff == bDiff
			  
			  // Solution notes: aDiff/bDiff local vars clean the code up a bit.
			  // Could have "else" before the second if and the return 0.
		 */
	}
	/*
	 * Given three int values, a b c, return the largest. 
	 * 
	 * intMax(1, 2, 3) → 3
	 * intMax(1, 3, 2) → 3
	 * intMax(3, 2, 1) → 3
	 */
	public int intMax(int a, int b, int c) {
		int[] nums = new int[]{b,c};
		int max = a;
		for(int i=0; i<2;i++){
			max = Math.max(max, nums[i]);
		}
		return max;
		
		/*
		 * int max;
  
  		// First check between a and b
		  if (a > b) {
		    max = a;
		  } else {
		    max = b;
		  }
		  
		  // Now check between max and c
		  if (c > max) {
		    max = c;
		  }
		  
		  return max;
		  
		  // Could use the built in Math.max(x, y) function which selects the larger
		  // of two values.
		 */
	}
	/*
	 * Given a string, return a string made of the first 2 chars (if present), 
	 * however include first char only if it is 'o' and include the second only 
	 * if it is 'z', so "ozymandias" yields "oz". 
	 * startOz("ozymandias") → "oz"
	 * startOz("bzoo") → "z"
	 * startOz("oxx") → "o"
	 */
	public String startOz(String str) {
		String result = "";
		if(str.length()==0) return result;
		if(str.length()>=1) {
			String first = str.substring(0,1);
			if(first.equals("o")) result += first; 
		}
		if(str.length()>=2){
			String second = str.substring(1,2);
			if(second.equals("z")) result += second;
		}
		return result;
		/*
		 * 
		 *
		  String result = "";
		  
		  if (str.length() >= 1 && str.charAt(0)=='o') {
		    result = result + str.charAt(0);
		  }
		  
		  if (str.length() >= 2 && str.charAt(1)=='z') {
		    result = result + str.charAt(1);
		  }
		  
		  return result;
		 */
	}
	/*
	 * Return true 
	 * if the given string begins with "mix", 
	 * except the 'm' can be anything, so "pix", "9ix" .. all count
	 * mixStart("mix snacks") → true
	 * mixStart("pix snacks") → true
	 * mixStart("piz snacks") → false
	 */
	public boolean mixStart(String str) {
		if(str.length()<3) return false;
		String startThree = str.substring(0, 3);
		if(startThree.substring(1, 3).equals("ix")) return true;
		else return false;
	}
	/*
	 * 
	   Given a string, if the string "del" appears starting at index 1
	   , return a string where that "del" has been 
	   deleted. Otherwise, return the string unchanged. 
	   delDel("adelbc") → "abc"
	   delDel("adelHello") → "aHello"
	   delDel("adedbc") → "adedbc"
	   delDel("abcdel") → "abcdel"
	   delDel("del") → "del"
	   delDel("aadelbb") → "aadelbb"	
	 */
	public String delDel(String str) {
		
		if(str.length()>=4 && str.substring(1,4).equals("del")) return str.replace("del", "");
		else return str;
		/*
		 *  if (str.length()>=4 && str.substring(1, 4).equals("del")) {
		    // First char + rest of string starting at 4
		    	return str.substring(0, 1) + str.substring(4);
		  	}
		  		// Otherwise return the original string.
		  		return str;
			}
		 */
		
	}
	/*
	 * We'll say that a number is "teen" if it is in the range 13..19 inclusive. 
	 * Given 2 int values, return true if 
	 * one or the other is teen, but not both. 
	 * loneTeen(13, 99) → true
	 * loneTeen(21, 19) → true
	 * loneTeen(13, 13) → false
	 */
	public boolean loneTeen(int a, int b) {
		Boolean boolA = (a>=13 && a <=19);
		return ((b>=13 && b <=19) == !boolA);
		
		// Store teen-ness in boolean local vars first. Boolean local
		// vars like this are a little rare, but here they work great.
		/*
		 boolean aTeen = (a >= 13 && a <= 19);
		
		  boolean bTeen = (b >= 13 && b <= 19);
		  
		  return (aTeen && !bTeen) || (!aTeen && bTeen);
		 */
		// Translation: one or the other, but not both.
		// Alternately could use the Java xor operator, but it's obscure.
	}
	/*
	 * We'll say that a number is "teen" 
	 * if it is in the range 13..19 inclusive. 
	 * Given 3 int values, 
	 * return true if 1 or more of them are teen. 
	 * hasTeen(13, 20, 10) → true
		hasTeen(20, 19, 10) → true
		hasTeen(20, 10, 13) → true
	 */
	public boolean hasTeen(int a, int b, int c) {
		// Here it is written as one big expression,
		 // vs. a series of if-statements.
		return (a>=13 && a <=19) || (b>=13 && b <=19) || (c>=13 && c<=19);
	}
	/*
	 * Given 2 int values, return true if either of them is in the range 10..20 inclusive. 
		in1020(12, 99) → true
		in1020(21, 12) → true
		in1020(8, 99) → false
	 */
	public boolean in1020(int a, int b) {
		return (a>=10 && a <=20) ||  (b>=10 && b <=20);
	}
	/*
	 * Given two temperatures, 
	 * return true if one is less than 0 and the other is greater than 100. 
	 * 	icyHot(120, -1) → true
		icyHot(-1, 120) → true
		icyHot(2, 120) → false
	 */
	public boolean icyHot(int temp1, int temp2) {
		if((temp1 < 0 && temp2 > 100) || (temp1 > 100 && temp2 < 0)){
			return true;
		}else{
			return false;
		}
		
	}
	/*
	 * Given a string, return true if the string starts with "hi" and false otherwise. 
	 * startHi("hi there") → true
	 * startHi("hi") → true
	 * startHi("hello hi") → false
	 */
	public boolean startHi(String str) {
		//s(str.substring(0,2));
		if(str.length()<2){
			return false;
		}else{
			return str.substring(0,2).equals("hi");
		}
		/*
		 * 
		 *  // First test if the string is not at least length 2
			  // (so the substring() below does not go past the end).
			  if (str.length() < 2) return false;
			  
			  // Pull out the string of the first two chars
			  String firstTwo = str.substring(0, 2);
			  
			  // Test if it is equal to "hi"
			  if (firstTwo.equals("hi")) {
			    return true;
			  } else {
			    return false;
			  }
			  // This last part can be shortened to: return(firstTwo.equals("hi"));
		 * 
		 * 
		 */
		
	}
	/*
	 * Given a string, 
	 * take the first 2 chars and return the string with the 2 chars 
	 * added at both the front and back, so "kitten" yields"kikittenki". 
	 * If the string length is less than 2, use whatever chars are there.
	 * 	front22("kitten") → "kikittenki"
		front22("Ha") → "HaHaHa"
		front22("abc") → "ababcab"
	 */
	public String front22(String str) {
		if(str.length()>=2){
			String front2 = str.substring(0,2);
			return front2 + str + front2;
		}else{
			return str+str+str;
		}
		// First figure the number of chars to take
		/*
		  int take = 2;
		  if (take > str.length()) {
		    take = str.length();
		  }
		  
		  String front = str.substring(0, take);
		  return front + str + front;
		  */
	}
	/*
	 * Return true 
	 * if the given non-negative number is a multiple of 3 or a multiple of 5. 
	 * Use the % "mod" operator
	 */
	public boolean or35(int n) {
		//if(n%3==0 || n%5==0) return true;
		//else return false;
		return (n % 3 == 0) || (n % 5 == 0);
	}
	public String backAround(String str){
		String back = str.substring(str.length()-1);
		return back+str+back;
	}
	public String frontBack(String str) {
		if(str.length()<=1) return str;
		if(str.length()>2){
			String front = str.substring(0,1);
			String middle = str.substring(1,str.length()-1);
			String end = str.substring(str.length()-1,str.length());
			return end + middle + front;
		}else{
			return str.substring(str.length()-1,str.length())+str.substring(0,1);
		}
	}
	
	public String front3(String str){
		String f3 = "";
		if(str.length() >=3){
			f3 = str.substring(0,3);
		}else{
			f3 = str;
		}
		return f3+f3+f3;
	}
	
	public String missingChar(String str, int n) {
		String newString = ""; 
		for (int i=0; i<str.length(); i++) {
			if(i!=n){
				newString += str.substring(i,i+1);
			}
			//System.out.println(str.substring(i,i+1));
		}
		return newString;
	}
	
	private void s(Object o){
		System.out.println((String)o.toString());
	}
	
	
	//	Given 2 int values, return true if one is negative and one is positive. 
	//	Except if the parameter "negative" is true, then return true only if both are negative. 
	//	
	//	posNeg(1, -1, false) → true
	//	posNeg(-1, 1, false) → true
	//	posNeg(-4, -5, true) → true
	public boolean posNeg(int a, int b, boolean negative) {
		 if (negative) {
			 return (a < 0 && b < 0);
		 }else {
			 return ((a < 0 && b > 0) || (a > 0 && b < 0));
		 }
	}

}
