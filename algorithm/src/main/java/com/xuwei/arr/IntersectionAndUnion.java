package com.xuwei.arr;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @Description 求两个数组的交集和并集
 * @Date 2022/2/21 13:24
 * @Author yxw
 */
public class IntersectionAndUnion {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 6};
        int[] arr2 = {1, 9, 3, 4, 5};

        HashSet<Integer> set1 = new HashSet<Integer>();
        HashSet<Integer> set2 = new HashSet<Integer>();
        HashSet<Integer> set3 = new HashSet<Integer>();

        for (int i = 0; i < arr1.length; i++) {
            set1.add(arr1[i]);
            set3.add(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            if (set1.contains(arr2[i])) {
                set2.add(arr2[i]);
            }
            set3.add(arr2[i]);
        }
        System.out.println("交集：" + set2);
        System.out.println("并集：" + set3);
    }
}
