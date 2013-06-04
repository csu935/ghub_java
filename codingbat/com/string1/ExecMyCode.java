package codingbat.com.string1;

import lib.DeOut;
public class ExecMyCode {

	public static void main(String[] args) {
		ExecMyCode my = new ExecMyCode();
		
		DeOut.disp("--------output---------");
		DeOut.disp(my.withoutX2("xHi"));
		DeOut.disp(my.withoutX2("Hxi"));
		DeOut.disp(my.withoutX2("Hi"));
		DeOut.disp(my.withoutX2("x"));
		DeOut.disp("------end output-------");
	}
	/*
	 * Given a string, 
	 * if one or both of the first 2 chars is 'x', 
	 * return the string without those 'x' chars, 
	 * and otherwise return the string unchanged. 
	 * This is a little harder than it looks. 
	 * 
	 * withoutX2("xHi") → "Hi"
	 * withoutX2("Hxi") → "Hi"
	 * withoutX2("Hi") → "Hi"
	 * withoutX2("x") → ""
	 */
	public String withoutX2(String str) {
		boolean del1 = false;
		boolean del2 =false;
		if (str.length() > 0 && str.charAt(0) == 'x') del1 = true;
		if (str.length() > 1 && str.charAt(1) == 'x') del2 = true;
		if(str.length() > 0 && del1 && del2){
			return str.substring(2);
		}else if(str.length() > 0 && del1){
			return str.substring(1);
		}else if(str.length() > 0 && del2){
			return str.substring(0,1)+str.substring(2);
		}else{
			return str;
		}
		
	}
	/*
	 * Given a string, if the first or last chars are 'x', 
	 * return the string without those 'x' chars, 
	 * and otherwise return the string unchanged. 
	 * 
	 * withoutX("xHix") → "Hi"
	 * withoutX("xHi") → "Hi"
	 * withoutX("Hxix") → "Hxi"
	 */
	public String withoutX(String str) {
		if(str.length()==0) return str;
		if(str.length()==1 && str.equals("x")) return "";
		else{
			if(str.substring(0,1).equals("x")) str = str.substring(1);
			if(str.substring(str.length()-1,str.length()).equals("x")){
				return str.substring(0,str.length()-1);
			}else{
				return str;
			}
		}
		
		/*
		 * Solution
		 *  	
		      if (str.length() > 0 && str.charAt(0) == 'x') {
			    str = str.substring(1);
			  }
			
			  if (str.length() > 0 && str.charAt(str.length()-1) == 'x') {
			    str = str.substring(0, str.length()-1);
			  }
			  
			  return str;
  
		  // Solution  notes: check for the 'x' in both spots. If found, use substring()
		  // to grab the part without the 'x'. Check that the length is greater than 0
		  // each time -- the need for the second length check is tricky to see.
		  // One could .substring() instead of .charAt() to look into the string.
		* 
		 */
	}
	/*
	 * Given a string and a second "word" string, 
	 * we'll say that the word matches the string 
	 * if it appears at the front of the string, 
	 * except its first char does not need to match exactly. 
	 * On a match, 
	 * return the front of the string, 
	 * or otherwise return the empty string. 
	 * So, so with the string "hippo" the word "hi" returns "hi" and "xip" 
	 * returns "hip". The word will be at least length 1. 
	 * 
	 * startWord("hippo", "hi") → "hi"
	 * startWord("hippo", "xip") → "hip"
	 * startWord("hippo", "i") → "h"
	 * 
	 *******StringIndexOutOfBoundsException*****
	 * startWord("hippo", "ix") → ""
	 * startWord("h", "ix") → ""
	 * startWord("h", "z") → "h"
	 * ************************
	 * startWord("", "i") → ""
	 * startWord("hip", "zig") → ""
	 * startWord("hippo", "xyz") → ""
	 */
	public String startWord(String str, String word) {
		if(str.length()==0 && word.length()>0) return "";
		if(str.length()==1) {
			if(word.length()==1) return str;
			return "";
		}
		int wdLen = word.length();
		if(str.substring(1,wdLen).equals(word.substring(1,wdLen))){
			return str.substring(0,1) + str.substring(1,wdLen);
		}else{
			//return str.substring(0,1);
			return "";
		}
	}
	/*
	 * Given a string, return a version without the first 2 chars. 
	 * Except 
	 * keep the first char if it is 'a' 
	 * and keep the second char if it is 'b'. 
	 * The string may be any length. Harder than it looks. 
	 * 
	 * deFront("Hello") → "llo"
	 * deFront("java") → "va"
	 * deFront("away") → "aay"
	 */
	public String deFront(String str) {
		if(str.length()==0) return str;
		if(str.length()==1) return str.substring(0,1).equals("a")? str.substring(0,1):"";
		String withoutFirst2 = str.substring(2);
		String first1 = str.substring(0,1).equals("a")? str.substring(0,1):"";
		String second1 = str.substring(1,2).equals("b")? str.substring(1,2):"";
		return first1 + second1 + withoutFirst2;
	}
	
