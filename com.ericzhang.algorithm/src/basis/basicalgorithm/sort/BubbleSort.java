package basis.basicalgorithm.sort;

import leetcode.TwoSum;

/**
 * @author ericzhang
 * @email ericzhangisworking@gmail.com
 * @create 2018-02-02 下午9:43
 */
public class BubbleSort {

    /**
     * 冒泡排序(Bubble Sort)：
     * 通过与相邻元素的比较和交换来把小的数交换到最前面。这个过程类似于水泡向上升一样，因此而得名。
     * 时间复杂度：O(n^2)
     */
    public static void main(String[] args) {
        int a[] = {12, 3, 14, 35, 63};
        int[] b = {67, 24, 58};
        int[] example = {2, 4, 6, 8, 10, 12, 14, 16, 18, 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
        int[] arr = {1, 1, 2, 0, 9, 3, 12, 7, 8, 3, 4, 65, 22};

//        bubbleSort(a);
//        TwoSum.println("a", a);
//        bubbleSort(b);
//        TwoSum.println("b", b);
//        bubbleSort(example);
//        TwoSum.println("example", example);
//        bubbleSort(arr);
//        TwoSum.println("arr", arr);


//        bubbleSortOptimised_1(a);
//        TwoSum.println("a", a);
//        bubbleSortOptimised_1(b);
//        TwoSum.println("b", b);
//        bubbleSortOptimised_1(example);
//        TwoSum.println("example", example);
//        bubbleSortOptimised_1(arr);
//        TwoSum.println("arr", arr);

        bubbleSortOptimised_2(a);
        TwoSum.println("a", a);
        bubbleSortOptimised_2(b);
        TwoSum.println("b", b);
        bubbleSortOptimised_2(example);
        TwoSum.println("example", example);
        bubbleSortOptimised_2(arr);
        TwoSum.println("arr", arr);
    }

    public static void bubbleSort(int[] target) {
        // 待排序的数，即需要比较的次数
        for (int i = 0; i < target.length; i++) {
            // 一个一个移动
            for (int j = 0; j < target.length - i - 1; j++) {
                if (target[j] > target[j + 1]) {
                    int temp = target[j + 1];
                    target[j + 1] = target[j];
                    target[j] = temp;
                }
            }
        }
    }

    public static void bubbleSortOptimised_1(int[] target) {
        boolean flag;
        for (int i = 0; i < target.length; i++) {
            flag = false;
            for (int j = 0; j < target.length - i - 1; j++) {
                if (target[j] > target[j + 1]) {
                    int temp = target[j];
                    target[j] = target[j + 1];
                    target[j + 1] = temp;
                    flag = true;
                }
            }
            // 某一趟循环没有换位置则证明剩下的队列已经是有序队列
            if (!flag) {
                break;
            }
        }
    }

    /**
     * 现在有一个包含1000个数的数组，仅前面100个无序，后面900个都已排好序且都大于前面100个数字。
     * 那么在第一趟遍历后，最后发生交换的位置必定小于100，且这个位置之后的数据必定已经有序了，也就是这个位置以后的数据不需要再排序了。
     * 于是记录下这位置，第二次只要从数组头部遍历到这个位置就可以了。
     * 如果是对于上面的冒泡排序优化1来说，虽然也只排序100次，但是前面的100次排序每次都要对后面的900个数据进行比较。
     * 而对于现在的排序优化2，只需要有一次比较后面的900个数据，之后就会设置尾边界，保证后面的900个数据不再被排序。
     * 比优化1少比较一趟。
     */
    public static void bubbleSortOptimised_2(int[] target) {
        // flag来记录最后交换的位置，也就是排序的尾边界
        int flag = target.length;
        // 排序未结束标志
        while (flag > 0) {
            // k来记录遍历的尾边界
            int k = flag;
            flag = 0;
            for (int j = 0; j < k - 1; j++) {
                // 前面的数字大于后面的数字就交换
                if (target[j] > target[j + 1]) {
                    int temp = target[j + 1];
                    target[j + 1] = target[j];
                    target[j] = temp;
                    // 表示交换过数据
                    // 记录最新的尾边界
                    flag = j;
                }
            }
        }
    }

}
