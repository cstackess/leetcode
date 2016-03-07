/**
 * Created by Administrator on 2016/2/3.
 */

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 0)
            return 0;
        int left = 0;
        int maxLength = 1;
        for (int j = 1; j < chars.length; j++) {
            int newChar = chars[j];
            //chars[left,...,j]中有跟newChar一样的重复值，则扔掉重复值左边所有的，更新left
            for (int k = j - 1; k >= left; k--) {
                if (newChar == chars[k]) {
                    left = k + 1;
                }
            }
            maxLength = Math.max(maxLength, j - left + 1);
        }
        return maxLength;
    }
}
