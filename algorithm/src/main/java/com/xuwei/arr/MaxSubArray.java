package com.xuwei.arr;

import java.util.Arrays;

/**
 * @Description 连续子数组的最大和
 * @Date 2022/2/28 15:06
 * @Author yxw
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("连续子数组最大和：" + maxSubArray2(nums));
    }

    /**
     * 动态规划
     * 对于一个元素，只有取和不取
     * 如果取，则 dp[i] = dp[i-1] + nums[i]
     * 如果不取：则 dp[i] = nums[i]（相当于从这个元素作为子区间的新起点，重新算起）
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int maxSubSum = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            maxSubSum = Math.max(maxSubSum, dp[i]);
        }
        return maxSubSum;
    }

    public static int maxSubArray2(int[] nums) {
        int pre = 0;
        int maxAns = nums[0];
        for (int n : nums) {
            pre = Math.max(pre + n, n);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
