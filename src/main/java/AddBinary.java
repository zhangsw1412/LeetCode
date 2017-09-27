/**
 * Created by zhangsw on 2017/9/27.
 */
public class AddBinary
{
	class Solution
	{
		//尝试的第一个版本，但是有些测试用例的输入字符串过长，会造成parseInt抛异常
		public String addBinary(String a, String b)
		{
			int aInt = Integer.parseInt(a, 2);
			int bInt = Integer.parseInt(b, 2);
			int result = aInt + bInt;
			return Integer.toBinaryString(result);
		}
	}
}
