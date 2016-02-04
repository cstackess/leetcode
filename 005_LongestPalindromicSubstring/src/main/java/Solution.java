/**
 * Created by Administrator on 2016/2/4.
 */
public class Solution {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 1;
        int maxLength = 0;
        for (int p = 0, q = 1; q < chars.length; ) {
            if (chars[p] != chars[q]) {
                p = q;
                q++;
                continue;
            }
            while (chars[p] == chars[q]) {
                q++;
            }
            p--;
            while (chars[p] == chars[q]) {
                p--;
                q++;
            }
            if (q - 1 - (p + 1) + 1 > maxLength) {
                left = p + 1;
                right = q - 1;
                maxLength = right - left + 1;
            }
        }
        return s.substring(left, right + 1);
    }
}
