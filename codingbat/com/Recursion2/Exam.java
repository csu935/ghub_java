package codingbat.com.Recursion2;

import lib.DeOut;
public class Exam {

  public static void main(String[] args) { }

  /*
   * Given an array of ints, is it possible to choose a group of some of the ints,
   * such that the group sums to the given target with these additional constraints:
   * all multiples of 5 in the array must be included in the group.
   * If the value immediately following a multiple of 5 is 1,
   * it must not be chosen. (No loops needed.)
   *
   * groupSum5(0, {2, 5, 10, 4}, 19) → true
   * groupSum5(0, {2, 5, 10, 4}, 17) → true
   * groupSum5(0, {2, 5, 10, 4}, 12) → false
   * groupSum5(0, {3, 5, 1}, 9) → false
   * groupSum5(0, {2, 5, 4, 10}, 12) → false
   * groupSum5(0, {3, 5, 1}, 5) → true
   * groupSum5(0, {1, 3, 5}, 5) → true
   * groupSum5(0, {1}, 1) → true
   */
  public boolean groupSum5(int start, int[] nums, int target) {
    if (start >= nums.length) return (target == 0);
    // nums[start]が5の倍数の場合
    if (nums[start] % 5 == 0) {
      // ただし、次の数が1の場合は無視する処理
       if (start < nums.length - 1 && nums[start + 1] == 1){
        // インデックスは2つ進める
         return groupSum5(start + 2, nums, target - nums[start]);
       }
       //　この処理はデフォルト
      return groupSum5(start + 1, nums, target- nums[start]);
    }
    return groupSum5(start + 1, nums, target - nums[start])
              || groupSum5(start + 1, nums, target);
  }

  /*
   * Given an array of ints, is it possible to choose a group of some of the ints,
   * such that the group sums to the given target with this additional constraint:
   * If a value in the array is chosen to be in the group,
   * the value immediately following it in the array must not be chosen.
   * (No loops needed.)
   *
   * groupNoAdj(0, {2, 5, 10, 4}, 12) → true
   * groupNoAdj(0, {2, 5, 10, 4}, 14) → false
   * groupNoAdj(0, {2, 5, 10, 4}, 7) → false
   */
  public boolean groupNoAdj(int start, int[] nums, int target) {
    // target==0になっているなら、true
    if (start >= nums.length) return (target == 0);
    // startが選ばれていない場合は、targetにはなにもせず次の値にする
    if (groupNoAdj(start+1, nums, target)) return true;
    // nums[start]が選ばれている時、2つ飛ばす
    if (groupNoAdj(start+2, nums, target-nums[start])) return true;

    return false;
  }

  /*
   * Given an array of ints, is it possible to choose a group of some of the ints,
   * beginning at the start index, such that the group sums to the given target? However,
   * with the additional constraint that all 6's must be chosen. (No loops needed.)
   *
   * groupSum6(0, {5, 6, 2}, 8) → true
   * groupSum6(0, {5, 6, 2}, 9) → false
   * groupSum6(0, {5, 6, 2}, 7) → false
   * groupSum6(0, {1}, 1) → true
   * groupSum6(0, {3, 2, 4, 6}, 8) → true
   * groupSum6(0, {6, 2, 4, 3}, 8) → true
   * groupSum6(0, {1, 6, 2, 6, 4}, 12) → true
   * groupSum6(0, {1, 6, 2, 6, 4}, 13) → true
   * groupSum6(0, {1, 6, 2, 6, 5}, 14) → true
   * groupSum6(0, {1, 6, 2, 6, 5}, 15) → true
   *
   */
  public boolean groupSum6(int start, int[] nums, int target) {
    // target==0になっているなら、true
    if (start >= nums.length) return (target == 0);
    // nums[start]==6の場合、target-6して再帰処理
    if (nums[start]==6) return groupSum6(start+1, nums, target-6);
    // nums[start]が選ばれた場合の再帰処理：target-nums[start]して、startを1つ進める
    if (groupSum6(start + 1, nums, target - nums[start])) return true;
    // nums[start]が選ばれなかった場合の再帰処理：選ばれていないので、startを1つ進める
    if (groupSum6(start + 1, nums, target)) return true;
    return false;

    /*
     *  if (start >= nums.length) return (target == 0);
      if (groupSum6(start + 1, nums, target - nums[start])) return true;
      else if (nums[start] != 6 && groupSum6(start + 1, nums, target)) return true;
      else return false;
     */
  }

  /*
   * Given an array of ints, is it possible to choose a group of some of the ints,
   * such that the group sums to the given target?
   * This is a classic backtracking recursion problem.
   * Once you understand the recursive backtracking strategy in this problem,
   * you can use the same pattern for many problems to search a space of choices.
   * Rather than looking at the whole array, our convention is to consider the part
   * of the array starting at index start and continuing to the end of the array.
   * The caller can specify the whole array simply by passing start as 0.
   * No loops are needed -- the recursive calls progress down the array.
   *
   * groupSum(0, {2, 4, 8}, 10) → true
   * groupSum(0, {2, 4, 8}, 14) → true
   * groupSum(0, {2, 4, 8}, 9) → false
   *
   * Hint: The base case is when start>=nums.length. In that case,
   * return true if target==0. Otherwise, consider the element at nums[start].
   * The key idea is that there are only 2 possibilities -- nums[start] is chosen or it is not.
   * Make one recursive call to see if a solution is possible if nums[start] is chosen
   * (subtract nums[start] from target in that call).
   * Make another recursive call to see if a solution is possible if nums[start] is not chosen.
   * Return true if either of the two recursive calls returns true.
   */
  public boolean groupSum(int start, int[] nums, int target) {
    // Base case: if there are no numbers left, then there is a
    // solution only if target is 0.
    if (start >= nums.length) return (target == 0);

    // Key idea: nums[start] is chosen or it is not.
    // Deal with nums[start], letting recursion
    // deal with all the rest of the array.

    // Recursive call trying the case that nums[start] is chosen --
    // subtract it from target in the call.
    if (groupSum(start + 1, nums, target - nums[start])) return true;

    // Recursive call trying the case that nums[start] is not chosen.
    if (groupSum(start + 1, nums, target)) return true;

     // If neither of the above worked, it's not possible.
     return false;
  }
}
