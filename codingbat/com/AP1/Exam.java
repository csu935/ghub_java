package codingbat.com.AP1;
import java.util.List;
import java.util.ArrayList;
import lib.DeOut;

public class Exam {

  public static void main(String[] args) { }

  /*
   * (A variation on the sumHeights problem.) We have an array of heights,
   * representing the altitude along a walking trail.
   * Given start/end indexes into the array, return the sum of the changes
   * for a walk beginning at the start index and ending at the end index,
   * however increases in height count double. For example,
   * with the heights {5, 3, 6, 7, 2} and start=2, end=4 yields
   * a sum of 1*2 + 5 = 7. The start end end index will both be valid indexes
   * into the array with start <= end.
   *
   * sumHeights2({5, 3, 6, 7, 2}, 2, 4) → 7
   * sumHeights2({5, 3, 6, 7, 2}, 0, 1) → 2
   * sumHeights2({5, 3, 6, 7, 2}, 0, 4) → 15
   */
  public int sumHeights2(int[] heights, int start, int end) {
    int count = end - start;
    int sum = 0;
    for(int i=0;i<count;i++){
      int t = Math.abs(heights[start+i]-heights[start+i+1]);
      if(heights[start+i]<heights[start+i+1]){
        sum += t*2;
      }else{
        sum += t;
      }

    }
    return sum;
  }

  /*
   * We have an array of heights, representing the altitude along a walking trail.
   * Given start/end indexes into the array,
   * return the sum of the changes for a walk beginning
   * at the start index and ending at the end index. For example,
   * with the heights {5, 3, 6, 7, 2} and start=2, end=4 yields a sum of 1 + 5 = 6.
   * The start end end index will both be valid indexes
   * into the array with start <= end.
   *
   * sumHeights({5, 3, 6, 7, 2}, 2, 4) → 6
   * sumHeights({5, 3, 6, 7, 2}, 0, 1) → 2
   * sumHeights({5, 3, 6, 7, 2}, 0, 4) → 11
   */
  public int sumHeights(int[] heights, int start, int end) {
    // loop count
    int count = end - start;
    int sum = 0;

    for(int i=0;i<count;i++){
      // get difference 2 values
      sum += Math.abs(heights[start+i]-heights[start+i+1]);
    }
    return sum;
  }

  /*
   * Given two arrays, A and B, of non-negative int scores.
   * A "special" score is one which is a multiple of 10, such as 40 or 90.
   * Return the sum of largest special score in A and the largest special score in B.
   * To practice decomposition, write a separate helper method
   * which finds the largest special score in an array.
   * Write your helper method after your scoresSpecial() method in the JavaBat text area.
   *
   * scoresSpecial({12, 10, 4}, {2, 20, 30}) → 40
   * scoresSpecial({20, 10, 4}, {2, 20, 10}) → 40
   * scoresSpecial({12, 11, 4}, {2, 20, 31}) → 20
   */
  public int scoresSpecial(int[] a, int[] b) {
    return findMaxSpecialScore(a)+findMaxSpecialScore(b);
  }
   /* helper method */
  private int findMaxSpecialScore(int[] nums){
    int max = 0;
    for(int i=0;i<nums.length;i++){
      if(nums[i]%10==0){
        max = Math.max(max, nums[i]);
      }
    }
    return max;
  }

  /*
   * Given an array of strings, return a new array without the strings
   * that are equal to the target string.
   * One approach is to count the occurrences of the target string,
   * make a new array of the correct length, and then copy over the correct strings.
   *
   * wordsWithout({"a", "b", "c", "a"}, "a") → {"b", "c"}
   * wordsWithout({"a", "b", "c", "a"}, "b") → {"a", "c", "a"}
   * wordsWithout({"a", "b", "c", "a"}, "c") → {"a", "b", "a"}
   */
  public String[] wordsWithout(String[] words, String target) {
    int len = 0;
    for(int i=0;i<words.length;i++){
      if(!words[i].equals(target)) len++;
    }
    String[] without = new String[len];
    int start = 0;
    for(int i=0;i<words.length;i++){
      if(!words[i].equals(target)){
        without[start] = words[i];
        start++;
      }
    }
    return without;
  }

  /*
   * The "key" array is an array containing the correct answers to an exam,
   * like {"a", "a", "b", "b"}. the "answers" array contains a student's answers,
   * with "?" representing a question left blank.
   * The two arrays are not empty and are the same length.
   * Return the score for this array of answers, giving +4 for each correct answer, -1
   * for each incorrect answer, and +0 for each blank answer.
   *
   * scoreUp({"a", "a", "b", "b"}, {"a", "c", "b", "c"}) → 6
   * scoreUp({"a", "a", "b", "b"}, {"a", "a", "b", "c"}) → 11
   * scoreUp({"a", "a", "b", "b"}, {"a", "a", "b", "b"}) → 16
   */
  public int scoreUp(String[] key, String[] answers) {
    int score = 0;
    for(int i=0;i<key.length;i++){
      if(key[i].equals(answers[i])){
        score += 4;
      }else if(answers[i].equals("?")){
        score += 0;
      }else{
        score -= 1;
      }
    }
    return score;
  }

