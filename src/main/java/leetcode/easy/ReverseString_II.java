package leetcode.easy;

/**
 * Created by zhangsw on 2017/11/28.
 */
public class ReverseString_II
{
	class Solution
	{
		public String reverseStr(String s, int k)
		{
			StringBuilder stringBuilder = new StringBuilder(), temp;
			boolean flag = true;
			int end;
			for (int i = 0, len = s.length(); i < len; i += k)
			{
				end = Math.min(i + k, len);
				if (flag)
				{
					temp = new StringBuilder(s.substring(i, end));
					stringBuilder.append(temp.reverse());
				}
				else
				{
					stringBuilder.append(s.substring(i, end));
				}
				flag = !flag;
			}
			return stringBuilder.toString();
		}
	}
}
