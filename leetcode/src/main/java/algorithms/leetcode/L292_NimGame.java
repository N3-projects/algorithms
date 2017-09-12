package algorithms.leetcode;

/**
 * <p>你和你的朋友玩一个游戏：桌子上有一堆石头，每次可以拿走1-3个，最后一次拿走剩下所有石头的人获胜。<br>
 * 你可以先拿。
 * <p>写一个函数判断，在给定石头总个数的情况下，你是否可以必定获胜。
 *
 * @author N3 on 2016/11/14.
 */
public class L292_NimGame {

    /**
     * <P> <b>总结：</b><br>
     * 1. 通过简单枚举找到规律（可一行代码解决问题）<br>
     * 2. 除了枚举发现规律外，按正常逻辑，算法可关联斐波那契数列
     * <P> <b>优化：</b><br>
     * 采用非递归算法，降低复杂度
     *
     * @param n 石头总个数
     * @return 先手是否可以必胜
     * @see <a href="https://leetcode.com/problems/nim-game">nim-game</a>
     */
    public boolean isMustWin(int n) {
        if (n == 1 || n == 2 || n == 3) {
            return true;
        }
        int i = 4;
        boolean win_3 = true;
        boolean win_2 = true;
        boolean win_1 = true;
        // 当i>=4时，先手拿不完所有的石头，自己拿完后轮到对方拿
        // 第i次是否能取胜，取决于轮到对方拿时，对方能否能赢
        // 如果自己拿1-3个三种情况下，有任意一种情况对方不能赢，则自己可以赢
        boolean wini = !win_3 || !win_2 || !win_1;
        while (i < n) {
            i++;
            // 注意赋值顺序，从低位到高位
            win_3 = win_2;
            win_2 = win_1;
            win_1 = wini;
            wini = !win_3 || !win_2 || !win_1;
        }
        return wini;
    }
}
