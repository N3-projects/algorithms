package algorithms.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

/**
 * @author N3 on 2016/11/14.
 */
public class Test_292_NimGame {

    private _292_NimGame nimGame = new _292_NimGame();

    @Test
    public void test() {
        int n = new Random().nextInt(Integer.MAX_VALUE);
        System.out.println("test n=" + n);
        Assert.assertEquals(nimGame.isMustWin(n), isMustWin(n));
    }

    /**
     * 练习非递归实现
     */
    private boolean isMustWin(int n) {
        return false;
    }
}
