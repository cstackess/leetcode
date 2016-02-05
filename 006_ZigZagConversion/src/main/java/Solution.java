import java.util.Arrays;

/**
 * Created by Administrator on 2016/2/5.
 */
public class Solution {

    //z型的余数部分（b相关）难做
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        int m = s.length();
        int r = numRows - 1;
        int a = m / (2 * r);
        int b = m % (2 * r);
        char[] chars = s.toCharArray();
        char[] newChars = new char[m];
        int count = 0;
        //行0
        for (int i = 0; i < a * 2 * r + (b > 0 ? 1 : 0) * 2 * r; i += 2 * r) {
            newChars[count++] = chars[i];
        }
        //行1~r-1
        for (int j = 1; j < r; j++) {
            for (int i = 0; i < a * 2 * r; i += 2 * r) {
                newChars[count++] = chars[i + j];
                newChars[count++] = chars[i + 2 * r - j];
            }
            if (b > j)
                newChars[count++] = chars[a * 2 * r + j];
            if (b > r + 1 && b - (r + 1) >= r - j)
                newChars[count++] = chars[a * 2 * r + 2 * r - j];
        }
        //行r
        for (int i = r; i <= a * 2 * r + (b > r ? 1 : 0) * 2 * r; i += 2 * r) {
            newChars[count++] = chars[i];
        }
        return String.valueOf(newChars).trim();
    }
}
