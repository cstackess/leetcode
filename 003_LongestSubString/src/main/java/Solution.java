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
        for (int i = 1; i < chars.length; i++) {
            int newChar = chars[i];
            //如果cache([left,i])中有跟newChar一样的重复值，则扔掉重复值左边所有的，更新left
            for (int j = i - 1; j >= left; j--) {
                if (newChar == chars[j]) {
                    left = j + 1;
                }
            }
            maxLength = Math.max(maxLength, i - left + 1);
        }
        return maxLength;
    }
}
