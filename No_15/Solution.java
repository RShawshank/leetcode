package No_15;

import java.util.*;

public class Solution {
    public static void main(String[] args) {

    }
    /**
     * 采取排序加双指针法
    */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list =new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i =0;i<nums.length;i++) {
            int now = nums[i];
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int L = i + 1;
            int R = nums.length - 1;
            while (R > L) {
                int sum = nums[L] + nums[R] + now;
                if (sum == 0) {
                    list.add(Arrays.asList(nums[L], nums[R], now));
                    while (R > L && nums[L] == nums[L + 1]) L++;
                    while (R > L && nums[R] == nums[R - 1]) R--;
                    L++;
                    R--;
                } else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return list;
    }
}
