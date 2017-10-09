/**
 * Created by zhangsw on 2017/10/9.
 */
public class Sqrt_x
{
	class Solution
	{
		//这个方法仍然有点作弊，正常的解法是用牛顿开根法
		public int mySqrt(int a)
		{
			int result = 0;
			while (Math.pow(result, 2) <= a)
			{
				++result;
			}
			return result - 1;
		}
		//有点作弊的版本...
		/*
		public int mySqrt(int a)
		{
			return (int) Math.sqrt(a);
		}
		*/
	}
}
