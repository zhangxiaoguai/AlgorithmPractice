package com.ericzhang.algorithm.LintCode;

/**
 * @author EricZhang
 * @email ericzhangisworking@gmail.com
 */
public class TrailingZeros {

    /**
     * 2.
     * 尾部的零：
     * 设计一个算法，计算出n阶乘中尾部零的个数。
     */
    public static void main(String[] args) {
        long target = 5555550000000L;

        // FIXME: 2017/11/8 target过大时算法1耗时过长
//        long count1 = trailingZeros_1(target);
//        System.out.println(count1);

        long count2 = trailingZeros_2(target);
        System.out.println(count2);

        long count3 = trailingZeros_3(target);
        System.out.println(count3);
    }

    /**
     * 时间复杂度：
     * 分析发现代码的时间复杂度实际是O(N/5)~=O(N)
     * 一个数一个数的求；
     */
    public static long trailingZeros_1(long target) {
        long count = 0;
        long step;
        for (int temp = 5; temp <= target; temp += 5) {
            count++;
            step = 25;
            while (temp % step == 0) {
                count++;
                step *= 5;
            }
        }
        return count;
    }

    /**
     * 1.每5个数中会出现一个可以产生结果中0的数字。
     * 2.将1中的这些数字化成5*(1、2、3、4、5、...)的形式，内部的1、2、3、4、5、...又满足上面的分析：每5个数字有一个是5的倍数。
     * 3.以此类推，重复1，2步骤，计算尾部一共有多少零
     * 时间复杂度：
     * 算法中每次循环均有除以5的操作，也就是每次都会将所要处理的数据量缩小至上一次的1/5，容易推知时间复杂度为O(logN)。
     *
     * @url：http://blog.csdn.net/surp2011/article/details/51168272
     */
    public static long trailingZeros_2(long target) {
        long count = 0;
        long tempZeros = target / 5;
        while (tempZeros != 0) {
            count += tempZeros;
            tempZeros /= 5;
        }
        return count;
    }

    public static long trailingZeros_3(long target) {
        long count = 0;
        while (target != 0) {
            target /= 5;
            count += target;
        }
        return count;
    }

}
