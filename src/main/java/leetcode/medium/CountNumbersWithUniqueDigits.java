package leetcode.medium;

/**
 * Created by zhangsw on 2018/7/5.
 */
public class CountNumbersWithUniqueDigits
{
    class Solution
    {
        /*
        当n=1时因为只有一个数字，所以0-9都是答案．当n>=2时，最高位可以为1-9任意一个数字，
        之后各位可以选择的数字个数依次为9, 8, 7, 6...，上一位选一个下一位就少了一种选择
        通项公式为f(k) = 9 * 9 * 8 * ... (9 - k + 2)
         */
        public int countNumbersWithUniqueDigits(int n)
        {
            if (n == 0)
            {
                return 1;
            }
            if (n == 1)
            {
                return 10;
            }
            int result = 10, temp = 9;
            for (int i = 2; i <= n; i++)
            {
                temp *= (9 - i + 2);
                result += temp;
            }
            return result;
        }
    }
}
