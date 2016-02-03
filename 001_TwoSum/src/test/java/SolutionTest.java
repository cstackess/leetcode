import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;

/**
 * Created by Administrator on 2016/2/2.
 */
public class SolutionTest {
    @Test
    public void test_1() {
        //given
        Solution solution = new Solution();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        //when
        int[] result = solution.twoSum(numbers, target);
        //then
        assertEquals(1, result[0]);
        assertEquals(2, result[1]);
    }


    @Test
    public void test_2() {
        //given
        Solution solution = new Solution();
        int[] numbers = {0, 4, 3, 0};
        int target = 0;
        //when
        int[] result = solution.twoSum(numbers, target);
        //then
        System.out.println(Arrays.toString(result));
        assertEquals(1, result[0]);
        assertEquals(4, result[1]);
    }

    @Test
    public void test_3() {
        //given
        Solution solution = new Solution();
        int[] numbers = {3, 2, 4};
        int target = 6;
        //when
        int[] result = solution.twoSum(numbers, target);
        //then
        assertEquals(2, result[0]);
        assertEquals(3, result[1]);
    }

    @Test
    public void test_binarySearch() {
        int[] arr = new int[]{4, 3, 0};
        Arrays.sort(arr);
        assertFalse(2 == Arrays.binarySearch(arr, 0));
    }
}