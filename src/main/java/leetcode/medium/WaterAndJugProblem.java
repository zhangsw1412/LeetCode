package leetcode.medium;

/**
 * Created by zhangsw on 2018/7/5.
 */
public class WaterAndJugProblem
{
    class Solution
    {
        /*
         * 这道问题其实可以转换为有一个很大的容器，我们有两个杯子，容量分别为x和y，
         * 问我们通过用两个杯子往里倒水，和往出舀水，问能不能使容器中的水刚好为z升。
         * 那么我们可以用一个公式来表达：
         * z = m * x + n * y
         * 其中m，n为舀水和倒水的次数，正数表示往里舀水，负数表示往外倒水，
         * 那么题目中的例子可以写成: 4 = (-2) * 3 + 2 * 5，即3升的水罐往外倒了两次水，
         * 5升水罐往里舀了两次水。那么问题就变成了对于任意给定的x,y,z，存不存在m和n使得上面的等式成立。
         * 根据裴蜀定理，ax + by = d的解为 d = gcd(x, y)，那么我们只要只要z % d == 0，上面的等式就有解，
         * 所以问题就迎刃而解了，我们只要看z是不是x和y的最大公约数的倍数就行了，
         * 别忘了还有个限制条件x + y >= z，因为x和y不可能称出比它们之和还多的水
         **/
        public boolean canMeasureWater(int x, int y, int z)
        {
            return (z == 0) || ((x + y) >= z && z % gcd(x, y) == 0);
        }

        private int gcd(int x, int y)
        {
            return y == 0 ? x : gcd(y, x % y);
        }
    }
}
