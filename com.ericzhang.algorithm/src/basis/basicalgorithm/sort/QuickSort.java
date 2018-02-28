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
     */
    public static void main(String[] args) {
        int[] example = {8, 2, 1, 7, 3, 5, 9, 6};
        sort(example);
        System.out.println(Arrays.toString(example));

        int[] arr = {1, 1, 2, 0, 9, 3, 12, 7, 8, 3, 4, 65, 22};
        sort(arr);
        System.out.println(Arrays.toString(arr));

        int a[] = {14, 3, 35, 63, 12};
        sort(a);
        System.out.println(Arrays.toString(a));

        int[] b = {67, 24, 58};
        sort(b);
        System.out.println(Arrays.toString(b));

        int[] c = {2, 4, 6, 8, 10, 12, 14, 16, 18, 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
        sort(c);
        System.out.println(Arrays.toString(c));
    }

    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0)
            return;
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right)
            return;
        int pivotPos = partition(arr, left, right);
        quickSort(arr, left, pivotPos - 1);
        quickSort(arr, pivotPos + 1, right);
    }

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
