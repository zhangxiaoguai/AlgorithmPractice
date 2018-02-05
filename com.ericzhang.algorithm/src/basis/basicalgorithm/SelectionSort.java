package basis.basicalgorithm;

import leetcode.TwoSum;

/**
 * @author ericzhang
 * @email ericzhangisworking@gmail.com
 * @create 2018-02-01 下午3:39
 */
public class SelectionSort {

    /**
     * 选择排序(Selection Sort)：
     * 首先在未排序队列中找到最小(或者最大)的元素，存放到排序队列的起始位置，然后再从剩余未排序队列中继续寻找最小(或者最大)的元素，然后放到已排序序列的末尾。
     * 以此类推，直到所有元素均排序完毕。
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     */
    public static void main(String[] args) {
        int a[] = {14, 3, 35, 63, 12};
        int[] b = {67, 24, 58};
        int[] example = {2, 4, 6, 8, 10, 12, 14, 16, 18, 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};

        selectionSort(a);
        TwoSum.println("a", a);
        selectionSort(b);
        TwoSum.println("b", b);
        selectionSort(example);
        TwoSum.println("example", example);

        a = new int[]{14, 3, 35, 63, 12};
        b = new int[]{67, 24, 58};
        example = new int[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};

        selectionSort2(a);
        TwoSum.println("a", a);
        selectionSort2(b);
        TwoSum.println("b", b);
        selectionSort2(example);
        TwoSum.println("example", example);
    }

    public static void selectionSort(int[] target) {
        for (int i = 0; i < target.length; i++) {
            int min = i;
            for (int j = i + 1; j < target.length; j++) {
                if (target[min] > target[j]) {
                    min = j;
                }
                if (j == (target.length - 1) && min != i) {
                    int temp = target[i];
                    target[i] = target[min];
                    target[min] = temp;
                }
            }
        }
    }

    public static void selectionSort2(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int max = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[max] < numbers[j]) {
                    max = j;
                }
                if (j == (numbers.length - 1) && max != i) {
                    int temp = numbers[i];
                    numbers[i] = numbers[max];
                    numbers[max] = temp;
                }
            }
        }
    }

}
