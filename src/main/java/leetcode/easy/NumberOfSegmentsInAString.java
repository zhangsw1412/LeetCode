package leetcode.easy;

/**
 * Created by zhangsw on 2017/11/15.
 */
public class NumberOfSegmentsInAString
{
	class Solution
	{
		//原始的版本
		public int countSegments(String s)
		{
			s = s.replaceAll("\\s+", " ");
			return s.trim().length() == 0 ? 0 : s.trim().split(" ").length;
		}

		//上面的写法可以改进一下
		public int countSegments(String s)
		{
			return s.trim().length() == 0 ? 0 : s.trim().split("\\s+").length;
		}
	}
}
