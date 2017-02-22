package algorithms.leetcode;

/**
 * 给定一个非负整数num，将其所有位数上的数字相加，如此循环，直到得到一个个位数数字。<br>
 * 举例：num = 38, 3 + 8 = 11, 1 + 1 = 2, 2即为结果。
 *
 * @author yemaofpa on 2017/2/14.
 */
public class _258_AddDigits {

    /**
     * <p>
     * <b>数根：</b><br>
     * 数根是将一正整数的各个位数相加（即横向相加），若加完后的值大于10的话，则继续以同样的方式相加，
     * 直到得到一个1位数,则所得的值为该数的数根<br>
     * </p>
     *
     * <p>
     * <b>同余：</b><br>
     * 两个整数a、b，若它们除以正整数m所得的余数相等，则称a、b对于模m同余<br>
     * <b>同余公式：</b><br>
     * dr(n) = 1 + ((n-1) mod 9)
     * </p>
     *
     * @see <a href="https://en.wikipedia.org/wiki/Digital_root">数根</a>
     *
     * @param num 非负整数
     * @return 一个1位数
     */
    public int addDigits(int num) {
        if (num < 0) {
            throw new IllegalArgumentException();
        }
        if (num == 0) {
            return 0;
        }
        if (num%9 ==0) {
            return 9;
        }
        return num%9;
    }
}
