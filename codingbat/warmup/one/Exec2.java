package codingbat.warmup.one;

public class Exec2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		// true
		System.out.println(parrotTrouble(true, 6));
		// false
		System.out.println(parrotTrouble(true, 7));
		// false
		System.out.println(parrotTrouble(false, 6));
	}
	
	/*
	 * We have a loud talking parrot. 
	 * The "hour" parameter is the current hour time in the range 0..23. 
	 * We are in trouble if the parrot is talking and the hour is before 7 or after 20. 
	 * Return true if we are in trouble.
	 */
	public static boolean parrotTrouble(boolean talking, int hour) {
		if(talking){
			if(hour < 7 || hour > 20) return true;
			else return false;
		}else{
			return false;
		}
		  
	}

}
