package com.xuwei.arr;

import java.util.Arrays;

/**
 * @Description TODO
 * @Date 2022/2/28 14:31
 * @Author yxw
 */
public class Exchange {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(Arrays.toString(Arrays.stream(exchange2(arr)).toArray()));
    }

    public static int[] exchange(int[] nums) {
        int[] ans = new int[nums.length];

        int count = 0; // 计数器
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                ans[count++] = nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                ans[count++] = nums[i];
            }
        }
        return ans;
    }

    /**
     * 指针判断法，如果i指向偶数且j指向奇数，交换位置
     * @param nums
     * @return
     */
    public static int[] exchange2(int[] nums) {
        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            while (i < j && (nums[i] & 1) == 1) {
                i++;
            }
            while (i < j && (nums[j] & 1) == 0) {
                j--;
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }
}
