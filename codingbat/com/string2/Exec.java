package codingbat.com.string2;

import lib.DeOut;

public class Exec {

	public static void main(String[] args) {
		Exec my = new Exec();
		DeOut.disp("--------output---------");
		DeOut.disp(my.sameStarChar("xy*yzz"));
		DeOut.disp(my.sameStarChar("xy*zzz"));
		DeOut.disp(my.sameStarChar("*xa*az"));
		DeOut.disp("------end output-------");
	}
	/*
	 * Returns true if for every '*' (star) in the string, 
	 * if there are chars both immediately before and after the star, 
	 * they are the same. 
	 * 
	 * sameStarChar("xy*yzz") → true
	 * sameStarChar("xy*zzz") → false
	 * sameStarChar("*xa*az") → true
		
		sameStarChar("abcDEF") → true
		sameStarChar("*") → true
		sameStarChar("**") → true
		
		sameStarChar("*xa*a*b") → false
		sameStarChar("12*2*3*") → false
		sameStarChar("XY*YYYY*Z*") → false
		sameStarChar("12*2*3*") → false
	 */
	public boolean sameStarChar(String str) {
		for(int i=1; i<str.length()-1; ++i){
			if(str.charAt(i) == '*'){
				if(str.charAt(i-1) == str.charAt(i+1)){
				}else{
					return false;
				}
			}
		}
		return true;
		/*
		 * Solution
		 * 
		 * for (int i=1; i<str.length()-1; i++) {
		    if (str.charAt(i) == '*') {
		      if (str.charAt(i-1) != str.charAt(i+1)) return false;
		    }
		  }
		  return true;
		  
		  // Solution notes: loop through the chars 1..len-2 (that is,
		  // skip over the first and last chars). Each time that the char
		  // is '*', check that the chars before and after it are equal. If they
		  // are not, return false immediately.
		 */
	}
	/*
	 * 
	 * Given a string and a non-empty word string, 
	 * return a string made of each char just before 
	 * and just after every appearance of the word in the string. 
	 * Ignore cases where there is no char before or after the word, 
	 * and a char may be included twice if it is between two words. 
	 * 
	 * wordEnds("abcXY123XYijk", "XY") → "c13i"
	 * wordEnds("XY123XY", "XY") → "13"
	 * wordEnds("XY1XY", "XY") → "11"
	 */
	public String wordEnds(String str, String word) {
		int wlen = word.length();
		int loop =str.length()-wlen+1;
		String result = "";
		for(int i=0;i<loop;i++){
			String w = str.substring(i, i+wlen);
//			DeOut.disp(w);
			if(w.equals(word)){
				//DeOut.disp(w);
				if(i>0){
					result += str.substring(i-1, i);
				}
				if(i+wlen<str.length()){
					result += str.substring(i+wlen, i+wlen+1);
				}
			}
		}
		return result;
	}
	/*
	 * Given a string and a non-empty word string, 
	 * return a version of the original String 
	 * where all chars have been replaced by pluses ("+"), 
	 * except for appearances of the word string which are preserved unchanged. 
	 * 
	 * plusOut("12xy34", "xy") → "++xy++"
	 * plusOut("12xy34xyabcxy", "xy") → "++xy++xy+++xy"
	 * plusOut("12xy34", "1") → "1+++++"
	 * 
	 * 
	 * plusOut("abXYabcXYZ", "ab") → "ab++ab++++"
	 * plusOut("abXYabcXYZ", "abc") → "++++abc+++"
	 * plusOut("abXYabcXYZ", "XY") → "++XY+++XY+"
	 * plusOut("abXYxyzXYZ", "XYZ") → "+++++++XYZ"
	 * plusOut("aaxxxxbb", "xx") → "++xxxx++"
	 * plusOut("123123", "3") → "++3++3"
	 */
	public String plusOut(String str, String word) {
		String answer = "";
		int n = 0;
		int steps = word.length();
		boolean isAdded = false;
		while(n<str.length()){
			if(n+steps-1<str.length()){
				//DeOut.disp(str.substring(n,n+steps));
				if(str.substring(n,n+steps).equals(word)){
					isAdded = true;
					answer += word;
				}else{
					answer += "+";
				}
			}else{
				answer += "+";
			}
			
			if(isAdded) {
				n += steps;
			}else{
				n++;
			}
			isAdded = false;
		}
		return answer;
	}
	/*
	 * Return a version of the given string, 
	 * where for every star (*) in the string the star 
	 * and the chars immediately to its left and right are gone. 
	 * So "ab*cd" yields "ad" and "ab**cd" also yields "ad". 
	 * 
	 * starOut("ab*cd") → "ad"
	 * starOut("ab**cd") → "ad"
	 * starOut("sm*eilly") → "silly"
	 * 
	 * starOut("*a") → ""
	 * starOut("*str*in*gy") → "ty"
	 * starOut("*stringy") → "tringy"
	 * starOut("stringy*") → "string"
	 * starOut("sm***eil*ly") → "siy"
	 */
	public String starOut(String str) {
		if(str.length()==0) return str;
		if(str.length()==1){
			if(str.equals("*")) return "";
			else return str;
		}
		
		//=================================
		// 削除するフラグ(skipAdd)がTrueになる条件、
		// starOut("ab*cd") → "ad"
		//=================================
		// skipAddがfalseで自分自身の直後が"*"の場合、
		//   skipAddがTrue
		// skipAddがtrueで自分自身の直前が"*"の場合、
		//   skipAddがFalse
		//=================================
		// 文字を追加しない条件
		//=================================
		// skipAddがTrueの場合、追加しない。
		// 文字が"*"の場合、追加しない。
		// 文字自身の前が"*"の場合、
		// 文字自身の後が"*"の場合
		// 
		String s = "";
		int n = 0;
		boolean skipAdd=false;
		while(n<str.length()){
			// skipAddを判定し設定
			//DeOut.disp(n + " : "+ str.charAt(n));
			if(!skipAdd && n!=str.length()-1 && str.charAt(n+1)=="*".charAt(0)){
				skipAdd=true;
			}else{
				if(!skipAdd && n==0 && str.charAt(n)=="*".charAt(0)) skipAdd=true;
			}
			
			if(str.charAt(n)!="*".charAt(0)){
				// 文字自身が"*"の場合、新文字には追加しない。
				// 文字自身が"*"ではない場合、skipAdd==falseで追加する
				
				// skipAddがTrueの場合、新文字には追加しない。
				if(!skipAdd){
					if(n>0 && n<str.length()-1){
						s += str.charAt(n);
					}else{
						if(n==0 && str.charAt(n+1)!="*".charAt(0)){
							s += str.charAt(n);
						}
						if(n==str.length()-1 && str.charAt(n-1)!="*".charAt(0)){
							s += str.charAt(n);
						}
					}
				}
				if(skipAdd && n!=0 && str.charAt(n-1)=="*".charAt(0)){
					skipAdd=false;
				}
			}
			
			
			
			//DeOut.disp(isDelete);
			
			n ++;
		}

		return s;
	}
	/*
	 * Look for patterns like "zip" and "zap" in the string -- length-3, 
	 * starting with 'z' and ending with 'p'. 
	 * Return a string where for all such words, 
	 * the middle letter is gone, so "zipXzap" yields "zpXzp". 
	 * 
	 * zipZap("zipXzap") → "zpXzp"
	 * zipZap("zopzop") → "zpzp"
	 * zipZap("zzzopzop") → "zzzpzp"
	 * 
	 * zipZap("zi") → "zi"
	 * zipZap("z") → "z"
	 * zipZap("") → ""
	 * zipZap("abcppp") → "abcppp"
	 * zipZap("azbcppp") → "azbcppp"
	 */
	public String zipZap(String str) {
		if(str.length()<3) return str;
		String s = "";
		for(int i=0;i<str.length();i++){
			boolean skipped = false;
			if(i<str.length()-2){
				if(str.substring(i,i+1).equals("z") 
						&& str.substring(i+2,i+3).equals("p")){
					s += str.substring(i,i+1)+str.substring(i+2,i+3);
					i += 2;
					skipped = true;
				}
			}
			if(!skipped) s += str.substring(i,i+1);
		}
		return s;
	}
	
