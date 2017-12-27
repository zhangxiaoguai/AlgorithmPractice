package com.ericzhang.algorithm.LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author EricZhang
 * @email ericzhangisworking@gmail.com
 */
public class LengthOfLongestSubstring {

    /**
     * 3.
     * Given a string, find the length of the longest substring without repeating characters.
     * Examples:
     * Given "abcabcbb", the answer is "abc", which the length is 3.
     * Given "bbbbb", the answer is "b", with the length of 1.
     * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     */

    public static void main(String[] args) {
        int target;
        target = lengthOfLongestSubstring_1("pwwkew");
        System.out.println(target);

        target = lengthOfLongestSubstring_2("pwwkew");
        System.out.println(target);

        target = lengthOfLongestSubstring_3("pwwkew");
        System.out.println(target);

        target = lengthOfLongestSubstring_4("pwwkew");
        System.out.println(target);
    }

    /**
     * 自己写的 Brute Force
     */
    public static int lengthOfLongestSubstring_1(String target) {
        StringBuilder tempResult = new StringBuilder();
        int length = 0;
        out:
        for (int i = 0; i < target.length(); i++) {
            tempResult.setLength(0);// 内部用的是 Arrays.copyOf 的方式
            char currentStr = target.charAt(i);
            tempResult.append(currentStr);// 内部用的是 Arrays.copyOf 的方式
            if (length < tempResult.length()) {
                length = tempResult.length();
            }
            for (int j = i + 1; j < target.length(); j++) {
                String nextStr = Character.toString(target.charAt(j));
                if (tempResult.indexOf(nextStr) == -1) {// indexOf 用的是 for 循环
                    tempResult.append(target.charAt(j));
                    if (length < tempResult.length()) {
                        length = tempResult.length();
                    }
                } else {
                    continue out;
                }
            }
        }
        return length;
    }

    /**
     * 推荐的Brute Force
     * 时间复杂度：O(n^3)
     * 空间复杂度：O(min(n, m))
     */
    public static int lengthOfLongestSubstring_2(String target) {
        int n = target.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(target, i, j)) ans = Math.max(ans, j - i);
        return ans;
    }

    public static boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }

    /**
     * Sliding Window
     * 时间复杂度：O(2n) ≈ O(n)
     * 空间复杂度：O(min(m,n))
     */
    public static int lengthOfLongestSubstring_3(String target) {
        Set<Character> set = new HashSet<>();
        int resultLength = 0, subStart = 0, subEnd = 0;
        while (subStart < target.length() && subEnd < target.length()) {
            if (!set.contains(target.charAt(subEnd))) {
                set.add(target.charAt(subEnd++));
                resultLength = Math.max(resultLength, subEnd - subStart);
            } else {
                set.remove(target.charAt(subStart++));
            }
        }
        return resultLength;
    }

    /**
     * Sliding Window Optimized
     * if s[j] have a duplicate in the range [i, j) with index j', we don't need to increase i little by little.
     * We can skip all the elements in the range [i, j'] and let i to be j' + 1 directly.
     */
    public static int lengthOfLongestSubstring_4(String target) {
        Map<Character, Integer> slidingWindow = new HashMap<>();
        int length = 0;
        for (int i = 0, j = 0; j < target.length(); j++) {
            if (slidingWindow.containsKey(target.charAt(j))) {
                i = Math.max(slidingWindow.get(target.charAt(j)), i);
            }
            length = Math.max(length, j - i + 1);
            slidingWindow.put(target.charAt(j), j + 1);
        }
        return length;
    }

}
