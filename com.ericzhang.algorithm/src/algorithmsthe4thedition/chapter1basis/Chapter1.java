package algorithmsthe4thedition.chapter1basis;

/**
 * @author ericzhang
 * @email ericzhangisworking@gmail.com
 * @create 2018-03-06 下午2:41
 */
public class Chapter1 {

    public static void main(String[] args) {
        // 1.1 二分查找
        int[] key = {1, 2, 3, 4, 5};
        System.out.println(binarySearch(5, key));

        // 1.1.1
        System.out.println((0 + 15) / 2);// 7
        // 2.0e-6 == (2 * 10 ^ (-6)) = 0.000002
        System.out.println(2.0e-6 * 100000000.1);// 200.0000002
        System.out.println(true && false || true && true);// true

        // 1.1.2
        System.out.println((1 + 2.236) / 2);// 1.628
        System.out.println(1 + 2 + 3 + 4.0);// 10.0
        System.out.println(4.1 >= 4);// true
        System.out.println(1 + 2 + "3");// 33

        // 1.1.3

    }

    /**
     * 二分查找
     */
    public static int binarySearch(int key, int[] a) {
        // 数组必须是有序的
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            // 被查找的元素要么不存在，要么必然存在于a[low,high]之间
            int mid = (low + high) / 2;
            if (key < a[mid]) high = mid - 1;
            if (key > a[mid]) low = mid + 1;
            else return mid;
        }
        return -1;
    }

}
