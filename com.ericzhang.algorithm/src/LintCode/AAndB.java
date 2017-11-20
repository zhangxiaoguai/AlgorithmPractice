package com.ericzhang.algorithm.LintCode;

public class AAndB {

    /**
     * 1.
     * A + B 问题：
     * 给出两个整数a和b，求他们的和，但是不能使用 + 等数学运算符。
     */
    public static void main(String[] args) {
        System.out.println(aplusb_1(2, 3));
        System.out.println(aplusb_2(2, 3));
    }

    /**
     * 位运算：只能用于整型
     * & 与，两个位都为1时结果为1；串联；可以用来判断有没有进位；
     * | 或，两个位都为0时结果为0；并联
     * ^ 异或，两个位相同为0，相异为1；没有进位的加法；
     * ~ 取反，0变1，1变0；
     * << 左移，高位丢弃，低位补零；
     * >> 右移，分有符号数和无符号数；
     */

    public static int aplusb_1(int a, int b) {
        int c;
        int d;
        // a & b 有没有需要进位的地方
        while ((a & b) != 0) {
            c = (a & b) << 1;
            d = a ^ b;
            a = c;
            b = d;
        }
        // 最后没有进位了直接异或相加/或相加
        // 当没有进位时，| 与 ^ 结果相同
        return a | b;
    }

    public static int aplusb_2(int a, int b) {
        if (b == 0) return a;
        return aplusb_2(a ^ b, (a & b) << 1);
    }

}
