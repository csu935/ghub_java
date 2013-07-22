package codingbat.com.Recursion1;

import lib.DeOut;

public class Exam {

  public static void main(String[] args) { Exam ex = new Exam(); }

  /*
   * Count recursively the total number of "abc"
   * and "aba" substrings that appear in the given string.
   *
   * countAbc("abc") → 1
   * countAbc("abcxxabc") → 2
   * countAbc("abaxxaba") → 2
   */
  public int countAbc(String str) {
    if(str.length()<3) return 0;
    int count = 0;
    int index = 0;
    if(index<str.length()-2){
      String s = str.substring(index, index+3);
      if(s.equals("abc") || s.equals("aba")) count++;
      index++;
      return count + countAbc(str.substring(1));
    }else{
      return count;
    }
  }

  /*
   * We'll say that a "pair" in a string is two instances of a char separated by a char.
   * So "AxA" the A's make a pair. Pair's can overlap,
   * so "AxAxA" contains 3 pairs -- 2 for A and 1 for x.
   * Recursively compute the number of pairs in the given string.
   *
   * countPairs("axa") → 1
   * countPairs("axax") → 2
   * countPairs("axbx") → 1
   */
  public int countPairs(String str) {
    int count = 0;
    int index = 0;
    if(index<str.length()-2){
      if(str.substring(index, index+1).equals(str.substring(index+2, index+3))){
        count++;
      }
      return count + countPairs(str.substring(1));
    }else{
      return count;
    }
  }

  /*
   * Given a string, compute recursively a new string
   * where all the lowercase 'x' chars have been moved to the end of
   * the string.
   *
   * endX("xxre") → "rexx"
   * endX("xxhixx") → "hixxxx"
   * endX("xhixhix") → "hihixxx"
   */
  public String endX(String str) {
    String s = "";
    boolean isX = false;
    int index = 0;
    if(index<str.length()){
      if(str.startsWith("x")){
        isX = true;
      }else{
        s = str.substring(index, index+1);
      }
      index++;
      return (isX)? s + endX(str.substring(1))+"x":s + endX(str.substring(1));

    }else{
      return str;
    }

  }

  /*
   * Given a string, compute recursively a new string
   * where identical chars that are adjacent
   * in the original string are separated from each other by a "*".
   *
   * pairStar("hello") → "hel*lo"
   * pairStar("xxyy") → "x*xy*y"
   * pairStar("aaaa") → "a*a*a*a"
   */
  public String pairStar(String str) {
    String s = "";
    int index = 0;
    if(index<str.length()-1){
      if(str.substring(index, index+1).equals(str.substring(index+1, index+2))){
        s = str.substring(index, index+1)+"*";
      }else{
        s = str.substring(index, index+1);
      }
      index++;
      return s + pairStar(str.substring(1));
    }else{
      return str;
    }
  }

  /*
   * Given a string, compute recursively a new string
   * where all the adjacent chars are now separated by a "*".
   *
   * allStar("hello") → "h*e*l*l*o"
   * allStar("abc") → "a*b*c"
   * allStar("ab") → "a*b"
   */
  public String allStar(String str) {
    String s = "";
    int index = 0;
    if(index<str.length()){
      s = (index<str.length()-1) ? str.substring(index,index+1) + "*" :
        str.substring(index,index+1);
      index++;
      return s + allStar(str.substring(1));
    }else{
      return str;
    }
  }

  /*
   * Given an array of ints, compute recursively
   * if the array contains somewhere a value followed in the array
   * by that value times 10.
   * We'll use the convention of considering only the part of
   * the array that begins at the given index.
   * In this way, a recursive call can pass index+1 to move down the array.
   * The initial call will pass in index as 0.
   *
   * array220({1, 2, 20}, 0) → true
   * array220({3, 30}, 0) → true
   * array220({3}, 0) → false
   */
  public boolean array220(int[] nums, int index) {
    if(nums.length<2) return false;
    if(index<nums.length-1){
      if(nums[index]*10==nums[index+1]) return true;
      else{
        index++;
        return array220(nums,index);
      }
    }else{
      return false;
    }
  }

  /*
   * Given an array of ints, compute recursively the number
   * of times that the value 11 appears in the array.
   * We'll use the convention of considering only the part
   * of the array that begins at the given index. In this way,
   * a recursive call can pass index+1 to move down the array.
   * The initial call will pass in index as 0.
   *
   * array11({1, 2, 11}, 0) → 1
   * array11({11, 11}, 0) → 2
   * array11({1, 2, 3, 4}, 0) → 0
   */
  public int array11(int[] nums, int index) {
    int count = 0;
    if(index<nums.length){
      if(nums[index]==11) count++;
      index++;
      // Return count + the result of array11
      return count + array11(nums,index);
    }else{
      return count;
    }
  }

