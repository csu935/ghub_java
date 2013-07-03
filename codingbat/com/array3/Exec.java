package codingbat.com.array3;
import lib.DeOut;

public class Exec {

  /**
   * @param args
   */
  public static void main(String[] args) { }

  /*
   * Given a non-empty array, return true
   * if there is a place to split the array
   * so that the sum of the numbers on one side
   * is equal to the sum of the numbers on the other side.
   *
   * canBalance({1, 1, 1, 2, 1}) → true
   * canBalance({2, 1, 1, 2, 1}) → false
   * canBalance({10, 10}) → true
   *
   */
  public boolean canBalance(int[] nums) {
    if(nums.length<2) return false;

    int i =0;
    int j = 0;
    int len = nums.length;

    boolean toEnd = true;
    boolean toFront = true;

    int sumHead = 0;
    int sumTail = 0;

    while(i+j<len){
      int k = len-j-1;

      if(toEnd&&i<=k){
        sumHead += nums[i];
      }

      if(toFront&&k>i){
        sumTail += nums[k];
      }

      // Stop adding the value
      // using flag..
      if(sumHead>sumTail){
        toEnd = false;
        toFront = true;
        j++;
      }else if(sumHead<sumTail){
        toFront = false;
        toEnd = true;
        i++;
      }else{
        toFront=toEnd=true;
        i++;
        j++;
      }

    }

    return sumHead==sumTail;
  }
  /*
   * (This is a slightly harder version of the fix34 problem.)
   * Return an array that contains exactly the same numbers
   * as the given array, but rearranged so that every 4 is immediately
   * followed by a 5. Do not move the 4's,
   * but every other number may move.
   * The array contains the same number of 4's and 5's,
   * and every 4 has a number after it that is not a 4.
   * In this version, 5's may appear anywhere in the original array.
   *
   * fix45({5, 4, 9, 4, 9, 5}) → {9, 4, 5, 4, 5, 9}
   * fix45({1, 4, 1, 5}) → {1, 4, 5, 1}
   * fix45({1, 4, 1, 5, 5, 4, 1}) → {1, 4, 5, 1, 1, 4, 5}
   *
   * fix45({5, 5, 4, 1, 4, 1}) → {1, 1, 4, 5, 4, 5}
   * fix45({4, 5, 4, 1, 5}) → {4, 5, 4, 5, 1}
   */
  public int[] fix45(int[] nums) {

    for(int i=0;i<nums.length;i++){
      if(nums[i]==4&&nums[i+1]!=5){

        int t = nums[i+1];
        int k =0;
        while(k<nums.length){

          if((k==0&&nums[k]==5)||
              (k>0&&nums[k]==5&&nums[k-1]!=4)){
            nums[k]=t;
            nums[i+1]=5;
            break;
          }

          k++;
        }
      }
    }
    return nums;
  }

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
