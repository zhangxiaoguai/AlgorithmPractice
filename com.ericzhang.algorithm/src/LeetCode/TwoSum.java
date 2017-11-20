package com.ericzhang.algorithm.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     * 1.
     * Given an array of integers,return indices of the two numbers such they add up to a specific target.
     * You may assume that each input would have exactly one solution,and you may not use the same element twice.
     */

    public static void main(String[] args) {
        int[] example1 = {1, 3, 5, 7, 9, 11, 13, 15, 17, 2, 4, 6, 8, 10, 12, 14, 16, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
        int target1 = 59;
        int[] example2 = {2, 4, 6, 8, 10, 12, 14, 16, 18, 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
        int target2 = 59;
        int[] example3 = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 2, 4, 6, 8, 10, 12, 14, 16, 18};
        int target3 = 34;

        int[] result1;
        int[] result2;
        int[] result3;

        // 1.Brute Force
        System.out.println("Brute Force start");
        long startBF = System.currentTimeMillis();
        result1 = twoSum_1(example1, target1);
        result2 = twoSum_2(example2, target2);
        result3 = twoSum_3(example3, target3);
        println("Brute Force result1 ", result1);
        println("Brute Force result2 ", result2);
        println("Brute Force result3 ", result3);
        System.out.println("Brute Force costs: " + (System.currentTimeMillis() - startBF));

        // 2.Two Pass Hash Table
        System.out.println("Two Pass Hash Table start");
        long startTP = System.currentTimeMillis();
        result1 = twoSum_1(example1, target1);
        result2 = twoSum_2(example2, target2);
        result3 = twoSum_3(example3, target3);
        println("Two Pass Hash Table start result1 ", result1);
        println("Two Pass Hash Table start result2 ", result2);
        println("Two Pass Hash Table start result3 ", result3);
        System.out.println("Two Pass Hash Table costs: " + (System.currentTimeMillis() - startTP));

        // 3.One Pass Hash Table
        System.out.println("One Pass Hash Table start");
        long startOP = System.currentTimeMillis();
        result1 = twoSum_1(example1, target1);
        result2 = twoSum_2(example2, target2);
        result3 = twoSum_3(example3, target3);
        println("Two Pass Hash Table start result1 ", result1);
        println("Two Pass Hash Table start result2 ", result2);
        println("Two Pass Hash Table start result3 ", result3);
        System.out.println("Two Pass Hash Table costs: " + (System.currentTimeMillis() - startOP));
    }

    /**
     * Brute Force
     * Complexity Analysis:
     * Time complexity : O(n^2).For each element, we try to find its complement by looping through the rest of array which takes O(n) time. Therefore, the time complexity is O(n^2).
     * Space Complexity : O(1).No new variable created.
     */
    public static int[] twoSum_1(int[] example, int target) {
        for (int i = 0; i < example.length; i++) {
            for (int j = 1; j < example.length; j++) {
                if (example[j] == target - example[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * Two Pass Hash Table
     * Complexity Analysis:
     * Time complexity : O(n).
     * Space Complexity : O(n).
     */
    public static int[] twoSum_2(int[] example, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < example.length; i++) {
            map.put(example[i], i);
        }
        for (int i = 0; i < example.length; i++) {
            int complement = target - example[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * One Pass Hash Table
     * Complexity Analysis:
     * Time Complexity : O(n).
     * Space Complexity : O(n).
     */
    public static int[] twoSum_3(int[] example, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < example.length; i++) {
            int complement = target - example[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(example[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void println(String TAG, int[] result) {
        System.out.println("------" + TAG + "------");
        for (int a : result) {
            System.out.print(a + " ");
        }
        System.out.println();
        System.out.println("------" + TAG + "------");
    }

}