	/*
	 * Given a string, 
	 * if a length 2 substring appears at both its beginning and end, 
	 * return a string without the substring at the beginning, 
	 * so "HelloHe" yields "lloHe". 
	 * The substring may overlap with itself, 
	 * so "Hi" yields "". Otherwise, 
	 * return the original string unchanged. 
	 * 
	 * without2("HelloHe") → "lloHe"
	 * without2("HelloHi") → "HelloHi"
	 * without2("Hi") → ""
	 */
	public String without2(String str) {
		if(str.length()<2) return str;
		String first2 = str.substring(0,2);
		String end2 = str.substring(str.length()-2, str.length());
		if(first2.equals(end2)) return str.substring(2);
		else return str;
	}
	
	/*
	 * Given a string, 
	 * return a new string made of 3 copies of 
	 * the first 2 chars of the original string. 
	 * The string may be any length. 
	 * If there are fewer than 2 chars, 
	 * use whatever is there. 
	 * 
	 * extraFront("Hello") → "HeHeHe"
	 * extraFront("ab") → "ababab"
	 * extraFront("H") → "HHH"
	 */
	public String extraFront(String str) {
		if(str.length()<2) return str+str+str;
		else return str.substring(0,2)+str.substring(0,2)+str.substring(0,2);
	}
	
	/*
	 * Given two strings, append them together 
	 * (known as "concatenation") and return the result. However, 
	 * if the strings are different lengths, 
	 * omit chars from the longer string so it is the same length 
	 * as the shorter string. 
	 * So "Hello" and "Hi" yield "loHi". 
	 * The strings may be any length. 
	 * 
	 * minCat("Hello", "Hi") → "loHi"
	 * minCat("Hello", "java") → "ellojava"
	 * minCat("java", "Hello") → "javaello"
	 */
	public String minCat(String a, String b) {
		if(a.length()==b.length()){
			return a + b;
		}else{
			if(a.length() > b.length()){
				return a.substring(a.length()-b.length(),a.length())+b;
			}else{
				return a+b.substring(b.length()-a.length(), b.length());
			}
			
		}
	}
	
	/*
	 * Given a string, 
	 * return true if the first 2 chars 
	 * in the string also appear 
	 * at the end of the string, such as with "edited".
	 * 
	 * frontAgain("edited") → true
	 * frontAgain("edit") → false
	 * frontAgain("ed") → true
	 * 
	 * frontAgain("jjj") → true
	 * frontAgain("x") → false
	 * frontAgain("") → false
	 */
	public boolean frontAgain(String str) {
		if(str.length()<=1) return false;
		if(str.length()==2) return true;
		else{
			//DeOut.disp(str.substring(str.length()-2,str.length()));
			return str.substring(0,2).equals(str.substring(str.length()-2,str.length()));
		}
		/*
		 * Solution
		 *  
		      if (str.length() < 2) {
			    return false;  // screen out the short-length case
			  }
			  
			  String front = str.substring(0, 2);
			  String back = str.substring(str.length()-2);
			  return(front.equals(back));
			  
			  // Solution notes: First screen out the length < 2 case to avoid index
			  // problems with the later code.
			  // Grab the two strings with substring() and compare them
			  // with equals(). Return the result of equals() directly -- don't need
			  // check if it's true or false. Here the two strings are stored in local
			  // variables which makes the code simpler but longer.
		 */
	}
	
	/*
	 * Given a string, 
	 * if the string begins with "red" or "blue" 
	 * return that color string, 
	 * otherwise return the empty string. 
	 * 
	 * seeColor("redxx") → "red"
	 * seeColor("xxred") → ""
	 * seeColor("blueTimes") → "blue"
	 * 
	 * seeColor("red") → "red"
	 * seeColor("blu") → ""
	 */
	public String seeColor(String str) {
		if(str.length()<3) return "";
		else{
			if(str.length()==3) {
				if(str.substring(0,3).equals("red")) return "red";
				else return "";
			}else{
				if(str.substring(0,3).equals("red")) return "red";
				if(str.substring(0,4).equals("blue")) return "blue";
				return "";
			}
		}
		
	}
	
