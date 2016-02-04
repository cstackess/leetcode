import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/2/3.
 */
public class SolutionTest {
    @Test
    public void test_1() {
        //given
        String text = "abcabcbb";
        Solution solution = new Solution();
        //when
        int length = solution.lengthOfLongestSubstring(text);
        //then
        assertEquals(3,length);
    }
    @Test
    public void test_2() {
        //given
        String text = "bbbbb";
        Solution solution = new Solution();
        //when
        int length = solution.lengthOfLongestSubstring(text);
        //then
        assertEquals(1,length);
    }
    @Test
    public void test_3() {
        //given
        String text = "abcdecabcd";
        Solution solution = new Solution();
        //when
        int length = solution.lengthOfLongestSubstring(text);
        //then
        assertEquals(5,length);
    }
    @Test
    public void test_4() {
        //given
        String text = "";
        Solution solution = new Solution();
        //when
        int length = solution.lengthOfLongestSubstring(text);
        //then
        assertEquals(0,length);
    }
}