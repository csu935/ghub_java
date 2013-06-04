package codingbat.fizz.buzz;
//import lib.DeOut;
public class ExecFizzBuzz {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//
		ExecFizzBuzz f = new ExecFizzBuzz();
		
		f.show("--------output---------");
		f.show(f.fizzBuzz(1, 6));
		//f.show(f.fizzBuzz(1, 8));
		//f.show(f.fizzBuzz(1, 11));
		f.show("------end output-------");
	}
	/*
	 * This is slightly more difficult version of the famous FizzBuzz problem 
	 * which is sometimes given as a first problem for job interviews. 
	 * (See also: FizzBuzz Code.) 
	 * Consider the series of numbers beginning at start and running up to 
	 * but not including end, 
	 * so for example start=1 and end=5 gives the series 1, 2, 3, 4. 
	 * Return a new String[] array containing the string form of these numbers, 
	 * except for multiples of 3, use "Fizz" instead of the number, 
	 * for multiples of 5 use "Buzz", and for multiples of both 3 and 5 use "FizzBuzz". 
	 * In Java, String.valueOf(xxx) will make the String form of an int or other type. 
	 * This version is a little more complicated than the usual version 
	 * since you have to allocate and index into an array instead of just printing, 
	 * and we vary the start/end instead of just always doing 1..100.
	 * 
	 * fizzBuzz(1, 6) → {"1", "2", "Fizz", "4", "Buzz"}
	 * fizzBuzz(1, 8) → {"1", "2", "Fizz", "4", "Buzz", "Fizz", "7"}
	 * fizzBuzz(1, 11) → {"1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz"}
	 */
	public String[] fizzBuzz(int start, int end) {
		int len = end - start;
		String[] arry = new String[len];
		if(len <= 0) return arry;
		for(int i=1; i<len+1;i++){
			int tmp = i+start-1;
			int fizz = tmp % 3;
			int buzz = tmp % 5;
			String s = "";
			if(fizz==0){
				if(buzz==0) s = "FizzBuzz";
				else s = "Fizz";
			}else{
				if(buzz==0) s = "Buzz";
				else s = String.valueOf(tmp);
			}
			arry[i-1] = s;
		}
		return arry;
	}
	/*
	 * Given start and end numbers, 
	 * return a new array containing the sequence of integers 
	 * from start up to but not including end, 
	 * so start=5 and end=10 yields {5, 6, 7, 8, 9}. 
	 * The end number will be greater or equal to the start number. 
	 * Note that a length-0 array is valid. 
	 * 
	 * fizzArray3(5, 10) → {5, 6, 7, 8, 9}
	 * fizzArray3(11, 18) → {11, 12, 13, 14, 15, 16, 17}
	 * fizzArray3(1, 3) → {1, 2}
	 */
	public int[] fizzArray3(int start, int end) {
		int len = end-start;
		int[] arry = new int[len];
		if(len==0) return arry;
		for(int i=0;i<len;i++){
			arry[i] = start + i;
		}
		return arry;
	}
	/*
	 * Given a number n, 
	 * create and return a new string array of length n, 
	 * containing the strings "0", "1" "2" .. through n-1. 
	 * N may be 0, in which case just return a length 0 array. 
	 * Note: String.valueOf(xxx) will make the String form of most types.
	 *  The syntax to make a new string array is: new String[desired_length] 
	 * fizzArray2(4) → {"0", "1", "2", "3"}
	 * fizzArray2(10) → {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}
	 * fizzArray2(2) → {"0", "1"}
	 */
	public String[] fizzArray2(int n) {
		String[] result = new String[n];
		if(n==0) return result;
		for(int i=0;i<n;i++){
			result[i] = String.valueOf(i);
		}
		return result;
	}
	/*
	 * Given a number n, create and return a new int array of length n, 
	 * containing the numbers 0, 1, 2, ... n-1. 
	 * The given n may be 0, in which case just return a length 0 array. 
	 * You do not need a separate if-statement for the length-0 case; 
	 * the for-loop should naturally execute 0 times in that case, 
	 * so it just works. 
	 * The syntax to make a new int array is: new int[desired_length] 
	 * 
	 * fizzArray(4) → {0, 1, 2, 3}
	 * fizzArray(1) → {0}
	 * fizzArray(10) → {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
	 */
	public int[] fizzArray(int n) {
		int[] array = new int[n];
		for(int i=0;i<n;i++){
			array[i]=i;
		}
		return array;
	}
	/*
	 * Given an int n, 
	 * return the string form of the number followed by "!". 
	 * So the int 6 yields "6!". 
	 * Except if the number is divisible by 3 use "Fizz" instead of the number, 
	 * and if the number is divisible by 5 use "Buzz", 
	 * and if divisible by both 3 and 5, use "FizzBuzz". 
	 * Note: the % "mod" operator computes the remainder after division, 
	 * so 23 % 10 yields 3. 
	 * What will the remainder be when one number divides evenly into another? 
	 * (See also: FizzBuzz Code and Introduction to Mod) 
	 * 
	 * fizzString2(1) → "1!"
	 * fizzString2(2) → "2!"
	 * fizzString2(3) → "Fizz!"
	 */
	public String fizzString2(int n) {
		int fizz = n % 3;
		int buzz = n % 5;
		if(fizz==0 && buzz==0) return "FizzBuzz!";
		if(fizz==0) return "Fizz!";
		if(buzz==0) return "Buzz!";
		return n + "!";
	}
	/*
	 * Given a string str, if the string starts with "f" return "Fizz". 
	 * If the string ends with "b" return "Buzz". 
	 * If both the "f" and "b" conditions are true, return "FizzBuzz". 
	 * In all other cases, return the string unchanged.
	 * 
	 * fizzString("fig") → "Fizz"
	 * fizzString("dib") → "Buzz"
	 * fizzString("fib") → "FizzBuzz"
	 */
	public String fizzString(String str) {
		String head = str.substring(0,1);
		String tail = str.substring(str.length()-1,str.length());
		if(head.equals("f")){
			if(tail.equals("b")) return "FizzBuzz";
			else return "Fizz";
		}else{
			if(tail.equals("b")) return "Buzz";
			else return str;
		}
		/*
		 * Solution
		  boolean f = str.startsWith("f");
		  boolean b = str.endsWith("b");
		  
		  if (f && b) return "FizzBuzz";
		  if (f) return "Fizz";
		  if (b) return "Buzz";
		  return str;
		 */
	}
	
	private void show(Object o){
		System.out.println((String)o.toString());
	}

}