	/*
	 * Given a string of any length, return a new string where the last 2 chars, 
	 * if present, are swapped, so "coding" yields "codign".
	 * 
	 *  lastTwo("coding") → "codign"
	 *  lastTwo("cat") → "cta"
	 *  lastTwo("ab") → "ba"
	 */
	public String lastTwo(String str) {
		if(str.length()<2) return str;
		return str.substring(0,str.length()-2) 
				+ str.substring(str.length()-1,str.length()) 
				+ str.substring(str.length()-2,str.length()-1);
	}
	
	/*
	 * Given two strings, append them together (known as "concatenation") 
	 * and return the result. However, 
	 * if the concatenation creates a double-char, 
	 * then omit one of the chars, 
	 * so "abc" and "cat" yields "abcat". 
	 * 
	 * conCat("abc", "cat") → "abcat"
	 * conCat("dog", "cat") → "dogcat"
	 * conCat("abc", "") → "abc"
	 * 
	 */
	public String conCat(String a, String b) {
		if(a.length()>0 && b.length()==0) return a;
		if(a.length()==0 && b.length()>0) return b;	
		if(a.charAt(a.length()-1)==b.charAt(0)){
			return a.substring(0) + b.substring(1);
		}
		return a + b;
	}
	
	/*
	 * Given 2 strings, a and b, 
	 * return a new string made of 
	 * the first char of a and the last char of b, 
	 * so "yo" and "java" yields "ya". 
	 * If either string is length 0, use '@' for its missing char. 
	 * 
	 * lastChars("last", "chars") → "ls"
	 * lastChars("yo", "java") → "ya"
	 * lastChars("hi", "") → "h@"
	 */
	public String lastChars(String a, String b) {
		String first = a.length()>0? a.substring(0,1):"@";
		String end = b.length()>0? b.substring(b.length()-1):"@";
		return first + end;
		
	}
	/*
	 * Given a string, return a string length 2 
	 * made of its first 2 chars. 
	 * If the string length is less than 2, 
	 * use '@' for the missing chars. 
	 * 
	 * atFirst("hello") → "he"
	 * atFirst("hi") → "hi"
	 * atFirst("h") → "h@"
	 */
	public String atFirst(String str) {
		if(str.length() == 0) return "@@";
		if(str.length() == 1) return str+"@";
		return str.substring(0,2);
	}
	
	/*
	 * Given a string, 
	 * return true if "bad" appears starting at index 0 or 1 
	 * in the string, 
	 * such as with "badxxx" or "xbadxx" 
	 * but not "xxbadxx". The string may be any length, including 0. 
	 * Note: use .equals() to compare 2 strings. 
	 * 
	 * hasBad("badxx") → true
	 * hasBad("xbadxx") → true
	 * hasBad("xxbadxx") → false
	 * hasBad("xba") → false
	 */
	public boolean hasBad(String str) {
		if(str.length()<3) return false;
		String target = "bad";
		if(str.length()==3) return str.substring(0,target.length()).equals(target);
		return (str.substring(0,target.length()).equals(target) 
				|| str.substring(1,target.length()+1).equals(target));
		
		/*
		 * Solution
		 
		  if (str.length()>=3 && str.substring(0, 3).equals("bad")) {
		    return true;
		  }
		  if (str.length()>=4 && str.substring(1, 4).equals("bad")) {
		    return true;
		  }
		  return false;
  
		  // Solution notes: basically want to call substring(0, 3) and
		  // substring(1, 4) and check if that equals "bad". Need to check
		  // the length first so as to not go off the end of the string.
		  // Alternately one could use indexOf() -- that code is short
		  // but it runs much slower, since it needlessly checks over the whole
		  // string.
		 * 
		 */
	}
	/*
	 * Given a string of odd length, 
	 * return the string length 3 from its middle, 
	 * so "Candy" yields "and". 
	 * The string length will be at least 3. 
	 * 
	 * middleThree("Candy") → "and"
	 * middleThree("and") → "and"
	 * middleThree("solving") → "lvi"
	 */
	public String middleThree(String str) {
		if(str.length()==3) return str;
		int center = str.length()/2;
		return str.substring(center-1,center+2);
	}
	
