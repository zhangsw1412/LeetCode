package leetcode.medium;

/**
 * Created by zhangsw on 2018/3/13.
 */
public class CompareVersionNumbers
{
	class Solution
	{
		public int compareVersion(String v1, String v2)
		{
			String[] token1 = v1.split("\\.");
			String[] token2 = v2.split("\\.");
			int length = Math.max(token1.length, token2.length);
			for (int i = 0; i < length; ++i)
			{
				Integer a = i < token1.length ? Integer.valueOf(token1[i]) : 0;
				Integer b = i < token2.length ? Integer.valueOf(token2[i]) : 0;
				int result = a.compareTo(b);
				if (result != 0)
				{
					return result;
				}
			}
			return 0;
		}
	}
}
