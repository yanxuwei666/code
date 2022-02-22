package com.xuwei.arr;

import java.awt.font.FontRenderContext;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description 数组中重复的数字
 *   在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * @Date 2022/2/21 8:47
 * @Author yxw
 */
public class RepeatNumber {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber2(nums));
    }

    public static int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int repeatNum = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeatNum = num;
                break;
            }
        }
        return repeatNum;
    }

    public static int findRepeatNumber2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == i) {
                continue;
            }
            if (nums[num] == num) {
                return num;
            }

            // 循环置位：
            // 将当前i位置上的数放置到它应该去的位置，置换出来的数，换回到i位置，盯住i位置不动，继续循环置位。
            // 期间如果发现应该去的位置上躺着的已经是正确的数字了，则发现重复，return
            // 举例：{2, 2, 3, 5, 5, 4, 3}，nums[0]=2
            while (nums[i] != i) { // 在一次置位循环中，始终盯住i位置不动，以i位置为发货地，不断向外发送数字。
                num = nums[nums[i]];
                if (num == nums[i]) { // 比较要交换的两个数是否相等，满足则返回
                    return num;
                }
                nums[nums[i]] = nums[i];
                nums[i] = num;
            }
        }
        return -1;
    }
}
