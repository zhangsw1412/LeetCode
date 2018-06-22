package leetcode.medium;

/**
 * Created by zhangsw on 2018/6/22.
 */
public class SuperUglyNumber
{
    class Solution
    {
        public int nthSuperUglyNumber(int n, int[] primes)
        {
            int[] count = new int[primes.length];
            int[] res = new int[n];
            res[0] = 1;

            for (int i = 1; i < n; i++)
            {
                int min = Integer.MAX_VALUE;

                // 找出候选数字的最小值
                for (int j = 0; j < primes.length; j++)
                {
                    min = Math.min(min, primes[j] * res[count[j]]);
                }
                res[i] = min;

                // 增加与最终结果对应的质数的元素
                for (int j = 0; j < count.length; j++)
                {
                    // 所有符合条件的，都需增加对应prime index, 避免重复
                    if (res[count[j]] * primes[j] == min)
                    {
                        count[j]++;
                    }
                }
            }
            return res[n - 1];
        }
    }
}
