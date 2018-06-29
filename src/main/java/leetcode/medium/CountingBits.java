package leetcode.medium;

/**
 * Created by zhangsw on 2018/6/29.
 */
public class CountingBits
{
    class Solution
    {
        public int[] countBits(int num)
        {
            int[] result = new int[num + 1];
            for (int i = 0; i <= num; i++)
            {
                int temp = i;
                while (temp != 0)
                {
                    ++result[i];
                    temp = temp & (temp - 1);
                }
            }
            return result;
        }

        /*
        简洁的思路
        f[i] = f[i / 2] + i % 2
         */
        /*
        public int[] countBits(int num)
        {
            int[] f = new int[num + 1];
            for (int i = 1; i <= num; i++)
            {
                f[i] = f[i >> 1] + (i & 1);
            }
            return f;
        }
        */
    }
}
