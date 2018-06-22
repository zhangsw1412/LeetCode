package leetcode.medium;

/**
 * Created by zhangsw on 2018/6/22.
 */
public class BulbSwitcher
{
    class Solution
    {
        /*
        当一个灯泡被执行偶数次switch操作时它是关着的，当被执行奇数次switch操作时它是开着的，那么这题就是要找出哪些编号的灯泡会被执行奇数次操作。
        现在假如我们执行第i次操作，即从编号i开始对编号每次+i进行switch操作，对于这些灯来说，
        如果其编号j（j=1,2,3,⋯,n）能够整除i，则编号j的灯需要执switch操作。
        具备这样性质的i是成对出现的，比如：
        j=12时，编号为12的灯，在第1次，第12次；第2次，第6次；第3次，第4次一定会被执行Switch操作，这样的话，编号为12的等肯定为灭。
        但是当完全平方数36就不一样了，因为他有一个特殊的因数6，这样当i=6时，只能被执行一次Switch操作，这样推出，完全平方数一定是亮着的，所以本题的关键在于找完全平方数的个数
         */
        public int bulbSwitch(int n)
        {
            return (int) Math.sqrt(n);
        }
    }
}
