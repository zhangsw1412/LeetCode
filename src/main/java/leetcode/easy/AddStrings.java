package leetcode.easy;

/**
 * Created by zhangsw on 2017/11/14.
 */
public class AddStrings
{
	class Solution
	{
		public String addStrings(String num1, String num2)
		{
			char[] a = num1.toCharArray(), b = num2.toCharArray();
			int _a, _b, temp, carry = 0;
			StringBuilder stringBuilder = new StringBuilder();
			for (int i = a.length - 1, j = b.length - 1; (i >= 0 || j >= 0); --i, --j)
			{
				_a = i >= 0 ? a[i] - '0' : 0;
				_b = j >= 0 ? b[j] - '0' : 0;
				temp = _a + _b + carry;
				carry = temp > 9 ? 1 : 0;
				stringBuilder.append(temp % 10);
			}
			stringBuilder.append((carry == 1) ? 1 : "");
			return stringBuilder.reverse().toString();
		}
	}
}
