package codingbat.warmup.one;

public class Exec3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		// true
		//System.out.println(makes10(9, 10));
		// true
		//System.out.println(nearHundred(93));
		// true
		//System.out.println(nearHundred(90));
		// false
		//System.out.println(nearHundred(89));
		
		System.out.println(nearHundred(111)); // false
		System.out.println(nearHundred(121)); // false
		System.out.println(nearHundred(189)); // false
		System.out.println(nearHundred(211)); // false
	}
	/*
	 * Given 2 ints, a and b, return true if one if them is 10 or if their sum is 10.
	 */
	public static boolean makes10(int a, int b) {
		if(a == 10 || b == 10) return true;
		if(a + b==10) return true;
		return false;
	}
	/*
	 * Given an int n, return true if it is within 10 of 100 or 200. 
	 * Note: Math.abs(num) computes the absolute value of a number.
	 */
	public static boolean nearHundred(int n) {
		
		if(Math.abs(100-n) <= 10 || Math.abs(n-200) <= 10){
			return true;
		}else{
			return false;
		}
		  
	}

}
