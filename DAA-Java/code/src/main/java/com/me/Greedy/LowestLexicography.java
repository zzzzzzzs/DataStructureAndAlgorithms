package com.me.Greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 贪心算法：让字符串拼接以后有最小的字典序
 */
public class LowestLexicography {
    public static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) { // 贪心策略
            return (a + b).compareTo(b + a);
        }
    }

    public static String lowestString(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs, new MyComparator());
        String res = "";
        for (int i = 0; i < strs.length; i++) {
            res += strs[i];
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs1 = { "jibw", "ji", "jp", "bw", "jibw" };
        System.out.println(lowestString(strs1));

        String[] strs2 = { "ba", "b" };
        System.out.println(lowestString(strs2));

    }
}
