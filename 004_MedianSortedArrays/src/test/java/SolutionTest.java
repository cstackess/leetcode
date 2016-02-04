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
        int[] nums1 = {1, 3, 5, 7};
        int[] nums2 = {2, 4, 6, 8};
        //when
        double median = solution.findMedianSortedArrays(nums1, nums2);
        //then
        assertEquals(4.5, median, 0.0001);
    }
    @Test
    public void test_2() {
        //given
        Solution solution = new Solution();
        int[] nums1 = {1, 3, 5, 7};
        int[] nums2 = {2};
        //when
        double median = solution.findMedianSortedArrays(nums1, nums2);
        //then
        assertEquals(3, median, 0.0001);
    }

}