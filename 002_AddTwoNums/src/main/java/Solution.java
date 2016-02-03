/**
 * Created by Administrator on 2016/2/3.
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        int jinwei = 0;
        int val = p1.val + p2.val + jinwei;
        jinwei = val / 10;
        ListNode head = new ListNode(val % 10);
        ListNode p3 = head;
        p1 = (p1 == null ? p1 : p1.next);
        p2 = (p2 == null ? p2 : p2.next);

        while (p1 != null || p2 != null) {
            val = (p1 == null ? 0 : p1.val) + (p2 == null ? 0 : p2.val) + jinwei;
            jinwei = val / 10;
            ListNode tail = new ListNode(val % 10);
            p3.next = tail;
            p3 = tail;
            p1 = (p1 == null ? p1 : p1.next);
            p2 = (p2 == null ? p2 : p2.next);
        }
        if (jinwei == 1)//注意进位问题
            p3.next = new ListNode(jinwei);
        return head;
    }
}
