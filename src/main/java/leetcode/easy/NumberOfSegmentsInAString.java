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
		/*
		public int countSegments(String s)
		{
			return s.trim().length() == 0 ? 0 : s.trim().split("\\s+").length;
		}
		*/

		//直接版
		/*
		public int countSegments(String s)
		{
			int res = 0;
			for (int i = 0; i < s.length(); i++)
			{
				if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' '))
				{
					res++;
				}
			}
			return res;
		}
		*/

		//一行版
		/*
		public int countSegments(String s)
		{
			return ("x " + s).split(" +").length - 1;
		}
		*/
	}
}
