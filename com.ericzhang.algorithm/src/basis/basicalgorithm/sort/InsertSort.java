package basis.basicalgorithm.sort;

import java.util.Arrays;

/**
 * @author ericzhang
 * @email ericzhangisworking@gmail.com
 * @create 2018-02-24 上午11:40
 */
public class InsertSort {

    /**
     * 插入排序不是通过交换位置，而是通过比较找到合适的位置插入元素来达到排序的目的。
     * 例如：对5,3,8,6,4这个无序序列进行简单插入排序，首先假设第一个数的位置时正确的，想一下在拿到第一张牌的时候，没必要整理。
     * 然后3要插到5前面，把5后移一位，变成3,5,8,6,4。
     * 想一下整理牌的时候应该也是这样吧。然后8不用动，6插在8前面，8后移一位，4插在5前面，从5开始都向后移一位。
     * 注意在插入一个数的时候要保证这个数前面的数已经有序。
     * 时间复杂度：O(n^2)
     */
    public static void main(String[] args) {
        int a[] = {14, 3, 35, 63, 12};
        int[] b = {67, 24, 58};
        int[] example = {2, 4, 6, 8, 10, 12, 14, 16, 18, 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};

        insertSort(a);
        insertSort(b);
        insertSort(example);

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(example));
    }

    public static void insertSort(int[] arr) {
        // 默认第一个数位置是正确的，从第二个数开始
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            // 待插入的元素
            int target = arr[i];
            // 向后移动
            while (j > 0 && target < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            // 插入
            arr[j] = target;
        }
    }

}
