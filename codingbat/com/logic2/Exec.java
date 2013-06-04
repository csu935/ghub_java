package codingbat.com.logic2;

import lib.DeOut;

public class Exec {

	public static void main(String[] args) {
		Exec my = new Exec();
		
		DeOut.disp("--------output---------");
		DeOut.disp(my.evenlySpaced(2, 4, 6));
		DeOut.disp(my.evenlySpaced(4, 6, 2));
		DeOut.disp(my.evenlySpaced(4, 6, 3));
		DeOut.disp("------end output-------");
	}
	/*
	 * We want make a package of goal kilos of chocolate. 
	 * We have small bars (1 kilo each) and big bars (5 kilos each). 
	 * Return the number of small bars to use, 
	 * assuming we always use big bars before small bars. 
	 * Return -1 if it can't be done. 
	 * 
	 * makeChocolate(4, 1, 9) → 4
	 * makeChocolate(4, 1, 10) → -1
	 * makeChocolate(4, 1, 7) → 2
	 */
	public int makeChocolate(int small, int big, int goal) {
		int needBig = Math.min(big, goal/5);
		int needSmall = goal-needBig*5;
		if(small>=needSmall&&big>=needBig) return needSmall;
		else return -1;
	}
	/*
	 * Given three ints, a b c, one of them is small, 
	 * one is medium and one is large. 
	 * Return true if the three values are evenly spaced, 
	 * so the difference between small 
	 * and medium is the same as the difference between medium and large. 
	 * 
	 * evenlySpaced(2, 4, 6) → true
	 * evenlySpaced(4, 6, 2) → true
	 * evenlySpaced(4, 6, 3) → false
	 * 
	 * evenlySpaced(6, 2, 8) → false
	 * evenlySpaced(2, 4, 4) → false
	 * evenlySpaced(2, 2, 4) → false
	 */
	public boolean evenlySpaced(int a, int b, int c) {
		int large = Math.max(Math.max(a,b),c);
		int small = Math.min(Math.min(a,b),c);
		int middle;
		if(a>small&&a<large) middle=a;
		else if(b>small&&b<large) middle=b;
		else middle=c;
		if((middle-small) == (large-middle)) return true;
		return false;
	}
	/*
	 * Given 2 int values greater than 0, 
	 * return whichever value is nearest to 21 without going over. 
	 * Return 0 if they both go over. 
	 * 
	 * blackjack(19, 21) → 21
	 * blackjack(21, 19) → 21
	 * blackjack(19, 22) → 19
	 */
	public int blackjack(int a, int b) {
		if(a>21 && b>21){
			return 0;
		}else if(a>21 && b<=21){
			return b;
		}else if(b>21 && a<=21){
			return a;
		}else{
			return Math.max(a, b);
		}
		
		/*
		 * Solution:
		  // The value of a/b, or 0 if over 21
		  int aVal = a;
		  if (aVal > 21) {
		    aVal = 0;
		  }
		  int bVal = b;
		  if (bVal > 21) {
		    bVal = 0;
		  }
		  
		  // Now it works to just return whichever is larger.
		  if (aVal > bVal) {
		    return aVal;
		  }
		  else {
		    return bVal;
		  }
		  
		  // You can write a very short version of this same strategy
		  // using the "ternary operator" ?: and Math.max()
		 */
	}
	/*
	 * Given three ints, a b c, return true if one of b or c is "close" 
	 * (differing from a by at most 1), while the other is "far", 
	 * differing from both other values by 2 or more. 
	 * Note: Math.abs(num) computes the absolute value of a number. 
	 * 
	 * closeFar(1, 2, 10) → true
	 * closeFar(1, 2, 3) → false
	 * closeFar(4, 1, 3) → true
	 */
	public boolean closeFar(int a, int b, int c) {
		if((Math.abs(a-b)<=1 && (Math.abs(b-c)>=2 && Math.abs(a-c)>=2))||
				(Math.abs(a-c)<=1&&(Math.abs(a-b)>=2 && Math.abs(b-c)>=2))){
			return true;
		}else{
			return false;
		}
	}
	/*
	 * For this problem, 
	 * we'll round an int value up to the next multiple of 10 
	 * if its rightmost digit is 5 or more, 
	 * so 15 rounds up to 20. 
	 * Alternately, round down to the previous multiple of 10 
	 * if its rightmost digit is less than 5, so 12 rounds down to 10. 
	 * Given 3 ints, a b c, return the sum of their rounded values. 
	 * To avoid code repetition, write a separate helper 
	 * "public int round10(int num) {
	 * " and call it 3 times. Write the helper entirely below 
	 * and at the same indent level as roundSum(). 
	 * 
	 * roundSum(16, 17, 18) → 60
	 * roundSum(12, 13, 14) → 30
	 * roundSum(6, 4, 4) → 10
	 */
	public int roundSum(int a, int b, int c) {
		return round10(a)+round10(b)+round10(c);
	}
	
