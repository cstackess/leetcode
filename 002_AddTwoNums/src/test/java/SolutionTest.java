import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/2/3.
 */
public class SolutionTest {
    @Test
    public void test_buildLinkedList() {
        //given
        //when
        ListNode head = buildLinkedList(new int[]{2, 4, 3});
        //then
        assertEquals(2, head.val);
        assertEquals(4, head.next.val);
        assertEquals(3, head.next.next.val);
        //when
        head = buildLinkedList(new int[]{5, 6, 4});
        //then
        assertEquals(5, head.val);
        assertEquals(6, head.next.val);
        assertEquals(4, head.next.next.val);
    }

    @Test
    public void test_1() {
        //given
        Solution solution = new Solution();
        ListNode head1 = buildLinkedList(new int[]{2, 4, 3});
        ListNode head2 = buildLinkedList(new int[]{5, 6, 4});
        //when
        ListNode sum = solution.addTwoNumbers(head1, head2);
        //then
        assertEquals(7, sum.val);
        assertEquals(0, sum.next.val);
        assertEquals(8, sum.next.next.val);
    }

    @Test
    public void test_2() {
        //given
        Solution solution = new Solution();
        ListNode head1 = buildLinkedList(new int[]{2, 4, 9});
        ListNode head2 = buildLinkedList(new int[]{5, 6});
        //when
        ListNode sum = solution.addTwoNumbers(head1, head2);
        //then
        assertEquals(7, sum.val);
        assertEquals(0, sum.next.val);
        assertEquals(0, sum.next.next.val);
        assertEquals(1, sum.next.next.next.val);
    }


    public ListNode buildLinkedList(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode point = head;//java 是 拿引用
        for (int i = 1; i < arr.length; i++) {
            ListNode tail = new ListNode(arr[i]);
            point.next = tail;
            point = tail;
        }
        return head;
    }
}