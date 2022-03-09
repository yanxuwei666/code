package com.xuwei.string;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Description 第一个只出现一次的字符
 * @Date 2022/3/7 8:44
 * @Author yxw
 */
public class FirstUniqChar {
    public static void main(String[] args) {
        System.out.println("第一个只出现一次的字符：" + firstUniqChar("hello world"));
    }

    /**
     * 存入map，判断集合是否存在
     * @param s
     * @return
     */
    public static char firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
