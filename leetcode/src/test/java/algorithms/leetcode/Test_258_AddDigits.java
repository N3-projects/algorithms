package algorithms.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

/**
 * @author yemaofpa on 2016/11/14.
 */
public class Test_258_AddDigits {

    private _258_AddDigits addDigits = new _258_AddDigits();

    @Test
    public void test() {
        int num = new Random().nextInt();
        Assert.assertEquals(addDigits.addDigits(num), addDigits(num));
    }

    private  int addDigits(int num) {
        return 0;
    }
}
