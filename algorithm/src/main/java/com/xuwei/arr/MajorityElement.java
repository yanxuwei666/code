package com.xuwei.arr;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Date 2022/2/23 8:40
 * @Author yxw
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(majorityElement(arr));
    }

    // map集合判断
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = countNums(nums);
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value > nums.length / 2) {
                return key;
            }
        }
        return -1;
    }

    // 数组排序，取中间数
    public static int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                int num = map.get(nums[i]) + 1;
                map.put(nums[i], num);
            }
        }
        return map;
    }
}
