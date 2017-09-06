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
            int key = a[start];
            int low = start;
            int high = end;
            while (low < high) {
                while (low < high && a[high] >= key) {  //这里>=很重要，若只是>，当数字有重复时会死循环
                    high--;
                }
                a[low] = a[high];
                while (low < high && a[low] <= key) {
                    low++;
                }
                a[high] = a[low];
            }
            a[low] = key;
            quickSortInternal(a, start, low - 1);
            quickSortInternal(a, low +1, end);
        }
    }
}
