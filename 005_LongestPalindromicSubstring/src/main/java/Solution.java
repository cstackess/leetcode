import java.util.Arrays;

/**
 * Created by Administrator on 2016/2/4.
 */
public class Solution {
    //加了cache还超时,1000个b要24ms，另一种3ms，心好痛……
/*
    int[][] cache;
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        cache = new int[chars.length][chars.length];
        int maxLength = 0;
        int maxLeft = 0;
        int maxRight = 0;
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (isPalindrome(chars, i, j) && j - i + 1 > maxLength) {
                    maxLeft = i;
                    maxRight = j;
                    maxLength = maxRight - maxLeft + 1;
                }
            }
        }
        return s.substring(maxLeft, maxRight + 1);
    }

    public boolean isPalindrome(char[] chars, int p, int q) {
        if (cache[p][q] == 0) {
            if (q - p <= 0) return true;//-1（aa）或者0（aba）
            if (chars[p] == chars[q]) {
                boolean isPld = isPalindrome(chars, p + 1, q - 1);
                cache[p][q] = isPld ? 1 : -1;
                return isPld;
            } else
                return false;
        } else {
            return cache[p][q] > 0;
        }
    }
*/
    //改了半天才AC，然而算法效率高
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 1) return s;
        if (chars.length == 2)
            return (chars[0] == chars[1]) ? s : "";
        int left = 0;
        int right = 1;
        int maxLength = 0;
        int p1 = 0, p2 = 1, p3 = 2;
        while (p3 < chars.length && p2 < chars.length) {
            while (chars[p1] != chars[p2] && p3 < chars.length && chars[p1] != chars[p3]) {
                p1 = p2;
                p2 = p3;
                p3++;
            }
            if (chars[p1] == chars[p2]) { //11（偶数或奇数多个）
                while (p2 < chars.length && chars[p1] == chars[p2]) {
                    p2++;
                }
                p2--;
                int split = p2;
                while (p1 >= 0 && p2 < chars.length && chars[p1] == chars[p2]) {
                    p1--;
                    p2++;
                }
                if (p2 - 1 - (p1 + 1) + 1 > maxLength) {
                    left = p1 + 1;
                    right = p2 - 1;
                    maxLength = right - left + 1;
                }
                p1 = split;
                p2 = split + 1;
                p3 = split + 2;
            } else if (p3 == chars.length)
                break;
            else if (chars[p1] == chars[p3]) { //101（奇数一个）
                int split = p2;
                while (p1 >= 0 && p3 < chars.length && chars[p1] == chars[p3]) {
                    p1--;
                    p3++;
                }
                if (p3 - 1 - (p1 + 1) + 1 > maxLength) {
                    left = p1 + 1;
                    right = p3 - 1;
                    maxLength = right - left + 1;
                }
                p1 = split;
                p2 = split + 1;
                p3 = split + 2;
            }
        }
        return s.substring(left, right + 1);
    }
}
