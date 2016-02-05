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
        String result = solution.convert("0123456789", 3);
        //then
        assertEquals("0481357926", result);
    }
    @Test
    public void test_2() {
        //given
        Solution solution = new Solution();
        //when
        String result = solution.convert("PAYPALISHIRING", 3);
        //then
        assertEquals("PAHNAPLSIIGYIR", result);
    }
    @Test
    public void test_3() {
        //given
        Solution solution = new Solution();
        //when
        String result = solution.convert("ABCD", 4);
        //then
        assertEquals("ABCD", result);
    }
    @Test
    public void test_4() {
        //given
        Solution solution = new Solution();
        //when
        String result = solution.convert("ABCDEF", 5);
        //then
        assertEquals("ABCDFE", result);
    }
}