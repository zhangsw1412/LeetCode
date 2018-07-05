package leetcode.medium;

/**
 * Created by zhangsw on 2018/7/5.
 */
public class SuperPow
{
    class Solution
    {
        public int superPow(int a, int[] b)
        {
            /*数学公式：
            (a^b) mod c = ((a mod c)^b)
            (x*y) mod c = ((x mod c)*(y mod c)) mod c :积的取余等于取余的积的取余
            */
            if (b.length == 0 || isZero(b))
            {
                return 1;
            }

            a = a % 1337;
            boolean flag = false;
            if (b[b.length - 1] % 2 == 1)
            {
                flag = true;  //幂次是奇数
            }
            div(b, 2);
            int ans = superPow(a, b);
            ans = (ans * ans) % 1337;
            if (flag)
            {
                ans = (ans * a) % 1337;
            }

            return ans;
        }

        boolean isZero(int[] num)
        {// 判断数组组成的整数是否为0
            for (int i = num.length - 1; i >= 0; i--)
            {
                if (num[i] > 0)
                {
                    return false;
                }
            }

            return true;
        }

        void div(int[] num, int y)
        {  //完成一次数组组成的整数的除法
            int tmp = 0;
            for (int i = 0; i < num.length; i++)
            {
                num[i] += tmp * 10;
                tmp = num[i] % y;
                num[i] = num[i] / y;
            }
        }
    }
}