  /*
   * Given 2 arrays that are the same length containing strings,
   * compare the 1st string in one array to the 1st string in the other array,
   * the 2nd to the 2nd and so on. Count the number of times
   * that the 2 strings are non-empty and start with the same char.
   * The strings may be any length, including 0.
   *
   * matchUp({"aa", "bb", "cc"}, {"aaa", "xx", "bb"}) → 1
   * matchUp({"aa", "bb", "cc"}, {"aaa", "b", "bb"}) → 2
   * matchUp({"aa", "bb", "cc"}, {"", "", "ccc"}) → 1
   */
  public int matchUp(String[] a, String[] b) {
    int times = 0;
    for(int i=0;i<a.length;i++){
      if(!(a[i].equals("") || b[i].equals(""))){
        String sa = a[i].substring(0,1);
        String sb = b[i].substring(0,1);
        if(sa.length()>0 && sb.length()>0 &&
            sa.equals(sb)){
          times++;
        }
      }
    }
    return times;
  }

  /*
   * We'll say that a positive int n is "endy"
   * if it is in the range 0..10 or 90..100 (inclusive).
   * Given an array of positive ints, return a new array of
   * length "count" containing the first endy numbers from the original array.
   * Decompose out a separate isEndy(int n) method to test
   * if a number is endy. The original array will contain
   * at least "count" endy numbers.
   *
   * copyEndy({9, 11, 90, 22, 6}, 2) → {9, 90}
   * copyEndy({9, 11, 90, 22, 6}, 3) → {9, 90, 6}
   * copyEndy({12, 1, 1, 13, 0, 20}, 2) → {1, 1}
   */
  public int[] copyEndy(int[] nums, int count) {
    int[] endy = new int[count];
    int n = 0;
    for(int i=0;i<nums.length;i++){
      if(isEndy(nums[i])){
        if(n<count){
          endy[n] = nums[i];
          n++;
        }else{
          break;
        }
      }
    }
    return endy;
  }
  /*
   * isEndy(int n) method
   */
  private boolean isEndy(int n){
    if((n>=0 && 10>=n) ||
        n>=90 && 100>=n){
      return true;
    }
    return false;
  }

  /*
   * Given an array of positive ints, return a new array
   * of length "count" containing the first even numbers
   * from the original array. The original array will contain
   * at least "count" even numbers.
   *
   * copyEvens({3, 2, 4, 5, 8}, 2) → {2, 4}
   * copyEvens({3, 2, 4, 5, 8}, 3) → {2, 4, 8}
   * copyEvens({6, 1, 2, 4, 5, 8}, 3) → {6, 2, 4}
   */
  public int[] copyEvens(int[] nums, int count) {
    int[] evens = new int[count];
    int index = 0;
    for(int i=0;i<nums.length;i++){
      if(nums[i]%2==0) {
        if(index<count){
          evens[index] = nums[i];
          index++;
        }else{
          break;
        }
      }
    }
    return evens;
  }

  /*
   * We'll say that a positive int divides itself
   * if every digit in the number divides into the number evenly.
   * So for example 128 divides itself since 1, 2, and 8 all divide into 128 evenly.
   * We'll say that 0 does not divide into anything evenly,
   * so no number with a 0 digit divides itself.
   * Note: use % to get the rightmost digit, and / to discard the rightmost digit.
   *
   * dividesSelf(128) → true
   * dividesSelf(12) → true
   * dividesSelf(120) → false
   * -----
   * dividesSelf(120) → false
   * dividesSelf(13) → false
   * dividesSelf(32) → false
   * dividesSelf(22) → true
   * dividesSelf(42) → false
   * dividesSelf(212) → true
   * dividesSelf(213) → false
   * dividesSelf(162) → true
   *
   */
  public boolean dividesSelf(int n) {
    int len = String.valueOf(n).length();
    int copied = n;
    for(int i=0;i<len;i++){
      // if copied == 0 return false
      if(i==0 && copied % 10==0) return false;
      if(n % (copied % 10) != 0) return false;
      copied /= 10;
    }
    return true;
  }

  /*
   * Given a positive int n, return true if it contains a 1 digit.
   * Note: use % to get the rightmost digit, and / to discard the rightmost digit.
   *
   * hasOne(10) → true
   * hasOne(22) → false
   * hasOne(220) → false
   */
  public boolean hasOne(int n) {
    // n's length
    int len = String.valueOf(n).length();
    for(int i=0;i<len;i++){
      if(n % 10 == 1) return true;
      else n /= 10;
    }
    return false;
  }

