import java.util.Arrays;

/**
 * Created by zhangsw on 2017/9/17.
 */
public class TwoSum
{
	public static void main(String[] args)
	{
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		int[] result;
		Solution solution = new Solution();
		result = solution.twoSum(nums, target);
		System.out.print(Arrays.toString(result));
	}
}

class Solution
{
	//自己写的第一个版本
	public int[] twoSum(int[] nums, int target)
	{
		int arrayLength = nums.length;
		int[] result = new int[2];

		for (int i = 0; i < arrayLength; ++i)
		{
			result[0] = i;
			for (int j = i + 1; j < arrayLength; ++j)
			{
				if ((nums[i] + nums[j]) == target)
				{
					result[1] = j;
					return result;
				}
			}
		}
		return null;
	}
}