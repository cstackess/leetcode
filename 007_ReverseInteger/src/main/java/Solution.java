/**
 * Created by Administrator on 2016/2/5.
 */
public class Solution {
    public int reverse(int x) {
        long result = 0;
        int num = Math.abs(x);
        int w = num % 10;
        while (num > 0) { //不是w>0
            //溢出问题 http://bbs.csdn.net/topics/380252238
            /*
            if (w > Integer.MAX_VALUE - result * 10) //result * 10先溢出，因此不能用
            return 0;
            */
            result = result * 10 + w;
            num = num / 10;
            w = num % 10;
        }
        if (result > Integer.MAX_VALUE)
            return 0;
        return (int) result * (x > 0 ? 1 : -1);
    }
}
