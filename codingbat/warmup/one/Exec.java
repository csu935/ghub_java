package codingbat.warmup.one;

public class Exec {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 2
		System.out.println(diff21(19));
		// 11
		System.out.println(diff21(10));
		// 21
		System.out.println(diff21(0));
		// 23
		System.out.println(diff21(-2));
		// 2
		System.out.println(diff21(22));
		// 8
		System.out.println(diff21(25));
		// 18
		System.out.println(diff21(30));
		// 58
		System.out.println(diff21(50));
		
	}
	
	public static int diff21(int n){
		if (n <= 21) {
		    return 21 - n;
		  } else {
		    return (n - 21) * 2;
		  }
	}

}
