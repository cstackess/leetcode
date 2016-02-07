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
//        isMatch("aa","a") → false
//        isMatch("aa","aa") → true
//        isMatch("aaa","aa") → false
        //then
//        assertFalse(solution.isMatch("aa", "a"));
//        assertTrue(solution.isMatch("aa", "aa"));//
//        assertFalse(solution.isMatch("aaa", "aa"));
        assertFalse(solution.isMatch("aaa", "aaaa"));
    }

    @Test
    public void test_2() {
        //given
        Solution solution = new Solution();
        //when
//        isMatch("aa", "a*") → true
//        isMatch("aa", ".*") → true
//        isMatch("ab", ".*") → true
//        isMatch("aab", "c*a*b") → true
        //then
        assertTrue(solution.isMatch("aa", "a*"));
        assertTrue(solution.isMatch("aa", ".*"));
        assertTrue(solution.isMatch("ab", ".*"));//ooooooo
        assertTrue(solution.isMatch("aab", "c*a*b"));
    }

    @Test
    public void test_3() {
        //given
        Solution solution = new Solution();
        //when
        //then
        assertFalse(solution.isMatch("ab", ".*c"));
    }

    @Test
    public void test_4() {
        //given
        Solution solution = new Solution();
        //when
        //then
        assertTrue(solution.isMatch("cbccbc", ".*c"));
    }
}