package algorithms.leetcode;

import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.assertEquals;

/**
 * @author N3 on 2016/11/14.
 */
public class TestL292_NimGame {

    private L292_NimGame nimGame = new L292_NimGame();

    @Test
    public void test() {
        int n = new Random().nextInt(Integer.MAX_VALUE);
        System.out.println("test n=" + n);
        assertEquals(nimGame.isMustWin(n), isMustWin(n));
    }

    /**
     * 练习非递归实现
     */
    private boolean isMustWin(int n) {
        return false;
    }
}
