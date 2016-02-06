import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/2/6.
 */
public class SolutionTest {
    @Test
    public void test_1() {
        //given
        Solution solution = new Solution();
        //when
        boolean result = solution.isPalindrome(-12321);
        //then
        assertFalse(result);
    }

    @Test
    public void test_2() {
        //given
        Solution solution = new Solution();
        //when
        boolean result = solution.isPalindrome(1234567899);//上溢出
        //then
        assertFalse(result);
    }

    @Test
    public void test_3() {
        //given
        Solution solution = new Solution();
        //when
        boolean result = solution.isPalindrome(-2147447412);//下溢出
        //then
        assertFalse(result);
    }
}