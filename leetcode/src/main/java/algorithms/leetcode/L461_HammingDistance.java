package algorithms.leetcode;

/**
 * <p>汉明距离是指两个数字的二进制数字中相同位置上的不同数字的个数。<br>
 * 如1=0001,4=0100，那么1和4的汉明距离就是2
 * <p>写一个函数判断，在给定石头总个数的情况下，你是否可以必定获胜。
 *
 * @author N3 on 2016/11/14.
 */
public class L461_HammingDistance {

    /**
     * <P> <b>总结：</b><br>
     * 1. 相同位置上的不同数字，不难想到异或运算：相同为0，不同为1。<br>
     *    x和y的汉明距离即x^y的二进制数字中，1的个数
     * 2. << 左移<br>
     *    >> 右移<br>
     *    >>> 无符号右移<br>
     * 3. 如果一个整数不为0，则其二进制数中至少有1位为1
     * <P> <b>优化：</b><br>
     * 一个整数的二进制数中有多少个1，共有若干种算法，注意整数是否区分正整数和负整数
     * @see <a href="http://15838341661-139-com.iteye.com/blog/1642525">求二进制数中1的个数</a>
     *
     * @return 汉明距离
     * @see <a href="https://leetcode.com/problems/hamming-distance/description/">hamming-distance</a>
     */
    public int hammingDistance(int x, int y) {
        int n = x ^ y;
        return bitCount_minute1(n);
    }

    private int bitCount_minute1(int n) {
        int count = 0;
        while (n!=0) {
            count ++;
            n = (n-1) & n;
        }
        return count;
    }

    private int bitCount_nonSignRighMove(int n) {
        int count = 0;
        while (n!=0) {
            count += n & 1;
            n = n >>> 1;
        }
        return count;
    }
}
