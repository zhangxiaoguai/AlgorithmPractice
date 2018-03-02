package basis.basicalgorithm.sort;

import java.util.Arrays;

/**
 * @author ericzhang
 * @email ericzhangisworking@gmail.com
 * @create 2018-02-05 下午8:59
 */
public class QuickSort {

    /**
     * 快速排序：
     * 在实际应用当中表现最好的排序算法。
     * 快速排序使用分治法（Divide and conquer）策略来把一个序列（list）分为两个子序列（sub-lists）。
     * <p>
     * 步骤为：
     * 从数列中挑出一个元素，称为"基准"（pivot），重新排序数列，
     * 所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆在基准后面（相同的数可以到任何一边）。
     * 在这个分区结束之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
     * 递归地（recursively）把小于基准值元素的子数列和大于基准值元素的子数列排序。
     * 递归到最底部时，数列的大小是零或一，也就是已经排序好了。这个算法一定会结束，因为在每次的迭代（iteration）中，它至少会把一个元素摆到它最后的位置去。
     * <p>
     * 其实就是：冒泡+二分+递归+分治
     */
    public static void main(String[] args) {
        int[] example = {8, 2, 1, 7, 3, 5, 9, 6};
        quickSort(example);
        System.out.println(Arrays.toString(example));

        int[] arr = {1, 1, 2, 0, 9, 3, 12, 7, 8, 3, 4, 65, 22};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));

        int a[] = {14, 3, 35, 63, 12};
        quickSort(a);
        System.out.println(Arrays.toString(a));

        int[] b = {67, 24, 58};
        quickSort(b);
        System.out.println(Arrays.toString(b));

        int[] c = {2, 4, 6, 8, 10, 12, 14, 16, 18, 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
        quickSort(c);
        System.out.println(Arrays.toString(c));
    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length == 0)
            return;
        quickSortRecursive(arr, 0, arr.length - 1);
    }

    /**
     * 递归划分子序列
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSortRecursive(int[] arr, int left, int right) {
        if (left >= right)
            return;
        int pivotPos = partition(arr, left, right);
        quickSortRecursive(arr, left, pivotPos - 1);
        quickSortRecursive(arr, pivotPos + 1, right);
    }

    /**
     * 分区（partition）操作
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int partition(int[] arr, int left, int right) {
        int pivotKey = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivotKey)
                right--;
            // 把小的移动到左边
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivotKey)
                left++;
            // 把大的移动到右边
            arr[right] = arr[left];
        }
        // 最后把pivot交换到中间
        arr[left] = pivotKey;
        return left;
    }

}
