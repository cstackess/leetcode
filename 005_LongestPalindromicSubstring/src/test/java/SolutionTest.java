import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/2/4.
 */
public class SolutionTest {
    @Test
    public void test_1() {
        //given
        Solution solution = new Solution();
        String text = "dmaa";
        //when
        String longestPalindrome = solution.longestPalindrome(text);
        //then
        assertEquals("aa", longestPalindrome);
    }
    @Test
    public void test_2() {
        //given
        Solution solution = new Solution();
        String text = "abcdddddcaa";//奇数多个
        //when
        String longestPalindrome = solution.longestPalindrome(text);
        //then
        assertEquals("cdddddc", longestPalindrome);
    }
    @Test
    public void test_3() {
        //given
        Solution solution = new Solution();
        String text = "cdcdc";//奇数单个，需3个指示器
        //when
        String longestPalindrome = solution.longestPalindrome(text);
        //then
        assertEquals("cdcdc", longestPalindrome);
    }
    @Test
    public void test_4() {
        //given
        Solution solution = new Solution();
        String text = "abcddcaabbbbcccbbbbaa";//更长
        //when
        String longestPalindrome = solution.longestPalindrome(text);
        //then
        assertEquals("aabbbbcccbbbbaa", longestPalindrome);
    }
    @Test
    public void test_5() {
        //given
        Solution solution = new Solution();
        String text = "aabbaabbaa";
        //when
        String longestPalindrome = solution.longestPalindrome(text);
        //then
        assertEquals("aabbaabbaa", longestPalindrome);
    }
    @Test
    public void test_6() {
        //given
        Solution solution = new Solution();
        String text = "aaabaaaa";
        String longestPalindrome = solution.longestPalindrome(text);
        //then
        assertEquals("aaabaaa", longestPalindrome);
    }
}