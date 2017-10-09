package leetcode.easy;

/**
 * Created by zhangsw on 2017/9/21.
 */
public class ImplementStrStr
{
	class Solution
	{
		//应该是自己实现KMP算法，但是懒...写个简单版
		public int strStr(String haystack, String needle)
		{
			if (needle.length() == 0)
			{
				return 0;
			}
			if (haystack.length() < needle.length() || haystack == null || needle == null)
			{
				return -1;
			}
			for (int i = 0; i <= haystack.length() - needle.length(); ++i)
			{
				for (int j = 0; j < needle.length(); ++j)
				{
					if (haystack.charAt(i + j) != needle.charAt(j))
					{
						break;
					}
					if (j == needle.length() - 1)
					{
						return i;
					}
				}
			}
			return -1;
		}
	}
}
