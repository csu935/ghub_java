package codingbat.com.AP1;
import lib.DeOut;

public class Exam {

  public static void main(String[] args) { }

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
