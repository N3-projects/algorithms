package n3.algorithms.fondation.sort;

/**
 * @author N3 on 2017/9/6.
 */
public class TestQuickSort {

    public static void main(String[] args) {
        int[] s = new int[]{7,3,2,45,4,34,74,2,9};
        QuickSort.sort(s);
        for (int i : s) {
            System.out.println(i);
        }
    }
}
