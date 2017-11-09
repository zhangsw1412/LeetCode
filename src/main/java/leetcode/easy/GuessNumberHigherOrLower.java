package leetcode.easy;

/**
 * Created by zhangsw on 2017/11/9.
 */
public class GuessNumberHigherOrLower
{
	/*
	The guess API is defined in the parent class GuessGame.
    @param num, your guess
    @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
    int guess(int num);
    */
	class GuessGame
	{
		public int guess(int num)
		{
			return 0;
		}
	}

	class Solution extends GuessGame
	{
		//算middle的时候注意不要溢出
		//一种位操作写法是mid = (left & right) + ((left ^ right) >> 1)
		public int guessNumber(int n)
		{
			int left = 1, right = n, middle = left + (right - left) / 2, result;
			while ((result = guess(middle)) != 0)
			{
				if (result == -1)
				{
					right = middle;
				}
				else
				{
					left = middle + 1;
				}
				middle = left + (right - left) / 2;
			}
			return middle;
		}
	}
}
