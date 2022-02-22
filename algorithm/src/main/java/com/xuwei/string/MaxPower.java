package com.xuwei.string;

/**
 * @Description 给定一个字符串，获取只包含一种字符的最长非空子字符串的长度
 * @Date 2022/2/21 13:15
 * @Author yxw
 */
public class MaxPower {
    public static void main(String[] args) {
        System.out.println(maxPower("abbcccddddeeeeedcba"));
    }

    public static int maxPower(String s) {
        int cnt = 1;
        int ans = 1; // 要返回的结果个数
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                cnt++;
                ans = Math.max(cnt, ans);
            } else {
                cnt = 1;
            }
        }
        return ans;
    }
}