	/*
	 * Given a string and an index, 
	 * return a string length 2 starting at the given index. 
	 * If the index is too big or too small 
	 * to define a string length 2, use the first 2 chars. 
	 * The string length will be at least 2. 
	 * 
	 * twoChar("java", 0) → "ja"
	 * twoChar("java", 2) → "va"
	 * twoChar("java", 3) → "ja"
	 * 
	 * twoChar("java", -1) → "ja"
	 * twoChar("Hello", -7) → "He"
	 * twoChar("Hello", -1) → "He"
	 */
	public String twoChar(String str, int index) {
		if(str.length()==2) return str;
		if(str.length() < index + 2 || index < 0){
			return str.substring(0, 2);
		}else{
			return str.substring(index, index+2);
		}
	}
	
	/*
	 * Given a string and an int n, 
	 * return a string made of the first 
	 * and last n chars from the string. 
	 * The string length will be at least n. 
	 * 
	 * nTwice("Hello", 2) → "Helo"
	 * nTwice("Chocolate", 3) → "Choate"
	 * nTwice("Chocolate", 1) → "Ce"
	 */
	public String nTwice(String str, int n) {
		return str.substring(0,n)+str.substring(str.length()-n,str.length());
	}
	
	/*
	 * Given a string, return true if it ends in "ly". 
	 * 
	 * endsLy("oddly") → true
	 * endsLy("y") → false
	 * endsLy("oddy") → false
	 */
	public boolean endsLy(String str) {
		if(str.length()<2) return false;
		return str.substring(str.length()-2, str.length()).equals("ly");
	}
	/*
	 * Given a string of even length, 
	 * return a string made of the middle two chars, 
	 * so the string "string" yields "ri". 
	 * The string length will be at least 2. 
	 * 
	 * middleTwo("string") → "ri"
	 * middleTwo("code") → "od"
	 * middleTwo("Practice") → "ct"
	 */
	public String middleTwo(String str) {
		if(str.length()==2) return str;
		return str.substring(str.length()/2 -1,str.length()/2+1);
	}
	
	/*
	 * Given a string, return a version without both the first 
	 * and last char of the string. 
	 * The string may be any length, including 0. 
	 * 
	 * withouEnd2("Hello") → "ell"
	 * withouEnd2("abc") → "b"
	 * withouEnd2("ab") → ""
	 * 
	 */
	public String withouEnd2(String str) {
		if(str.length()<=2) return "";
		return str.substring(1,str.length()-1);
	}
	
	/*
	 * Given a string, return a string length 1 from its front, 
	 * unless front is false, 
	 * in which case return a string length 1 from its back. 
	 * The string will be non-empty. 
	 * 
	 * theEnd("Hello", true) → "H"
	 * theEnd("Hello", false) → "o"
	 * theEnd("oh", true) → "o"
	 * 
	 */
	public String theEnd(String str, boolean front) {
		if(front) return str.substring(0, 1);
		else return str.substring(str.length()-1);
	}
	
	/*
	 * Given a string, return a "rotated right 2" version 
	 * where the last 2 chars are moved to the start. 
	 * The string length will be at least 2. 
	 * 
	 * right2("Hello") → "loHel"
	 * right2("java") → "vaja"
	 * right2("Hi") → "Hi"
	 */
	public String right2(String str) {
		return str.substring(str.length()-2) + str.substring(0, str.length()-2);
	}
	
	/*
	 * Given a string, return a "rotated left 2" version
	 *  where the first 2 chars are moved to the end. 
	 *  The string length will be at least 2.
	 *   left2("Hello") → "lloHe"
	 *   left2("java") → "vaja"
	 *   left2("Hi") → "Hi"
	 */
	public String left2(String str) {
		return str.substring(2) + str.substring(0, 2);
	}
	
	/*
	 * Given 2 strings, return their concatenation, 
	 * except omit the first char of each. 
	 * The strings will be at least length 1.
	 *  nonStart("Hello", "There") → "ellohere"
	 *  nonStart("java", "code") → "avaode"
	 *  nonStart("shotl", "java") → "hotlava"
	 */
	public String nonStart(String a, String b) {
		return a.substring(1) + b.substring(1);
	}
	/*
	 * Given 2 strings, a and b, return a string of the form short+long+short, 
	 * with the shorter string on the outside and the longer string on the inside. 
	 * The strings will not be the same length, but they may be empty (length 0). 
	 * 
	 * comboString("Hello", "hi") → "hiHellohi"
	 * comboString("hi", "Hello") → "hiHellohi"
	 * comboString("aaa", "b") → "baaab"
	 */
	public String comboString(String a, String b) {
		String shorter = "";
		String longer = "";
		if(a.length()<b.length()){
			shorter = a;
			longer = b;
		}else{
			shorter = b;
			longer = a;
		}
		return shorter+longer+shorter;
	}
	/*
	 * Given a string, return a version without the first and last char, 
	 * so "Hello" yields "ell". The string length will be at least 2. 
	 * 
	 * withoutEnd("Hello") → "ell"
	 * withoutEnd("java") → "av"
	 * withoutEnd("coding") → "odin"
	 */
	public String withoutEnd(String str) {
		return str.substring(1,str.length()-1);
	}
	
