package n3.algorithms.collections.arrays;

/**
 * 螺旋输出一个二维数组
 *
 * @author N3 on 2017/9/6.
 */
public class LuoxuanTwoDimensionalArray {

    public static void run(int[][] a) {
        int xStart = 0;
        int xEnd = a.length-1;
        int yStart = 0;
        int yEnd = a[0].length-1;
        int xIndex = 0;
        int yIndex = 0;
        while (xIndex <= xEnd) {
            System.out.println(a[xIndex][yStart]);
            xIndex ++;
        }
        yStart++;
        while (yIndex <= yEnd) {
            System.out.println(a[xIndex][yIndex]);
            yIndex++;
        }
        xEnd--;
        while (xIndex >= xStart) {
            System.out.println(a[xIndex][yEnd]);
            xIndex--;
        }
        yEnd--;
        while (yIndex >= yStart) {
            System.out.println(a[xStart][yIndex]);
            xIndex--;
        }
    }
}
