package codingbat.com.array3;
import lib.DeOut;

public class Exec {

  /**
   * @param args
   */
  public static void main(String[] args) { }

  /*
   * Return an array that contains exactly the same numbers
   * as the given array, but rearranged so that every 3
   * is immediately followed by a 4. Do not move the 3's,
   * but every other number may move.
   * The array contains the same number of 3's and 4's,
   * every 3 has a number after it that is not a 3 or 4,
   * and a 3 appears in the array before any 4.
   *
   * fix34({1, 3, 1, 4}) → {1, 3, 4, 1}
   * fix34({1, 3, 1, 4, 4, 3, 1}) → {1, 3, 4, 1, 1, 3, 4}
   * fix34({3, 2, 2, 4}) → {3, 4, 2, 2}
   */
  public int[] fix34(int[] nums) {
    int n = 0;
    for(int i=0;i<nums.length;i++){
      if(nums[i]==3&&nums[i+1]!=4){
        //DeOut.disp(nums[i+1]);
        int t = nums[i+1];
        while(n<nums.length){
          if(nums[n]==4){
            nums[n]=t;
            nums[i+1]=4;
            break;
          }
          n++;
        }
      }
    }
    return nums;
  }

  /*
   * Consider the leftmost and righmost appearances of some value in an array.
   * We'll say that the "span" is the number of elements between the two inclusive.
   * A single value has a span of 1. Returns the largest span found in the given array.
   * (Efficiency is not a priority.)
   *
   * maxSpan({1, 2, 1, 1, 3}) → 4
   * maxSpan({1, 4, 2, 1, 4, 1, 4}) → 6
   * maxSpan({1, 4, 2, 1, 4, 4, 4}) → 6
   */
  public int maxSpan(int[] nums) {
    if(nums.length==1) return 1;
    if(nums.length==2){
      if(nums[0]==nums[1]){
        return 2;
      }else{
        return 1;
      }
    }
    boolean startChecked = false;
    int range1 = 0;
    int range2 = 0;
    for(int i=0;i<nums.length;i++){
      if(i>0 && nums[i]==nums[0]){
        range1 = i+1;
      }
      if(!startChecked && nums[i]==nums[nums.length-1]
          && i < nums.length-1){
        range2 = nums.length-i;
        startChecked = true;

      }
    }
    return Math.max(range1, range2);
  }

}
