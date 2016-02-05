/**
 * Created by Administrator on 2016/2/5.
 */
public class Solution {
    //服了，这么多种情况……
    public int myAtoi(String str) {
        char[] chars = str.trim().toCharArray();
        if (chars.length == 0)
            return 0;
        long result = 0;
        int sign = 1;
        if (chars[0] == '+') {
            sign = 1;
        } else if (chars[0] == '-') {
            sign = -1;
        } else if (Character.isDigit(chars[0])) {
            result = chars[0] - '0';
        } else
            return 0;
        for (int i = 1; i < chars.length; i++) {
            if (Character.isDigit(chars[i]))
                result = result * 10 + (chars[i] - '0');
            else break;
            if (sign == 1 && result > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (sign == -1 && -result < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }
        return (int) result * sign;
    }
}