	/*
	 * Given a string of even length, 
	 * return the first half. So the string "WooHoo" yields "Woo". 
	 * 
	 * firstHalf("WooHoo") → "Woo"
	 * firstHalf("HelloThere") → "Hello"
	 * firstHalf("abcdef") → "abc"
	 */
	public String firstHalf(String str) {
		return str.substring(0,str.length()/2);
	}
	/*
	 * Given a string, 
	 * return the string made of its first two chars, 
	 * so the String "Hello" yields "He". 
	 * If the string is shorter than length 2, 
	 * return whatever there is, so "X" yields "X", 
	 * and the empty string "" yields the empty string "". 
	 * Note that str.length() returns the length of a string. 
	 * 
	 * firstTwo("Hello") → "He"
	 * firstTwo("abcdefg") → "ab"
	 * firstTwo("ab") → "ab"
	 */
	public String firstTwo(String str) {
		if(str.length()<2){
			return str;
		}else{
			String head2 = str.substring(0,2);
			return head2;
		}
	}
	
	/*
	 * Given a string, return a new string made of 3 
	 * copies of the last 2 chars of the original string. 
	 * The string length will be at least 2. 
	 * 
	 * extraEnd("Hello") → "lololo"
	 * extraEnd("ab") → "ababab"
	 * extraEnd("Hi") → "HiHiHi"
	 */
	public String extraEnd(String str) {
		String last2 = str.substring(str.length()-2, str.length());
		return last2+last2+last2;
		
		/* Solution:
		 
		  String end = str.substring(str.length()-2);
		  return end + end + end;
		  
		  // Solution notes: the last two chars begin at index str.length()-2
		  // Here we store the chars in a local variable, which makes the code
		  // longer but simpler.
		 */
	}
	/*
	 * Given an "out" string length 4, such as "<<>>", 
	 * and a word, return a new string where the word is 
	 * in the middle of the out string, e.g. "<<word>>". 
	 * Note: use str.substring(i, j) to extract the String starting 
	 * at index i and going up to but not including index j. 
	 * 
	 * makeOutWord("<<>>", "Yay") → "<<Yay>>"
	 * makeOutWord("<<>>", "WooHoo") → "<<WooHoo>>"
	 * makeOutWord("[[]]", "word") → "[[word]]"
	 * 
	 */
	public String makeOutWord(String out, String word) {
		String start = out.substring(0,2);
		String close = out.substring(2, 4);
		return start + word + close;
	}
	/*
	 * The web is built with HTML strings like "<i>Yay</i>" which draws Yay as italic text. 
	 * In this example, the "i" tag makes <i> and </i> which surround the word "Yay". 
	 * Given tag and word strings, 
	 * create the HTML string with tags around the word, 
	 * e.g. "<i>Yay</i>".
	 * 
	 * makeTags("i", "Yay") → "<i>Yay</i>"
	 * makeTags("i", "Hello") → "<i>Hello</i>"
	 * makeTags("cite", "Yay") → "<cite>Yay</cite>"
	 */
	public String makeTags(String tag, String word) {
		return "<"+tag+">" + word + "</"+tag+">";
	}
	/*
	 * Given two strings, a and b, 
	 * return the result of putting them together in the order abba, e.g. 
	 * "Hi" and "Bye" returns "HiByeByeHi".
	 *  
	 * makeAbba("Hi", "Bye") → "HiByeByeHi"
	 * makeAbba("Yo", "Alice") → "YoAliceAliceYo"
	 * makeAbba("What", "Up") → "WhatUpUpWhat"
	 */
	public String makeAbba(String a, String b) {
		return a+b+b+a;
	}
	/*
	 * Given a string name, e.g. "Bob", 
	 * return a greeting of the form "Hello Bob!". 
	 * 
	 * helloName("Bob") → "Hello Bob!"
	 * helloName("Alice") → "Hello Alice!"
	 * helloName("X") → "Hello X!"
	 */
	public String helloName(String name) {
		return "Hello " + name + "!";
	}

}