  /*
   * Given an array of ints, compute recursively if the array contains a 6.
   * We'll use the convention of considering only the part of the array
   * that begins at the given index. In this way,
   * a recursive call can pass index+1 to move down the array.
   * The initial call will pass in index as 0.
   *
   * array6({1, 6, 4}, 0) → true
   * array6({1, 4}, 0) → false
   * array6({6}, 0) → true
   */
  public boolean array6(int[] nums, int index) {
    if(index<nums.length){
      if(nums[index]==6){
        return true;
      }else{
        index++;
        return array6(nums,index);
      }
    }else{
      return false;
    }
  }

  /*
   * Given a string, compute recursively a new string
   * where all the 'x' chars have been removed.
   *
   * noX("xaxb") → "ab"
   * noX("abc") → "abc"
   * noX("xx") → ""
   */
  public String noX(String str) {
    if(str.length()==0) return str;
    String nox = "";
    if(!str.substring(0,1).equals("x")){
      nox += str.substring(0, 1);
    }
    return nox + noX(str.substring(1));
  }

  /*
   * Given a string, compute recursively (no loops)
   * a new string where all appearances of "pi" have been
   * replaced by "3.14".
   *
   * changePi("xpix") → "x3.14x"
   * changePi("pipi") → "3.143.14"
   * changePi("pip") → "3.14p"
   */
  public String changePi(String str) {
    if(str.length()<2) return str;
    String replaced = "";
    int index = 1;
    if(str.substring(0,2).equals("pi")) {
      replaced = "3.14";
      // 2 index skip
      index = 2;
    }else {
      replaced = str.substring(0,1);
    }
    return replaced + changePi(str.substring(index));
  }

  /*
   * Given a string, compute recursively (no loops) a new string
   * where all the lowercase 'x' chars have been changed to 'y' chars.
   *
   *
   * changeXY("codex") → "codey"
   * changeXY("xxhixx") → "yyhiyy"
   * changeXY("xhixhix") → "yhiyhiy"
   */
  public String changeXY(String str) {
    if(str.length()==0) return str;
    String s = "";
    if(str.substring(0,1).equals("x")) s = "y";
    else s = str.substring(0,1);
    // remove first character
    return s + changeXY(str.substring(1));
  }

  /*
   * Given a string, compute recursively (no loops)
   * the number of times lowercase "hi" appears in the string.
   *
   * countHi("xxhixx") → 1
   * countHi("xhixhix") → 2
   * countHi("hi") → 1
   */
  public int countHi(String str) {
    if(str.length()<2) return 0;
    int hicount = 0;
    if(str.length()==2){
      if(str.equals("hi")) hicount = 1;
    }else{

      if(str.substring(str.length()-2).equals("hi")){
        hicount = 1 + countHi(str.substring(0,str.length()-1));
      }else{
        hicount = countHi(str.substring(0,str.length()-1));
      }
    }
    return hicount;
  }

  /*
   * Solution: countHi
   */
  /*
  public int countHi(String str) {
    if (str.length() <= 1) return 0;
    int count = 0;
    if (str.substring(0, 2).equals("hi")) count = 1;  // could use startsWith()
    return count + countHi(str.substring(1));
  }
  */

  /*
    * Given a string, compute recursively (no loops) the number
    * of lowercase 'x' chars in the string.
    *
    * countX("xxhixx") → 4
    * countX("xhixhix") → 3
    * countX("hi") → 0
    */
  public int countX(String str) {
    // considered the case of "str.length()==0"
    if(str.length()==0) return 0;
    int xcount = 0;
    if(str.length()==1){
      if(str.equals("x")) xcount = 1;
    }else{
      String s = str.substring(0,str.length());
      if(s.substring(s.length()-1,s.length()).equals("x")){
        xcount = 1 + countX(s.substring(0, s.length()-1));
      }else{
        xcount = countX(s.substring(0,s.length()-1));
      }
    }
    return xcount;
  }

  /*
   * Given base and n that are both 1 or more, compute recursively (no loops)
   * the value of base to the n power, so powerN(3, 2) is 9 (3 squared).
   *
   * powerN(3, 1) → 3
   * powerN(3, 2) → 9
   * powerN(3, 3) → 27
   */
  public int powerN(int base, int n) {

    if(n==1){
      return base;
    }else{
      // recursively here
      n--;
      return base*powerN(base,n);
    }

  }

