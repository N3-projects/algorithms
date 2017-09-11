package n3.algorithms.fondation.sort;

/**
 * @author N3 on 2017/9/6.
 */
public class QuickSort {

    public static void sort(int[] a) {

        quickSortInternal(a, 0, a.length-1);
    }

    private static void quickSortInternal(int[] a, int start, int end) {
        if (start < end) {
//            int partition = partitionTwoWay(a, start, end);
            int partition = partitionOneWay_lowAsPartition(a, start, end);
//            int partition = partitionOneWay_highAsPartition(a, start, end);
            quickSortInternal(a, start, partition - 1);
            quickSortInternal(a, partition +1, end);
        }
    }

    /**
     * <p>
     * 快速排序选取partition的算法，选取low位元素作为枢纽值，
     * 最终将枢纽值放到正确的位子上，使得比枢纽值小的元素在枢纽值左边，比枢纽值大的元素在枢纽值右边
     * </p>
     * <p>
     * 算法使用两个下标同时从low向high和从high向low移动，双向遍历
     * </p>
     * @param a 待排序的数组
     * @param low 数组中待排序的分区的起始下标
     * @param high 数组中待排序的分区的终止下标
     * @return 根据枢纽值移动分区后，枢纽值在数组中的下标
     */
    private static int partitionTwoWay(int[] a, int low, int high) {
        int key = a[low];
        while (low < high) {
            while (low < high && a[high] >= key) {
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low] <= key) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = key;
        return low;
    }

    /**
     * <p>
     * 快速排序选取partition的算法，选取low位元素作为枢纽值，
     * 最终将枢纽值放到正确的位子上，使得比枢纽值小的元素在枢纽值左边，比枢纽值大的元素在枢纽值右边
     * </p>
     * <p>
     * 算法使用两个下标同时都从low向high移动，同向遍历
     * </p>
     * @param a 待排序的数组
     * @param low 数组中待排序的分区的起始下标
     * @param high 数组中待排序的分区的终止下标
     * @return 根据枢纽值移动分区后，枢纽值在数组中的下标
     */
    private static int partitionOneWay_lowAsPartition(int[] a, int low, int high) {
        int key = a[low];
        int i = low;
        int j = low + 1;
        while (j <= high) {
            if (a[j] < key) {
                i++;
                swap(a, i, j);
            }
            j++;
        }
        swap(a, low, i);
        return i;
    }

    /**
     * <p>
     * 快速排序选取partition的算法，选取high位元素作为枢纽值，
     * 最终将枢纽值放到正确的位子上，使得比枢纽值小的元素在枢纽值左边，比枢纽值大的元素在枢纽值右边
     * </p>
     * <p>
     * 算法使用两个下标同时都从low向high移动，同向遍历
     * </p>
     * @param a 待排序的数组
     * @param low 数组中待排序的分区的起始下标
     * @param high 数组中待排序的分区的终止下标
     * @return 根据枢纽值移动分区后，枢纽值在数组中的下标
     */
    private static int partitionOneWay_highAsPartition(int[] a, int low, int high) {
        int key = a[high];
        int i = low-1;
        int j = low;
        while (j <= high) {
            if (a[j] < key) {
                i++;
                swap(a, i, j);
            }
            j++;
        }
        swap(a, high, i+1);
        return i+1;
    }

    private static void swap(int[] a, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