	/*
	 * call it 3 times. Write the helper entirely below 
	 * and at the same indent level as roundSum().
	 */
	public int round10(int num) {
		int rightmost = num%10;
		if(rightmost>=5) return num + 10-rightmost;
		else return num -rightmost;
		
		/*
		 * Solution
		  int remainder = num % 10;
		  num -= remainder;
		  if (remainder >= 5) {
		    num += 10;
		  }
		  return num;
		 */
		
	}
	/*
	 * Given 3 int values, a b c, return their sum. 
	 * However, if any of the values is a teen -- in the range 13..19 inclusive -- 
	 * then that value counts as 0, except 15 and 16 do not count as a teens. 
	 * Write a separate helper 
	 * "public int fixTeen(int n) {
	 * "that takes in an int value and returns that value fixed for the teen rule. 
	 * In this way, you avoid repeating the teen code 3 times 
	 * (i.e. "decomposition"). 
	 * Define the helper below and at the same indent level as the main noTeenSum(). 
	 * 
	 * noTeenSum(1, 2, 3) → 6
	 * noTeenSum(2, 13, 1) → 3
	 * noTeenSum(2, 1, 14) → 3
	 */
	public int noTeenSum(int a, int b, int c) {
		return fixTeen(a)+fixTeen(b)+fixTeen(c);
	}
	/*
	 * "that takes in an int value and returns that value fixed for the teen rule. 
	 * In this way, you avoid repeating the teen code 3 times (i.e. "decomposition").
	 */
	public int fixTeen(int n) {
		if(n>=13 && n<=19){
			if(n==15||n==16) return n;
			return 0;
		}else{
			return n;
		}
	}
	
	/*
	 * Given 3 int values, a b c, return their sum. 
	 * However, if one of the values is 13 then it does not count 
	 * towards the sum and values to its right do not count. 
	 * So for example, if b is 13, then both b and c do not count. 
	 * 
	 * luckySum(1, 2, 3) → 6
	 * luckySum(1, 2, 13) → 3
	 * luckySum(1, 13, 3) → 1
	 */
	public int luckySum(int a, int b, int c) {
		int sum =0;
		if(a==13) return sum;
		else sum += a;
		if(b==13) return sum;
		else sum += b;
		if(c==13) return sum;
		else sum += c;
		
		return sum;
	}
	/*
	 * Given 3 int values, a b c, return their sum. However, 
	 * if one of the values is the same as another of the values, 
	 * it does not count towards the sum. 
	 * 
	 * loneSum(1, 2, 3) → 6
	 * loneSum(3, 2, 3) → 2
	 * loneSum(3, 3, 3) → 0
	 */
	public int loneSum(int a, int b, int c) {
		int sum = 0;
		if(a!=b&&b!=c&&a!=c) return a+b+c;
		if(a!=b&&b==c) return a; 
		else if(a==b&&a!=c) return c;
		else if(a==c&&a!=b) return b;
		return sum;
		/*
		 * Solution
		  int sum = 0;
		  if (a != b && a != c) {
		    sum += a;
		  }
		  if (b != a && b != c) {
		    sum += b;
		  }
		  if (c != a && c != b) {
		    sum += c;
		  }
		  return sum;
		  
		  // Solution notes: this code is a pretty direct translation
		  // of the problem statement.
		  // For each of a/b/c, check that it is different from
		  // the other two before adding it to the sum variable
		 */
	}
	/*
	 * We want to make a row of bricks that is goal inches long. 
	 * We have a number of small bricks (1 inch each) and big bricks (5 inches each). 
	 * Return true if it is possible to make the goal 
	 * by choosing from the given bricks. 
	 * This is a little harder than it looks and can be done without any loops. 
	 * See also: Introduction to MakeBricks 
	 * 
	 * makeBricks(3, 1, 8) → true
	 * makeBricks(3, 1, 9) → false
	 * makeBricks(3, 2, 10) → true
	 * 
	 * makeBricks(6, 1, 11) → true
	 * makeBricks(7, 1, 11) → true
	 * makeBricks(43, 1, 46) → true
	 * makeBricks(40, 2, 47) → true
	 * makeBricks(40, 2, 50) → true
	 * makeBricks(1000000, 1000, 1000100) → true
	 * makeBricks(20, 0, 19) → true
	 * makeBricks(20, 4, 39) → true
	 */
	public boolean makeBricks(int small, int big, int goal) {
		int needBig = Math.min(big,goal/5);
		int needSmall = goal - 5*needBig;
		return small>=needSmall && big>=needBig;
	}
}
