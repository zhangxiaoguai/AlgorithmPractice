package basis.basicalgorithm;

import leetcode.TwoSum;

/**
 * @author ericzhang
 * @email ericzhangisworking@gmail.com
 * @create 2018-02-02 下午9:43
 */
public class BubbleSort {

    /**
     * 冒泡排序(Bubble Sort)：
     */
    public static void main(String[] args) {
        int a[] = {12, 3, 14, 35, 63};
//        int[] b = {67, 24, 58};
//        int[] example = {2, 4, 6, 8, 10, 12, 14, 16, 18, 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
//        int[] arr = {1, 1, 2, 0, 9, 3, 12, 7, 8, 3, 4, 65, 22};

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
//        bubbleSortOptimised_2(b);
//        TwoSum.println("b", b);
//        bubbleSortOptimised_2(example);
//        TwoSum.println("example", example);
//        bubbleSortOptimised_2(arr);
//        TwoSum.println("arr", arr);
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
            if (!flag) {
                break;
            }
        }
    }

    public static void bubbleSortOptimised_2(int[] target) {
        int j, k;
        int flag = target.length;//flag来记录最后交换的位置，也就是排序的尾边界

        while (flag > 0) {//排序未结束标志
            k = flag; //k 来记录遍历的尾边界
            flag = 0;

            for (j = 1; j < k; j++) {
                if (target[j - 1] > target[j]) {//前面的数字大于后面的数字就交换
                    //交换a[j-1]和a[j]
                    int temp;
                    temp = target[j - 1];
                    target[j - 1] = target[j];
                    target[j] = temp;

                    //表示交换过数据;
                    flag = j;//记录最新的尾边界.
                }
            }
        }
    }

}
