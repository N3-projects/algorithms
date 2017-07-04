package algorithms.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

/**
 * @author N3 on 2016/11/14.
 */
public class Test_258_AddDigits {

    private No_258_AddDigits addDigits = new No_258_AddDigits();

    @Test
    public void test() {
        int num = new Random().nextInt();
        Assert.assertEquals(addDigits.addDigits(num), addDigits(num));
    }

    private  int addDigits(int num) {
        return 0;
    }
}
