package com.xuwei.arr;

/**
 * @Description 旋转数组的最小数字
 * @Date 2022/2/22 9:07
 * @Author yxw
 */
public class MinArray {
    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};
        int[] arr2 = {7,8,1,2,3,4,5};
        System.out.println(minArray(arr));
    }

    public static int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }
}
