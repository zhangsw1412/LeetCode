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
    }
}
