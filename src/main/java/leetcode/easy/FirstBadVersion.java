package leetcode.easy;

/**
 * Created by zhangsw on 2017/11/3.
 */
public class FirstBadVersion
{
	/*
	父类实现了isBadVersion的API，这里就是为了代码通顺写个样子
	 */
	class VersionControl
	{
		boolean isBadVersion(int version)
		{
			return true;
		}
	}

	class Solution extends VersionControl
	{
		//left+right有可能特别大造成溢出，所以mid的计算要注意
		public int firstBadVersion(int n)
		{
			int left = 1, right = n;
			while (left < right)
			{
				int mid = left + (right - left) / 2;
				if (isBadVersion(mid))
				{
					right = mid;
				}
				else
				{
					left = mid + 1;
				}
			}
			return left;
		}
	}
}
