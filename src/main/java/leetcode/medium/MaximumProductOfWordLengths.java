package leetcode.medium;

/**
 * Created by zhangsw on 2018/6/22.
 */
public class MaximumProductOfWordLengths
{
    /*
    用一个int，32位；而小写字母只有26个，后26位用来表示对应的字符是否存在
    最后两个int相与，如果结果为0，说明两个对应的字符串没有相同的字符
     */
    public int maxProduct(String[] words)
    {
        int result = 0;
        int[] mask = new int[words.length];
        for (int i = 0; i < words.length; i++)
        {
            for (char c : words[i].toCharArray())
            {
                mask[i] |= (1 << (c - 'a'));
            }
            for (int j = 0; j < i; j++)
            {
                if ((mask[j] & mask[i]) == 0)
                {
                    result = Math.max(result, words[j].length() * words[i].length());
                }
            }
        }
        return result;
    }
}
