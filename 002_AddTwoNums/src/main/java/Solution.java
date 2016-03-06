import java.util.List;

/**
 * Created by Administrator on 2016/2/3.
 */
public class Solution {
    //毫无疑问，转成数字计算再转回来的方法效率更差。还是要对链接表直接操作。
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode head = new ListNode(-1);
        ListNode p3 = head;
        int jinwei = 0;
        while (p1 != null || p2 != null) {
            int value = (p1 == null ? 0 : p1.val) + (p2 == null ? 0 : p2.val) + jinwei;
            ListNode tail = new ListNode(value % 10);
            jinwei = value / 10;
            p3.next = tail;
            p3 = p3.next;
            p1 = (p1 == null ? p1 : p1.next);
            p2 = (p2 == null ? p2 : p2.next);
        }
        if (jinwei == 1)//注意进位问题
            p3.next = new ListNode(jinwei);
        return head.next;
    }
}
