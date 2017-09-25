/**
 * Created by zhangsw on 2017/9/25.
 */
public class CountAndSay
{
	class Solution
	{
		//自己完成的版本
		public String countAndSay(int n)
		{
			StringBuilder stringBuilder = new StringBuilder("1");
			String last;
			int position, count;
			for (int i = 1; i < n; ++i)
			{
				last = stringBuilder.toString();
				stringBuilder = new StringBuilder();
				position = 1;
				count = 1;
				while ((position < last.length()))
				{
					if (last.charAt(position) == last.charAt(position - 1))
					{
						++count;
						++position;
					}
					else
					{
						stringBuilder.append(count);
						stringBuilder.append(last.charAt(position - 1));
						count = 1;
						++position;
					}
				}
				stringBuilder.append(count);
				stringBuilder.append(last.charAt(position - 1));
			}
			return stringBuilder.toString();
		}
	}

	public Solution getSolution()
	{
		return new Solution();
	}

	public static void main(String[] args)
	{
		CountAndSay countAndSay = new CountAndSay();
		Solution solution = countAndSay.getSolution();
		System.out.println(solution.countAndSay(6));
	}
}
