import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/2/5.
 */
public class SolutionTest {
    @Test
    public void test_1() {
        //given
        Solution solution = new Solution();
        //when
        int result = solution.myAtoi("-0003");
        //then
        assertEquals(-3, result);
    }

    @Test
    public void test_2() {
        //given
        Solution solution = new Solution();
        //when
        int result = solution.myAtoi("    010");
        //then
        assertEquals(10, result);
    }


    @Test
    public void test_3() {
        //given
        Solution solution = new Solution();
        //when
        int result = solution.myAtoi("  -0012a42");
        //then
        assertEquals(-12, result);
    }

    @Test
    public void test_4() {
        //given
        Solution solution = new Solution();
        //when
        int result = solution.myAtoi("");
        //then
        assertEquals(0, result);
    }

    @Test
    public void test_5() {
        //given
        Solution solution = new Solution();
        //when
        int result = solution.myAtoi("+1");
        //then
        assertEquals(1, result);
    }

    @Test
    public void test_6() {
        //given
        Solution solution = new Solution();
        //when
        int result = solution.myAtoi("2147483648");//int最大2147483647，此数上溢出
        //then
        assertEquals(2147483647, result);
    }

    @Test
    public void test_7() {
        //given
        Solution solution = new Solution();
        //when
        int result = solution.myAtoi("-2147483648");//int最小-2147483648，绝对值部分要避开上溢出判断
        //then
        assertEquals(-2147483648, result);
    }

    @Test
    public void test_8() {
        //given
        Solution solution = new Solution();
        //when
        int result = solution.myAtoi("-2147483649");//int最小-2147483648，绝对值部分要避开上溢出判断
        //then
        assertEquals(-2147483648, result);
    }

    @Test
    public void test_9() {
        //given
        Solution solution = new Solution();
        //when
        int result = solution.myAtoi(" b11228552307");
        //then
        assertEquals(0, result);
    }
}