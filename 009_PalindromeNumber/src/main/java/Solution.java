/**
 * Created by Administrator on 2016/2/6.
 */
public class Solution {
    //原来负数不算回文……还可以用StringBuffer等的reverse方法
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int num = x;
        int w = num % 10;
        long result = 0;
        while (num > 0) {
            result = result * 10 + w;
            num = num / 10;
            w = num % 10;
            if (result > Integer.MAX_VALUE)
                return false;
        }
        return x == (int) result;
    }
}
