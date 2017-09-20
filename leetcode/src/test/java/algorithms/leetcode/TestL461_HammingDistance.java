package algorithms.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author N3 on 2017/9/19.
 */
public class TestL461_HammingDistance {

    @Test
    public void test() {
        int x = 49;
        int y = 84;
        assertEquals(hammingDistance(x, y), new L461_HammingDistance().hammingDistance(x, y));
    }

    /**
     * 练习位运算
     * @param x
     * @param y
     */
    private int hammingDistance(int x, int y) {
        return 0;
    }
}
