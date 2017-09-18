/**
 * Created by zhangsw on 2017/9/18.
 */
public class ReverseInteger
{
	class Solution
	{
		//自己写的第一个版本
		//如果不用边界做判断的话可以比较除以10前后是否相等来确定溢出
		public int reverse(int x)
		{
			long result = 0;
			while (x != 0)
			{
				result = result * 10 + x % 10;
				x /= 10;
			}
			if ((result < Integer.MIN_VALUE) || (result > Integer.MAX_VALUE))
			{
				result = 0;
			}
			return (int)result;
		}
	}

	public Solution getSolution()
	{
		return new Solution();
	}

	public static void main(String[] args)
	{
		ReverseInteger reverseInteger = new ReverseInteger();
		Solution solution = reverseInteger.getSolution();
		System.out.println(solution.reverse(1534236469));
		System.out.println(solution.reverse(-321));
	}
}


