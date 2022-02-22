package com.xuwei.string;

/**
 * @Description 替换空格
 * @Date 2022/2/21 13:05
 * @Author yxw
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        System.out.println(replaceSpace("jlksdjlsdfj dsjklsdj sdj"));
    }

    public static String replaceSpace(String s) {
        char[] ch = new char[s.length() * 3];
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); // 获取当前字符
            if (c == ' ') {
                ch[size++] = '%';
                ch[size++] = '2';
                ch[size++] = '0';
            } else {
                ch[size++] = c;
            }
        }
        return new String(ch, 0, size);
    }
}
