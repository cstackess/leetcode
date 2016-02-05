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
        int result = solution.reverse(-123);
        //then
        assertEquals(-321, result);
    }
    @Test
    public void test_2() {
        //given
        Solution solution = new Solution();
        //when
        int result = solution.reverse(10);
        //then
        assertEquals(1, result);
    }

    @Test
    public void test_3() {
        //given
        Solution solution = new Solution();
        //when
        int result = solution.reverse(1534236469);//int最大2147483647，逆向会溢出，由提示，溢出返回0
        //then
        assertEquals(0, result);
    }
}