  /*
   * Given a non-negative int n, compute recursively (no loops)
   * the count of the occurrences of 8 as a digit,
   * except that an 8 with another 8 immediately to its left counts double,
   * so 8818 yields 4. Note that mod (%) by 10 yields the rightmost digit
   * (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit
   * (126 / 10 is 12).
   *
   * count8(8) → 1
   * count8(818) → 2
   * count8(8818) → 4
   */
  public int count8(int n) {
    int count = 0;
    if(n/10==0){
      if(n==8) count = 1;
    }else{
      if(n%10==8){
        if((n/10)%10==8){
          count = 2 + count8(n/10);
        }else{
          count = 1 + count8(n/10);
        }
      }else{
        count = count8(n/10);
      }
    }
    return count;
  }

  /*
   * Given a non-negative int n, return the count of the occurrences of 7 as a digit,
   * so for example 717 yields 2. (no loops).
   * Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6),
   * while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
   *
   * count7(717) → 2
   * count7(7) → 1
   * count7(123) → 0
   */
  public int count7(int n) {
    int count = 0;
    if(n/10==0){
      // rightmost is '7'
      if(n==7) count = 1;
    }else{
      // recursively
      if(n % 10 == 7) count = 1 + count7(n/10);
      else  count = count7(n/10);
    }
    return count;
  }

  /*
   * Given a non-negative int n,
   * return the sum of its digits recursively (no loops).
   * Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6),
   * while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
   *
   * sumDigits(126) → 9
   * sumDigits(49) → 13
   * sumDigits(12) → 3
   */
  public int sumDigits(int n) {
    return (n/10==0)? n : (n % 10) + sumDigits(n/10);
  }

  /*
   * We have triangle made of blocks. The topmost row has 1 block,
   * the next row down has 2 blocks, the next row has 3 blocks,
   * and so on. Compute recursively (no loops or multiplication)
   * the total number of blocks in such a triangle
   * with the given number of rows.
   *
   * triangle(0) → 0
   * triangle(1) → 1
   * triangle(2) → 3
   */
  public int triangle(int rows) {
    if(rows==0) return 0;
    return rows + triangle(rows-1);

    // Solution notes: what is triangle(20)? It's whatever
    // triangle(19) returns, plus 20.
  }

  /*
   * We have bunnies standing in a line, numbered 1, 2, ...
   * The odd bunnies (1, 3, ..) have the normal 2 ears.
   * The even bunnies (2, 4, ..) we'll say have 3 ears,
   * because they each have a raised foot. Recursively
   * return the number of "ears" in the bunny line 1, 2, ... n
   * (without loops or multiplication).
   *
   * bunnyEars2(0) → 0
   * bunnyEars2(1) → 2
   * bunnyEars2(2) → 5
   */
  public int bunnyEars2(int bunnies) {
    if(bunnies==0) return 0;
    return (bunnies%2==0)? bunnyEars2(bunnies-1)+3:bunnyEars2(bunnies-1)+2;
  }

  /*
   * The fibonacci sequence is a famous bit of mathematics,
   * and it happens to have a recursive definition.
   * The first two values in the sequence are 0 and 1 (essentially 2 base cases).
   * Each subsequent value is the sum of the previous two values,
   * so the whole sequence is: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on.
   * Define a recursive fibonacci(n) method that returns the nth fibonacci number,
   * with n=0 representing the start of the sequence.
   *
   *  fibonacci(0) → 0
   *  fibonacci(1) → 1
   *  fibonacci(2) → 1
   */
  public int fibonacci(int n) {
    if(n==0) return 0;
    if(n==1) return 1;
    return fibonacci(n-1)+fibonacci(n-2);
  }

  /*
   * We have a number of bunnies and each bunny has two big floppy ears.
   * We want to compute the total number of ears across all the bunnies recursively
   * (without loops or multiplication).
   *
   * bunnyEars(0) → 0
   * bunnyEars(1) → 2
   * bunnyEars(2) → 4
   *
   * Hint: First detect the base case (bunnies == 0), and in that case just return 0. Otherwise,
   * make a recursive call to bunnyEars(bunnies-1).
   * Trust that the recursive call returns the correct value, and fix it up by adding 2.
   */
  public int bunnyEars(int bunnies) {
    // Base case: if bunnies==0, just return 0.
    if (bunnies == 0) return 0;
    return 2 + bunnyEars(bunnies-1);
  }

  /*
   * Given n of 1 or more, return the factorial of n, which is n * (n-1) * (n-2) ... 1.
   * Compute the result recursively (without loops).
   *
   * factorial(1) → 1
   * factorial(2) → 2
   * factorial(3) → 6
   */
  public int factorial(int n) {
    // Base case: if n is 1, we can return the answer directly
    // less than 1 inclusive is always 1
    if(n<=1) return 1;

    // Recursion: otherwise make a recursive call with n-1
    // (towards the base case), i.e. call factorial(n-1).
    // Assume the recursive call works correctly, and fix up
    // what it returns to make our result.
    return n * factorial(n-1);
  }
}