	/*
	 * A sandwich is two pieces of bread with something in between. 
	 * Return the string that is between the first and last appearance 
	 * of "bread" in the given string, or return the empty string "" 
	 * if there are not two pieces of bread. 
	 * 
	 * getSandwich("breadjambread") → "jam"
	 * getSandwich("xxbreadjambreadyy") → "jam"
	 * getSandwich("xxbreadyy") → ""
	 */
	public String getSandwich(String str) {
		int first = str.indexOf("bread");
		int last = str.lastIndexOf("bread");
		if(first==last){
		    return "";
		}else{
		    return str.substring(first+5, last);
		}
	}
	/*
	 * Given a string, does "xyz" appear in the middle of the string? 
	 * To define middle, we'll say that the number of chars 
	 * to the left and right of the "xyz" must differ by at most one. 
	 * This problem is harder than it looks. 
	 * 
	 * xyzMiddle("AAxyzBB") → true
	 * xyzMiddle("AxyzBB") → true
	 * xyzMiddle("AxyzBBB") → false
	 * 
	 * xyzMiddle("xyzAxyzBBB") → true	
	 * xyzMiddle("xyzAxyzBxyz") → true
	 * xyzMiddle("xyzxyzAxyzBxyzxyz") → true
	 * xyzMiddle("xyzxyzxyzBxyzxyz") → true
	 * xyzMiddle("xyzxyzAxyzxyzxyz") → true
	 * xyzMiddle("") → false
	 * xyzMiddle("x") → false
	 * xyzMiddle("xy") → false
	 * 
	 * xyzMiddle("AxyzBBBB") → false
	 * xyzMiddle("AAAxyzB") → false
	 * xyzMiddle("AAAAxyzBB") → false
	 * xyzMiddle("AAAAAxyzBBB") → false
	 * xyzMiddle("xyzxyzAxyzxyzxy") → false
	 * xyzMiddle("AxyzxyzBB") → false
	 */
	public boolean xyzMiddle(String str) {
		for(int index = 0; index < str.length(); index++) {
			if(index + 3 > str.length()) {
			} else {
			  if(str.substring(index, index + 3).equals("xyz") &&
			          (index == str.length() - (index + 3) ||
			            index - 1 == str.length() - (index + 3) ||
			            index + 1 == str.length() - (index + 3))) {
			                 return true;
			       }
			    }
		  }
		return false;
	}
	/*
	 * Given a string, consider the prefix string made of 
	 * the first N chars of the string. 
	 * Does that prefix string appear somewhere else in the string? 
	 * Assume that the string is not empty 
	 * and that N is in the range 1..str.length(). 
	 * 
	 * prefixAgain("abXYabc", 1) → true
	 * prefixAgain("abXYabc", 2) → true
	 * prefixAgain("abXYabc", 3) → false
	 */
	public boolean prefixAgain(String str, int n) {
		String prefix = str.substring(0, n);
		for(int i=1;i<str.length()-n+1;i++){
			//DeOut.disp(prefix+" ===== "+str.substring(i, i+n));
			if(str.substring(i, i+n).equals(prefix)) return true;
		}
		return false;
	}
	/*
	 * Given two strings, word and a separator, 
	 * return a big string made of count occurences of the word, 
	 * separated by the separator string. 
	 * 
	 * repeatSeparator("Word", "X", 3) → "WordXWordXWord"
	 * repeatSeparator("This", "And", 2) → "ThisAndThis"
	 * repeatSeparator("This", "And", 1) → "This"
	 */
	public String repeatSeparator(String word, String sep, int count) {
		String s = "";
		for(int i=0;i<count;i++){
			s +=word;
			if(i<count-1) s += sep;
		}
		return s;
	}
	/*
	 * Given a string and an int n, return a string made of 
	 * the first n characters of the string, 
	 * followed by the first n-1 characters of the string, and so on. 
	 * You may assume that n is between 0 and the length of the string, 
	 * inclusive (i.e. n >= 0 and n <= str.length()). 
	 * 
	 * repeatFront("Chocolate", 4) → "ChocChoChC"
	 * repeatFront("Chocolate", 3) → "ChoChC"
	 * repeatFront("Ice Cream", 2) → "IcI"
	 */
	public String repeatFront(String str, int n) {
		String s = "";
		for(int i=0;i<n;i++){
			int end = n-(i+1);
			s += str.substring(0,end+1);
		}
		return s;
	}
	/*
	 * Given a string and an int N, 
	 * return a string made of N repetitions of 
	 * the last N characters of the string. 
	 * You may assume that N is between 0 
	 * and the length of the string, inclusive. 
	 * 
	 * repeatEnd("Hello", 3) → "llollollo"
	 * repeatEnd("Hello", 2) → "lolo"
	 * repeatEnd("Hello", 1) → "o"
	 */
	public String repeatEnd(String str, int n) {
		String s = "";
		for(int i=0;i<n;i++){
			s +=str.substring(str.length()-n, str.length());
		}
		return s;
	}
	/*
	 * Given two strings, A and B, create a bigger string made of the first char of A, 
	 * the first char of B, 
	 * the second char of A, the second char of B, 
	 * and so on. 
	 * Any leftover chars go at the end of the result. 
	 * 
	 * mixString("abc", "xyz") → "axbycz"
	 * mixString("Hi", "There") → "HTihere"
	 * mixString("xxxx", "There") → "xTxhxexre"
	 */
	public String mixString(String a, String b) {
		int loopCount = Math.max(a.length(), b.length());
		String s = "";
		for(int i=0;i<loopCount;i++){
			if(i<a.length()){
				s += Character.toString(a.charAt(i));
			}
			if(i<b.length()){
				s += Character.toString(b.charAt(i));
			}
		}
		return s;
	}
	/*
	 * We'll say that a String is xy-balanced 
	 * if for all the 'x' chars in the string, 
	 * there exists a 'y' char somewhere later in the string. 
	 * So "xxy" is balanced, but "xyx" is not. 
	 * One 'y' can balance multiple 'x's. 
	 * Return true if the given string is xy-balanced. 
	 * 
	 * xyBalance("aaxbby") → true
	 * xyBalance("aaxbb") → false
	 * xyBalance("yaaxbb") → false
	 * 
	 * xyBalance("yaaxbby") → true
	 * xyBalance("xaxxbbyx") → false
	 * xyBalance("bbb") → true
	 * xyBalance("") → true
	 * xyBalance("yxyxyxyxy") → true
	 * 
	 */
	public boolean xyBalance(String str) {
		String allxy="";
		for(int i=0;i<str.length();i++){
			if(Character.toString(str.charAt(i)).equals("x") 
					||Character.toString(str.charAt(i)).equals("y")){
				allxy += Character.toString(str.charAt(i));
			}
		}
		if(allxy.length()<1) return true;
		else{
			
			//DeOut.disp(allxy+" : "+allxy.lastIndexOf("x")+" <------> "+allxy.lastIndexOf("y"));
			if(allxy.lastIndexOf("x")<allxy.lastIndexOf("y")) return true;
			else return false;
		}
		/*
		 *   Solution:
		 *   
		 *   Find the rightmost y
			  int y = -1;
			  for (int i = 0; i < str.length(); i++) {
			    if (str.charAt(i)=='y') y = i;
			  }
			  
			  // Look at the x's, return false if one is after y
			  for (int i = 0; i < str.length(); i++) {
			    if (str.charAt(i)=='x' && i > y) return false;
			  }
			  return true;
			
			  // Solution notes: this solution uses two loops, each written the simple
			  // 0..length way. You could do it with a single reverse loop, noticing
			  // if you see an x before a y. Or use lastIndexOf().
		 */
	}
	/*
	 * Return true if the given string contains a "bob" string, 
	 * but where the middle 'o' char can be any char. 
	 * 
	 * bobThere("abcbob") → true
	 * bobThere("b9b") → true
	 * bobThere("bac") → false
	 */
	public boolean bobThere(String str) {
		if(str.length()<3) return false;
		for(int i=0;i<str.length()-2;i++){
			if(str.substring(i, i+1).equals("b") &&
					str.substring(i+2, i+3).equals("b")){
				return true;
			}
		}
		return false;
	}
	/*
	 * Return true if the given string contains an appearance 
	 * of "xyz" where the xyz is not directly preceeded 
	 * by a period (.). So "xxyz" counts but "x.xyz" does not. 
	 * 
	 * xyzThere("abcxyz") → tru
	 * xyzThere("abc.xyz") → false
	 * xyzThere("xyz.abc") → true
	 */
	public boolean xyzThere(String str) {
		
		for(int i=0;i<str.length()-2;i++){
			if(i==0){
				if(str.substring(i, i+3).equals("xyz")) return true;
			}else{
				if(!str.substring(i-1, i).equals(".") && 
						str.substring(i, i+3).equals("xyz")){
					return true;
				}
			}
		}
		return false;
	}
	/*
	 * Given two strings, return true if either of the strings appears 
	 * at the very end of the other string, 
	 * ignoring upper/lower case differences 
	 * (in other words, the computation should not be "case sensitive"). 
	 * Note: str.toLowerCase() returns the lowercase version of a string. 
	 * 
	 * endOther("Hiabc", "abc") → true
	 * endOther("AbC", "HiaBc") → true
	 * endOther("abc", "abXabc") → true
	 * 
	 * endOther("yz", "12xz") → false
	 */
	public boolean endOther(String a, String b) {
		String s = (a.length()<=b.length())? a.toLowerCase():b.toLowerCase();
		String l = (s.equals(a.toLowerCase()))? b.toLowerCase():a.toLowerCase();
		
		return l.substring(l.length()-s.length(),l.length()).equals(s);
	}
	/*
	 * Return the number of times that the string "code" appears 
	 * anywhere in the given string, 
	 * except we'll accept any letter for the 'd', 
	 * so "cope" and "cooe" count. 
	 * 
	 * countCode("aaacodebbb") → 1
	 * countCode("codexxcode") → 2
	 * countCode("cozexxcope") → 2
	 */
	public int countCode(String str) {
		if(str.length()<4) return 0;
		int codeCount=0;
		for(int i=0;i<str.length()-3;i++){
			if(str.substring(i, i+2).equals("co") 
					&& str.substring(i+3, i+4).equals("e")) codeCount++;
		}
		return codeCount;
	}
	/*
	 * Return true if the string "cat" and "dog" appear the same number of times 
	 * in the given string. 
	 * 
	 * catDog("catdog") → true
	 * catDog("catcat") → false
	 * catDog("1cat1cadodog") → true
	 */
	public boolean catDog(String str) {
		int catCount=0;
		int dogCount=0;
		for(int i=0;i<str.length()-2;i++){
			if(str.substring(i,i+3).equals("cat")) catCount +=1;
			if(str.substring(i,i+3).equals("dog")) dogCount +=1;
		}
		return catCount==dogCount;
	}
	/*
	 * Return the number of times that the string "hi" appears 
	 * anywhere in the given string. 
	 * 
	 * countHi("abc hi ho") → 1
	 * countHi("ABChi hi") → 2
	 * countHi("hihi") → 2
	 * 
	 * Hint: Use the standard for loop to iterate over the chars in the string, 
	 * except stop one before the end like this:
	 * 
	 for (int i=0; i < str.length()-1; i++) {
	 	
	 Inside the loop use "str.substring(i, i+2)" 
	 to pull out a substring and test it with .equals("hi"), 
	 and if so increment a count. 
	 Alternately could write the comparisons like str.charAt(i)=='h' 
	 to check for the 'h' and 'i' individually
	 */
	public int countHi(String str) {
		if(str.length()<2) return 0;
		int hiCount=0;
		for(int i=0;i<str.length()-1;i++){
			//DeOut.disp(str.substring(i,i+2));
			if(str.substring(i,i+2).equals("hi")) hiCount +=1;
		}
		return hiCount;
		/*
		 
		  int count = 0;
		  // Loop to length-1 so we can access index i and i+1 in the loop.
		  for (int i = 0; i < (str.length() - 1); i++) {
		    if (str.substring(i, i+2).equals("hi")) count++;
		  }
		  return count;
		 */
	}
	/*
	 * Given a string, return a string where for every char in the original, 
	 * there are two chars. 
	 * 
	 * doubleChar("The") → "TThhee"
	 * doubleChar("AAbb") → "AAAAbbbb"
	 * doubleChar("Hi-There") → "HHii--TThheerree"
	 * 
	 * Hint: Declare a local String result variable, starting with the empty string "". 
	 * The standard loop over every char in a string is: 
	 * "for (int i=0; i<str.length(); i++) { ...". Inside the loop, use "str.charAt(i)" 
	 * or "str.substring(i, i+1)" to get each char, 
	 * and add them to the result string with "=" and "+".
	 */
	public String doubleChar(String str) {
		String s = "";
		for(int i=0;i<str.length();i++){
			//DeOut.disp(str.charAt(i));
			s += Character.toString(str.charAt(i))+Character.toString(str.charAt(i));
		}
		return s;
		
		/*
		 Solution
		 
		  String result = "";
		  for (int i = 0; i < str.length(); i++) {
		    result = result + str.charAt(i) + str.charAt(i);
		    // Alternately:
		    // result = result + str.substring(i, i+1) + str.substring(i, i+1);
		  }
		  return result;
		}
		 */
	}

}
