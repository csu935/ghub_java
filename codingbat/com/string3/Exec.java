package codingbat.com.string3;

import lib.DeOut;

public class Exec {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Exec my = new Exec();
		DeOut.disp("--------output---------");
//		DeOut.disp(my.countYZ("fez day"));
//		DeOut.disp(my.countYZ("day fez"));
//		DeOut.disp(my.countYZ("day fyyyz"));
		DeOut.disp(my.countYZ("day:yak"));
		DeOut.disp(my.countYZ("!!day--yaz!!"));
		DeOut.disp(my.countYZ("DAY abc XYZ"));
		DeOut.disp(my.countYZ("y2bz"));
		DeOut.disp("------end output-------");
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
	 * countYZ("day:yak") → 1
	 * countYZ("!!day--yaz!!") → 2
	 * countYZ("DAY abc XYZ") → 2
	 * countYZ("y2bz") → 2
	 */
	public int countYZ(String str) {
//		DeOut.disp(Character.isLetter(str.charAt(str.length()-1)));
		String[] s = str.split("[^a-zA-Z]");
//		DeOut.dispSList(s);
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