  /*
   * Given an array of strings, return a new List (e.g. an ArrayList)
   * where all the strings of the given length are omitted.
   * See wordsWithout() below which is more difficult because it uses arrays.
   *
   * wordsWithoutList({"a", "bb", "b", "ccc"}, 1) → {"bb", "ccc"}
   * wordsWithoutList({"a", "bb", "b", "ccc"}, 3) → {"a", "bb", "b"}
   * wordsWithoutList({"a", "bb", "b", "ccc"}, 4) → {"a", "bb", "b", "ccc"}
   */
  public List<String> wordsWithoutList(String[] words, int len) {
    List<String> list = new ArrayList<String>();
    for(int i=0;i<words.length;i++){
      if(words[i].length()!=len) list.add(words[i]);
    }
    return list;
  }

  /*
   * Given an array of strings, return a new array containing
   * the first N strings. N will be in the range 1..length.
   *
   * wordsFront({"a", "b", "c", "d"}, 1) → {"a"}
   * wordsFront({"a", "b", "c", "d"}, 2) → {"a", "b"}
   * wordsFront({"a", "b", "c", "d"}, 3) → {"a", "b", "c"}
   */
  public String[] wordsFront(String[] words, int n) {
    String[] ans = new String[n];
    for(int i=0;i<n;i++){
      ans[i] = words[i];
    }
    return ans;
  }

  /*
   * Given an array of strings, return the count of the number
   * of strings with the given length.
   *
   * wordsCount({"a", "bb", "b", "ccc"}, 1) → 2
   * wordsCount({"a", "bb", "b", "ccc"}, 3) → 1
   * wordsCount({"a", "bb", "b", "ccc"}, 4) → 0
   */
  public int wordsCount(String[] words, int len) {
    int count = 0;
    for(int i=0;i<words.length;i++){
      if(words[i].length()==len) count++;
    }
    return count;
  }

  /*
   * Given an array of scores, compute the int average of the first half
   * and the second half, and return whichever is larger.
   * We'll say that the second half begins at index length/2.
   * The array length will be at least 2. To practice decomposition,
   * write a separate helper method <br>int average(int[] scores,
   * int start, int end) { which computes the average of the elements
   * between indexes start..end. Call your helper method twice
   * to implement scoresAverage().
   * Write your helper method after your scoresAverage() method
   * in the JavaBat text area. Normally you would compute averages with doubles,
   * but here we use ints so the expected results are exact.
   *
   * scoresAverage({2, 2, 4, 4}) → 4
   * scoresAverage({4, 4, 4, 2, 2, 2}) → 4
   * scoresAverage({3, 4, 5, 1, 2, 3}) → 4
   *
   * scoresAverage({5, 6}) → 6
   * scoresAverage({5, 4}) → 5
   */
  public int scoresAverage(int[] scores) {
    int len = scores.length;
    if(len==2){
      return Math.max(scores[0], scores[len-1]);
    }else{
      int first = average(scores,0,len/2);
      int second = average(scores,len/2,len-1);
      return Math.max(first,second);
    }

  }
  /*
   * int average(int[] scores, int start, int end) {
   * which computes the average of the elements between indexes start..end.
   */
  int average(int[] scores, int start, int end) {
    int sum = 0;
    for(int i=0;i<end-start;i++){
      sum += scores[i+start];
    }
    return sum/(end-start);
  }

  /*
   * Given an array of scores sorted in increasing order,
   * return true if the array contains 3 adjacent scores that
   * differ from each other by at most 2,
   * such as with {3, 4, 5} or {3, 5, 5}.
   *
   * scoresClump({3, 4, 5}) → true
   * scoresClump({3, 4, 6}) → false
   * scoresClump({1, 3, 5, 5}) → true
   */
  public boolean scoresClump(int[] scores) {
    if(scores.length<3) return false;
    for(int i=0;i<scores.length-2;i++){
      if(scores[i+1]-scores[i]<=2 &&
          scores[i+2]-scores[i]<=2 &&
          scores[i+2]-scores[i+1]<=2){

        return true;
      }
    }
    return false;
  }

  /*
   * Given an array of scores, return true
   * if there are scores of 100 next to each other in the array.
   * The array length will be at least 2.
   *
   * scores100({1, 100, 100}) → true
   * scores100({1, 100, 99, 100}) → false
   * scores100({100, 1, 100, 100}) → true
   */
  public boolean scores100(int[] scores) {

    for(int i=0;i<scores.length-1;i++){
      if(scores[i]==100 && scores[i+1]==100){
        return true;
      }
    }
    // default false
    return false;
  }

  /*
   * Given an array of scores, return true if each score is equal
   * or greater than the one before. The array will be length 2 or more.
   *
   * scoresIncreasing({1, 3, 4}) → true
   * scoresIncreasing({1, 3, 2}) → false
   * scoresIncreasing({1, 1, 4}) → true
   */
  public boolean scoresIncreasing(int[] scores) {
    for(int i=0;i<scores.length-1;i++){
      if(scores[i]>scores[i+1]) return false;
    }
    return true;
  }

}
