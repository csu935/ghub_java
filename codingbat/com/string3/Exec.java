package codingbat.com.string3;

import lib.DeOut;

public class Exec {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Exec my = new Exec();
	}
	/*
	 * Given a string, return the longest substring 
	 * that appears at both the beginning and end of 
	 * the string without overlapping. For example, 
	 * sameEnds("abXab") is "ab". 
	 * 
	 * sameEnds("abXYab") → "ab"
	 * sameEnds("xx") → "x"
	 * sameEnds("xxx") → "x"
	 */
	public String sameEnds(String string) {
		int limit = string.length()%2==0? string.length()/2:string.length()/2+1;
		String front = string.substring(0,string.length()/2);
		String tail = string.substring(limit);
		
		if(tail.equals(front)){
			return front;
		}else{
			int i = 1;
			while(i<string.length()/2){
				
				if(tail.substring(i).equals(front.substring(0, front.length()-i))){
					return tail.substring(i);
				}
				i++;
			}
		}
		
		return "";
	}
	/*
	 * Given a string, return the sum of the digits 0-9 
	 * that appear in the string, ignoring all other characters. 
	 * Return 0 if there are no digits in the string. 
	 * (Note: Character.isDigit(char) tests 
	 * if a char is one of the chars '0', '1', .. '9'. 
	 * Integer.parseInt(string) converts a string to an int.) 
	 * 
	 * sumDigits("aa1bc2d3") → 6
	 * sumDigits("aa11b33") → 8
	 * sumDigits("Chocolate") → 0
	 */
	public int sumDigits(String str) {
		int sum =0;
		for(int i=0;i<str.length();i++){
			//DeOut.disp(str.charAt(i)+" => "+ Character.isDigit(str.charAt(i)));
			if(Character.isDigit(str.charAt(i))){
				sum += Integer.parseInt(Character.toString(str.charAt(i)));
			}
		}
		return sum;
	}
	/*
	 * We'll say that a "triple" in a string is a char appearing three times in a row. 
	 * Return the number of triples in the given string. 
	 * The triples may overlap. 
	 * 
	 * countTriple("abcXXXabc") → 1
	 * countTriple("xxxabyyyycd") → 3
	 * countTriple("a") → 0
	 */
	public int countTriple(String str) {
		int count = 0;
		for(int i=0;i<str.length()-2;i++){
			if(str.charAt(i)==str.charAt(i+1)&&str.charAt(i)==str.charAt(i+2)){
				count++;
			}
		}
		return count;
	}
	/*
	 * We'll say that a "triple" in a string is a char appearing three times in a row. 
	 * Return the number of triples in the given string. 
	 * The triples may overlap. 
	 * 
	 * countTriple("abcXXXabc") → 1
	 * countTriple("xxxabyyyycd") → 3
	 * countTriple("a") → 0
	 */
	public int countTriple(String str) {
		int count = 0;
		for(int i=0;i<str.length()-2;i++){
			if(str.charAt(i)==str.charAt(i+1)&&str.charAt(i)==str.charAt(i+2)){
				count++;
			}
		}
		return count;
	}
	/*
	 * We'll say that a lowercase 'g' in a string is "happy" 
	 * if there is another 'g' immediately to its left or right. 
	 * Return true if all the g's in the given string are happy. 
	 * 
	 * gHappy("xxggxx") → true
	 * gHappy("xxgxx") → false
	 * gHappy("xxggyygxx") → false
	 * 
	 * gHappy("g") → false
	 * gHappy("") → true
	 * gHappy("xxgggxyz") → true
	 * gHappy("yyygggxyy") → true
	 */
	public boolean gHappy(String str) {
		
		if(str.length()==0) return true;
		if(str.length()==1) return false;
		boolean happy = false;
		int i = 0;
		while(i<str.length()){
			if(str.substring(i,i+1).equals("g")){
				if(i==0){
					happy=str.substring(i+1,i+2).equals("g");
				}else if(i==str.length()-1){
					happy=str.substring(i-1,i).equals("g");
				}else{
					happy=str.substring(i-1,i).equals("g") || str.substring(i+1,i+2).equals("g");
				}
			}
			i++;
		}
		return happy;
	}
	/*
	 * Given a string, return true if the number of appearances 
	 * of "is" anywhere in the string is equal to the number 
	 * of appearances of "not" anywhere in the string (case sensitive). 
	 * 
	 * equalIsNot("This is not") → false
	 * equalIsNot("This is notnot") → true
	 * equalIsNot("noisxxnotyynotxisi") → true
	 */
	public boolean equalIsNot(String str) {
		int isCnt = 0;
		int notCnt = 0;
		for(int i=0;i<str.length();i++){
			if(i<str.length()-1&&str.substring(i, i+2).equals("is")){
				isCnt++;
			}
			if(i<str.length()-2&&str.substring(i,i+3).equals("not")){
				notCnt++;
			}
		}
		return isCnt==notCnt;
	}
	/*
	 * Given two strings, base and remove, 
	 * return a version of the base string 
	 * where all instances of the remove string have been removed (not case sensitive). 
	 * You may assume that the remove string is length 1 or more. 
	 * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x". 
	 * 
	 * withoutString("Hello there", "llo") → "He there"
	 * withoutString("Hello there", "e") → "Hllo thr"
	 * withoutString("Hello there", "x") → "Hello there"
	 * 
	 */
	public String withoutString(String base, String remove) {
		String answer = "";
		int checkMax = base.length()-remove.length()+1;
		for(int i=0;i<base.length();i++){			
			if(i<checkMax && base.toLowerCase().substring(i, i+remove.length()).equals(remove.toLowerCase())){				
				i += remove.length()-1;				
			}else{
				answer += base.substring(i, i+1);
			}
		}
		
		return answer;
	}
	/*
	 * Given a string, count the number of words ending in 'y' 
	 * or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count, 
	 * but not the 'y' in "yellow" (not case sensitive). 
	 * We'll say that a y or z is at the end of a word 
	 * if there is not an alphabetic letter immediately following it. 
	 * (Note: Character.isLetter(char) tests if a char is an alphabetic letter.) 
	 * 
	 * countYZ("fez day") → 2
	 * countYZ("day fez") → 2
	 * countYZ("day fyyyz") → 2
	 * 
	 */
	public int countYZ(String str) {

		String[] s = str.split("[^a-zA-Z]");

		int count = 0;
		for(int i=0; i<s.length; i++){
			int lastIndex = s[i].length()-1;
			if(lastIndex>=0&&Character.isLetter(s[i].charAt(lastIndex))){
				String lastStr = Character.toString(s[i].charAt(lastIndex));
				if(lastStr.toLowerCase().equals("y") || lastStr.toLowerCase().equals("z")){
					count++;
				}
			}
		}
		
		return count;
	}

}
