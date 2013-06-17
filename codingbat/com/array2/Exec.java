package codingbat.com.array2;
import lib.DeOut;

public class Exec {

  /**
   * @param args
   */
  public static void main(String[] args) {
    Exec my = new Exec();
    DeOut.disp("--------output---------");
    DeOut.disp(my.centeredAverage(new int[]{1, 2, 3, 4, 100}));
    DeOut.disp(my.centeredAverage(new int[]{1, 1, 5, 5, 10, 8, 7}));
    DeOut.disp(my.centeredAverage(new int[]{-10, -4, -2, -4, -2, 0}));
    DeOut.disp("------end output-------");
  }
  /*
   * Return the "centered" average of an array of ints,
   * which we'll say is the mean average of the values,
   * except ignoring the largest
   * and smallest values in the array.
   * If there are multiple copies of the smallest value,
   * ignore just one copy, and likewise for the largest value.
   * Use int division to produce the final average.
   * You may assume that the array is length 3 or more.
   *
   * centeredAverage({1, 2, 3, 4, 100}) → 3
   * centeredAverage({1, 1, 5, 5, 10, 8, 7}) → 5
   * centeredAverage({-10, -4, -2, -4, -2, 0}) → -3
   */
  public int centeredAverage(int[] nums) {
    int sorted_end = 0;
    int count = 0;
    int candidate_val;
    while(sorted_end < nums.length-1){
      candidate_val = nums[sorted_end + 1];
      count = sorted_end;
      while(count>=0){
        if(nums[count] < candidate_val){
          break;
        }else{
          nums[count+1] = nums[count];
          nums[count] = candidate_val;
        }
        count--;
      }
      sorted_end++;
    }

    int sum = 0;
    for(int i=0;i<nums.length;i++){
      if(i!=0 && i!=nums.length-1) sum += nums[i];
    }
    return sum/(nums.length-2);
  }
  /*
   * Given an array length 1 or more of ints,
   * return the difference between the largest and smallest
   * values in the array. Note: the built-in
   * Math.min(v1, v2) and Math.max(v1, v2) methods
   * return the smaller or larger of two values.
   *
   * bigDiff({10, 3, 5, 6}) → 7
   * bigDiff({7, 2, 10, 9}) → 8
   * bigDiff({2, 10, 7, 2}) → 8
   */
  public int bigDiff(int[] nums) {
    int max = nums[0];
    int min = nums[0];
    for(int i=0;i<nums.length;i++){
      max = Math.max(max, nums[i]);
      min = Math.min(min, nums[i]);
    }
    return max-min;
  }
  /*
   * Return the number of even ints in the given array.
   * Note: the % "mod" operator computes the remainder,
   * e.g. 5 % 2 is 1.
   *
   * countEvens({2, 1, 2, 3, 4}) → 3
   * countEvens({2, 2, 0}) → 3
   * countEvens({1, 3, 5}) → 0
   */
  public int countEvens(int[] nums) {
    int count=0;
    for(int i=0;i<nums.length;i++){
      if(nums[i]%2==0) count++;
    }
    return count;
  }
}

