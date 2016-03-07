# 002 Add Two Numbers
## Question
[https://leetcode.com/problems/add-two-numbers/](https://leetcode.com/problems/add-two-numbers/)

You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

> Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
> Output: 7 -> 0 -> 8

## Answer
题意用反向链表表示数字，用例对应 342 + 465 = 807。

### 转化法
考虑数值和链表之间的互相转换方法。
比如链表->数值，复杂度$O(l)$，其中l链表长度：
```
LIST-2-NUM(node){

num = 0
mult = 1
while node != null 
    num = num + node.val * mult
    mult = mult * 10
    node = node.next
return num

}
```

同理数值->链表。因此两次LIST-2-NUM值加一次NUM-2-LIST，虽然复杂度还是$O(l1+l2+max{l1,l2})=O(max{l1,l2})$，但系数比较大。


## 双指针法
模仿加法运算，从低位到高位逐位相加：用两个指针分别同时扫描两个链表，取结点值进行相加，可能有进位，扫描可能不同时结束。:bangbang:这里很容易漏掉的是都扫描结束的时候，进位项上还有值，也就是结束条件得充分考虑l1.val、l2.val、jinwei。

对一个链表扫描结束，另一个未结束，可以使用尾复制，的伪代码如下：
```
ADD-TWO-NUMBERS(l1, l2){

head = new ListNode()
l3 = head 
jinwei = 0
while l1 != null and l2 != null
    tail = new ListNode()
    value = l1.val + l2.val + jinwei
    tail.val = value % 10
    jinwei = value / 10
    l1 = l1.next
    l2 = l2.next
    tail.next = null
    l3.next = tail
    l3 = l3.next
    
l = (l1 != null ? l1 : l2)      // 没扫描结束的链表
while l != null
     tail = new ListNode()
     value = l.val + jinwei
     tail.val = value % 10  
     jinwei = value / 10  
     l = l.next
     tail.next = null
     l3.next = tail
     l3 = l3.next  

if jinwei = 1
    l3 = new ListNode()
    l3.val = 1

return head.next    //根据题意，这里得是head.next

}
```

也可以使用哨兵方法，这里表现为指针指到null后原地踏步，且值为0，直到都扫描完毕。
```
ADD-TWO-NUMBERS(l1, l2){

head = new ListNode()
l3 = head 
jinwei = 0
while l1 != null or l2 != null
    tail = new ListNode()
    value = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + jinwei
    tail.val = value % 10
    jinwei = value / 10
    l1 = (l1 == null ? l1 : l1.next)
    l2 = (l2 == null ? l2 : l2.next)
    tail.next = null
    l3.next = tail
    l3 = l3.next

if jinwei = 1
    l3 = new ListNode()
    l3.val = 1
    
return head.next    //根据题意，这里得是head.next

}
```

一般来说，在写代码的的时候哨兵法更不容易出错，但效率低一点点。

综上，复杂度是系数较小的$O(max{l1,l2})$。