package com.xuwei.arr;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 统计一个数字在排序数组中出现的次数
 * @Date 2022/2/28 15:42
 * @Author yxw
 */
public class SearchNum {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        System.out.println("出现的次数：" + search2(nums, 8));
    }
    public static int search(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        if (!map.containsKey(target)) {
            return 0;
        }
        return map.get(target);
    }

    public static int search2(int[] nums, int target) {
        int cnt = 0;
        for (int num : nums) {
            if (num > target) {
                break;
            }
            if (num == target) {
                cnt++;
            }
        }
        return cnt;
    }
}
